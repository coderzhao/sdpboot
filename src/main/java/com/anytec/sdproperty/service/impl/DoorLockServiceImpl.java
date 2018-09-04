package com.anytec.sdproperty.service.impl;


import com.anytec.sdproperty.config.GeneralConfig;
import com.anytec.sdproperty.dao.TbDoorLockMapper;
import com.anytec.sdproperty.dao.TbDoorMapper;
import com.anytec.sdproperty.data.model.*;
import com.anytec.sdproperty.data.vo.TbDoorLockVo;
import com.anytec.sdproperty.service.DoorLockService;
import com.anytec.sdproperty.service.DoorService;
import com.anytec.sdproperty.service.GuestRoleService;
import com.anytec.sdproperty.service.SDKService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("DoorLockService")
public class DoorLockServiceImpl implements DoorLockService {

    private static final Logger logger = LoggerFactory.getLogger(DoorLockServiceImpl.class);

    @Autowired
    private TbDoorLockMapper mTbDoorLockMapper;

    @Autowired
    private TbDoorMapper mTbDoorMapper;

    @Autowired
    private GuestRoleService guestRoleService;

    @Autowired
    private SDKService mSDKService;

    @Autowired
    private GeneralConfig generalConfig;

    public TbDoorLock addOrUpdate(TbDoorLock input){
        input.setCreateTime(new Date());
        if(input.getId() == null){
            mTbDoorLockMapper.insert(input);
        }else{
            mTbDoorLockMapper.updateByPrimaryKey(input);
        }
        return input;
    }

    //取当前用户所属代理商及其下属代理商的所有用户
    public List<TbDoorLockVo> getListPage(TbDoorLock param, int pageNum, int count, String order, String orderRule){

        TbDoorLockExample example = new TbDoorLockExample();
        if(param != null){
            TbDoorLockExample.Criteria c = example.createCriteria();

            if(param.getIp() != null && param.getIp().length() > 0){
                c.andIpLike("%" + param.getIp() + "%");
            }

            if(param.getName() != null && param.getName().length() > 0){
                c.andNameLike("%" + param.getName() + "%");
            }
        }
        if(order == null || orderRule == null)
            example.setOrderByClause("id desc");
        else
            example.setOrderByClause(order + " " + orderRule);
        if(pageNum == 0){
            pageNum = 1;
        }


        PageHelper.startPage(pageNum, count);
        List<TbDoorLockVo> listVo = new ArrayList<TbDoorLockVo>();
        Page<TbDoorLock> listData = mTbDoorLockMapper.selectByExample(example);
        if(listData != null && listData.size() > 0){
            for(TbDoorLock item : listData){
                TbDoorLockVo vo = new TbDoorLockVo(item);
                TbDoor door = mTbDoorMapper.selectByPrimaryKey(item.getDoorId());
                vo.setDoorName(door.getName());
                listVo.add(vo);
            }
        }

        return listVo;
    }

    public int getCount(TbDoorLock param){
        TbDoorLockExample example = new TbDoorLockExample();
        if(param != null){
            TbDoorLockExample.Criteria c = example.createCriteria();
            if(param.getName() != null && param.getName().length() > 0){
                c.andNameLike("%" + param.getName() + "%");
            }
            if(param.getIp() != null && param.getIp().length() > 0){
                c.andIpLike("%" + param.getIp() + "%");
            }
        }
        return (int)(mTbDoorLockMapper.countByExample(example));
    }

    public void delete(Integer id) {
        mTbDoorLockMapper.deleteByPrimaryKey(id);
    }

    public TbDoorLock getByDoorId(Integer id, boolean dangerFlag) {
        TbDoorLockExample example = new TbDoorLockExample();
        TbDoorLockExample.Criteria c = example.createCriteria();
        c.andDoorIdEqualTo(id);
        int dangerLevel = Integer.parseInt(generalConfig.getDoorType());
        if (dangerFlag) {
            c.andSecurityLevelEqualTo(dangerLevel);
        } else {
            c.andSecurityLevelNotEqualTo(dangerLevel);
        }
        List<TbDoorLock> listDoorLock = mTbDoorLockMapper.selectByExample(example);
        if (listDoorLock != null && listDoorLock.size() > 0) {
            return listDoorLock.get(0);
        } else {
            return null;
        }
    }

    public boolean openDoor(Integer id) {
            TbDoorLock lock = mTbDoorLockMapper.selectByPrimaryKey(id);
            mSDKService.flashOpenDoor(lock.getIp(), lock.getPort(), lock.getLine(), lock.getTime());
            return true;
    }


    @Override
    public void alarmDangerLock(TbDoorLock dangerLock) {
        logger.info("ip:" + dangerLock.getIp().toString());
        logger.info("Port:" + dangerLock.getPort().toString());
        logger.info("line:" + dangerLock.getLine().toString());
//                                logger.info("on_off:"+"1");
        logger.info("time:" + dangerLock.getTime().toString());
//					String url = "http://192.168.10.208:8888/";
        try {
            Request.Post(generalConfig.getSwitchAddress())
                    .connectTimeout(10000)
                    .socketTimeout(30000)
                    //							.addHeader("Authorization", "Token " + ntechToken)
                    .body(MultipartEntityBuilder
                            .create()
                            .addTextBody("ip", dangerLock.getIp())
                            .addTextBody("port", dangerLock.getPort().toString())
                            .addTextBody("line", dangerLock.getLine().toString())
                            .addTextBody("on_off", "1")
                            .addTextBody("time", dangerLock.getTime().toString())
                            .build())
                    .execute().returnResponse();
        } catch (Exception e) {
            logger.error("请求警报继电器异常：" + e.getMessage());
        }
    }

    @Override
    public void openDoorLock(TbDoorLock openLock,TbGuest guest,TbGuestRole role) {
        boolean needOpen = true;
        if (role.getLimitTime() != null) {//不为null
            if (role.getLimitTime()) {//不为false，则进入限制时间模式
                //如果限制开门时间
                Date now = new Date();
                if (guest.getLockStartTime() != null) {
                    if (now.getTime() < guest.getLockStartTime().getTime()) {
                        logger.info("fail opendoor当前时间小于允许开门的最小时间，不开门");
                        needOpen = false;//当前时间小于允许开门的最小时间，不开门
                    }
                }
                if (guest.getLockEndTime() != null) {
                    if (now.getTime() > guest.getLockEndTime().getTime()) {
                        //当前时间大于允许开门的最大时间， 不开门
                        logger.info("fail opendoor当前时间大于允许开门的最大时间， 不开门");
                        needOpen = false;
                    }
                }
            }
        }
        if (needOpen) {
            logger.info("ip:" + openLock.getIp().toString());
            logger.info("Port:" + openLock.getPort().toString());
            logger.info("line:" + openLock.getLine().toString());
//                                logger.info("on_off:"+"1");
            logger.info("time:" + openLock.getTime().toString());
//					String url = "http://192.168.10.208:8888/";
            try {
                Request.Post(generalConfig.getSwitchAddress())
                        .connectTimeout(10000)
                        .socketTimeout(30000)
                        //							.addHeader("Authorization", "Token " + ntechToken)
                        .body(MultipartEntityBuilder
                                .create()
                                .addTextBody("ip", openLock.getIp())
                                .addTextBody("port", openLock.getPort().toString())
                                .addTextBody("line", openLock.getLine().toString())
                                .addTextBody("on_off", "1")
                                .addTextBody("time", openLock.getTime().toString())
                                .build())
                        .execute().returnResponse();
            } catch (Exception e) {
                logger.error("请求开门继电器异常：" + e.getMessage());
            }
        }
//
    }


}
