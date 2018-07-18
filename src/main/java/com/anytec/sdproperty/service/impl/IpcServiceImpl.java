package com.anytec.sdproperty.service.impl;


import com.anytec.sdproperty.dao.TbDoorMapper;
import com.anytec.sdproperty.dao.TbIpcMapper;
import com.anytec.sdproperty.data.model.TbDoor;
import com.anytec.sdproperty.data.model.TbIpc;
import com.anytec.sdproperty.data.model.TbIpcExample;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.data.vo.TbIpcVo;
import com.anytec.sdproperty.service.IpcService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("IpcService")
public class IpcServiceImpl implements IpcService {
    private static final Logger logger = LoggerFactory.getLogger(IpcServiceImpl.class);
    @Autowired
    private TbIpcMapper mTbIpcMapper;
    @Autowired
    private TbDoorMapper mTbDoorMapper;
//	@Autowired
//	private SDKService mSDKService;


    @Override
    public TbIpc getByName(String name) throws HException {
        try {
            TbIpcExample ue = new TbIpcExample();
            ue.createCriteria().andNameEqualTo(name);
            List<TbIpc> listIpc =  mTbIpcMapper.selectByExample(ue);
            if (listIpc != null && listIpc.size() > 0) {
                TbIpc ret = listIpc.get(0);
                return ret;
            } else {
                logger.info("has no Ipc:" + name);
                return null;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new HException("没有当前名称的门岗");
        }
    }

    @Override
    public TbIpc getById(Integer id) throws HException{
        return mTbIpcMapper.selectByPrimaryKey(id);
    }

    //取当前用户所属代理商及其下属代理商的所有用户
    public List<TbIpcVo> getListPage(TbUser self, TbIpc param, int pageNum, int count, String order, String orderRule){

        TbIpcExample example = new TbIpcExample();
        if(param != null){
            TbIpcExample.Criteria c = example.createCriteria();

            if(param.getAddress() != null && param.getAddress().length() > 0){
                c.andAddressLike("%" + param.getAddress() + "%");
            }

            if(param.getName() != null && param.getName().length() > 0){
                c.andNameLike("%" + param.getName() + "%");
            }
        }
        if(order == null || orderRule == null)
            example.setOrderByClause("id desc");
        else
            example.setOrderByClause(order + " " + orderRule);

        PageHelper.startPage(pageNum, count);
        Page<TbIpc> listData = mTbIpcMapper.selectByExample(example);
        List<TbIpcVo> listVo = new ArrayList<TbIpcVo>();
        if(listData != null && listData.size() > 0){
            for(TbIpc item : listData){
                TbDoor door = mTbDoorMapper.selectByPrimaryKey(item.getDoorId());
                TbIpcVo vo = new TbIpcVo(item);
                if(null !=door){
                    vo.setDoorName(door.getName());
                }
                listVo.add(vo);
            }
        }

        return listVo;
    }

    public void delete(Integer id){
        TbIpc ipc = mTbIpcMapper.selectByPrimaryKey(id);
        if(ipc != null) {
            mTbIpcMapper.deleteByPrimaryKey(id);
            //此处需要调用sdk的接口
//				mSDKService.deleteCamera(ipc);
        }
    }

    public TbIpc addOrUpdate(TbIpc Ipc){
        Ipc.setCreateTime(new Date());
        if(Ipc.getId() == null){
            mTbIpcMapper.insert(Ipc);
        }else{
            TbIpc oldIpc = mTbIpcMapper.selectByPrimaryKey(Ipc.getId());
            try{
                TbIpc sameIpcname = getByName(oldIpc.getName());
                if(sameIpcname != null){
                    throw new Exception("名称: " + Ipc.getName() + " 已存在");
                }
            }catch(Exception e){

            }
            mTbIpcMapper.updateByPrimaryKey(Ipc);
        }
        //此处需要调用sdk的接口
//		String camera_id = mSDKService.addCamera(Ipc);
//		if(camera_id != null){
//			Ipc.setCameraId(camera_id);
//			mTbIpcMapper.updateByPrimaryKey(Ipc);
//		}

        return Ipc;
    }

    public int getCount(TbIpc param){
        TbIpcExample example = new TbIpcExample();
        if(param != null){
            TbIpcExample.Criteria c = example.createCriteria();
            if(param.getName() != null && param.getName().length() > 0){
                c.andNameLike("%" + param.getName() + "%");
            }
            if(param.getAddress() != null && param.getAddress().length() > 0){
                c.andAddressLike("%" + param.getAddress() + "%");
            }
        }
        return (int)(mTbIpcMapper.countByExample(example));
    }

    public List<TbIpc> getAllIpc(){
        TbIpcExample example = new TbIpcExample();
        example.setOrderByClause("id desc");
        List<TbIpc> listData = mTbIpcMapper.selectByExample(example);
        return listData;
    }

    @Override
    public TbIpc getByAddress(String mac) throws HException {
        try {
            TbIpcExample ue = new TbIpcExample();
            ue.createCriteria().andAddressEqualTo(mac.trim());
            List<TbIpc> listIpc =  mTbIpcMapper.selectByExample(ue);
            if (listIpc != null && listIpc.size() > 0) {
                TbIpc ret = listIpc.get(0);
                return ret;
            } else {
                logger.info("has no Ipc:address=" + mac);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new HException("没有当前名称的门岗");
        }
    }
}
