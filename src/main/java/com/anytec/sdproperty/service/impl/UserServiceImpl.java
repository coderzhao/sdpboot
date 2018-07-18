package com.anytec.sdproperty.service.impl;

import com.anytec.sdproperty.dao.TbDoorMapper;
import com.anytec.sdproperty.dao.TbInitSessionMapper;
import com.anytec.sdproperty.dao.TbUserMapper;
import com.anytec.sdproperty.data.model.*;
import com.anytec.sdproperty.data.vo.OutputUserVo;
import com.anytec.sdproperty.data.vo.TbIpcVo;
import com.anytec.sdproperty.service.IpcService;

import com.anytec.sdproperty.service.BaseService;
import com.anytec.sdproperty.service.UserService;
import com.anytec.sdproperty.util.HTextUtils;
import com.anytec.sdproperty.util.Md5;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("UserService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private TbUserMapper mTbUserMapper;
    @Autowired
    private TbInitSessionMapper mInitSessionMapper;
    @Autowired
    private TbDoorMapper mTbDoorMapper;
    @Autowired
    private IpcService mIpcService;
//

    public OutputUserVo dologin(String username, String password) {
        try {
            OutputUserVo output = null;
            TbUserExample example = new TbUserExample();
            TbUserExample.Criteria c = example.createCriteria();
            c.andMobileEqualTo(username);
            List<TbUser> listUser = mTbUserMapper.selectByExample(example);
            if (listUser != null && listUser.size() > 0) {
                TbUser item = listUser.get(0);
                if (password.equalsIgnoreCase(password)) {
                    logger.info("user:" + item.getMobile() + " login success");
                    output = new OutputUserVo(item);
                    List<TbIpcVo> listIpcVo = mIpcService.getListPage(null, null, 1, 100, null, null);
                    output.setListIpcVo(listIpcVo);
                    return output;
                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {

        }
        logger.info("user:" + username + " login fail");
        return null;
    }


    @Override
    public TbUser getUserById(Integer id) throws HException {
        return mTbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public TbUser getUserByName(String name) throws HException {
        //mCacheService.flushDB();
        try {
            TbUserExample ue = new TbUserExample();
            ue.createCriteria().andNameEqualTo(name);
            List<TbUser> listUser =  mTbUserMapper.selectByExample(ue);
            if (listUser != null && listUser.size() > 0) {
                TbUser ret = listUser.get(0);
                return ret;
            } else {
                logger.info("has no user:" + name);
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new HException("没有当前名称用户");
        }
    }


    //取当前用户所属代理商及其下属代理商的所有用户
    public List<OutputUserVo> getListPage(TbUser self, TbUser param, int pageNum, int count, String order, String orderRule) {
        TbUserExample example = new TbUserExample();
        if (param != null) {
            TbUserExample.Criteria c = example.createCriteria();

            if (param.getMobile() != null && param.getMobile().length() > 0) {
                c.andMobileLike("%" + param.getMobile() + "%");
            }

            if (param.getName() != null && param.getName().length() > 0) {
                c.andNameLike("%" + param.getName() + "%");
            }
        }
        if (order == null || orderRule == null){
            example.setOrderByClause("id desc");
        } else{
            example.setOrderByClause(order + " " + orderRule);
        }
        PageHelper.startPage(pageNum, count);
        List<OutputUserVo> listVo = new ArrayList<OutputUserVo>();
        List<TbUser> listData = mTbUserMapper.selectByExample(example);
        if (listData != null && listData.size() > 0) {
            for (TbUser user : listData) {
                OutputUserVo vo = new OutputUserVo(user);
                if (user.getDoorId() != null) {
                    TbDoor door = mTbDoorMapper.selectByPrimaryKey(user.getDoorId());
                    if (null != door) {
                        vo.setDoorName(door.getName());
                    }
                }
                listVo.add(vo);
            }
        }

        return listVo;
    }

    public void delete(List<Integer> usersId) {
        for (int id : usersId) {
            mTbUserMapper.deleteByPrimaryKey(id);
        }
    }

    public TbUser addOrUpdate(TbUser user) {
        user.setCreateTime(new Date());
        if (user.getId() == null) {
            if (HTextUtils.isEmpty(user.getPassword())) {
                //如果创建用户没输入密码， 则默认六个8
                user.setPassword(Md5.getMD5Str("888888"));
            }
            mTbUserMapper.insert(user);
        } else {
            TbUser oldUser = mTbUserMapper.selectByPrimaryKey(user.getId());
            try {
                TbUser sameUsername = getUserByName(user.getMobile());
                if (sameUsername != null) {
                    throw new Exception("用户名: " + user.getName() + " 已存在");
                }
            } catch (Exception e) {

            }

            //如果用户没输入密码， 则用老密码
            if (HTextUtils.isEmpty(user.getPassword())) {
                user.setPassword(oldUser.getPassword());
            }
            mTbUserMapper.updateByPrimaryKey(user);
        }
        return user;
    }

    public int getCount(TbUser param) {
        TbUserExample example = new TbUserExample();
        if (param != null) {
            TbUserExample.Criteria c = example.createCriteria();
            if (param.getName() != null && param.getName().length() > 0) {
                c.andNameLike("%" + param.getName() + "%");
            }
            if (param.getMobile() != null && param.getMobile().length() > 0) {
                c.andMobileLike("%" + param.getMobile() + "%");
            }
        }
        return (int) (mTbUserMapper.countByExample(example));
    }

    //
}