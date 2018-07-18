package com.anytec.sdproperty.service.impl;


import com.anytec.sdproperty.dao.TbDoorMapper;
import com.anytec.sdproperty.data.model.TbDoor;
import com.anytec.sdproperty.data.model.TbDoorExample;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.service.DoorService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("DoorService")
public class DoorServiceImpl implements DoorService {
	private static final Logger logger = LoggerFactory.getLogger(DoorServiceImpl.class);
	@Autowired
	private TbDoorMapper mTbDoorMapper;


	@Override
	public TbDoor getDoorByName(String name) throws HException {
		try {
			TbDoorExample ue = new TbDoorExample();
			ue.createCriteria().andNameEqualTo(name);
			List<TbDoor> listDoor =  mTbDoorMapper.selectByExample(ue);
			if (listDoor != null && listDoor.size() > 0) {
				TbDoor ret = listDoor.get(0);
				return ret;
			} else {
				logger.info("has no Door:" + name);
				return null;
			}
		}catch (Exception e){
			logger.error(e.getMessage());
			throw new HException("没有当前名称的门岗");
		}
	}

	@Override
	public TbDoor getDoorById(Integer id) throws HException{
		return mTbDoorMapper.selectByPrimaryKey(id);
	}

	//取当前用户所属代理商及其下属代理商的所有用户
	public List<TbDoor> getListPage(TbUser self, TbDoor param, int pageNum, int count, String order, String orderRule){

		TbDoorExample example = new TbDoorExample();
		if(param != null){
			TbDoorExample.Criteria c = example.createCriteria();

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
		if(pageNum == 0){
			pageNum = 1;
		}
		PageHelper.startPage(pageNum, count);
		Page<TbDoor> listData = mTbDoorMapper.selectByExample(example);
		if(listData == null){
			return new ArrayList<TbDoor>();
		}

		return listData;
	}

	public void delete(Integer id){
			mTbDoorMapper.deleteByPrimaryKey(id);
	}

	public TbDoor addOrUpdate(TbDoor Door){
		Door.setCreateTime(new Date());
		if(Door.getId() == null){
			mTbDoorMapper.insert(Door);
		}else{
			TbDoor oldDoor = mTbDoorMapper.selectByPrimaryKey(Door.getId());
			try{
				TbDoor sameDoorname = getDoorByName(oldDoor.getName());
				if(sameDoorname != null){
					throw new Exception("名称: " + Door.getName() + " 已存在");
				}
			}catch(Exception e){

			}
			mTbDoorMapper.updateByPrimaryKey(Door);
		}
		return Door;
	}

	public int getCount(TbDoor param){
		TbDoorExample example = new TbDoorExample();
		if(param != null){
			TbDoorExample.Criteria c = example.createCriteria();
			if(param.getName() != null && param.getName().length() > 0){
				c.andNameLike("%" + param.getName() + "%");
			}
			if(param.getAddress() != null && param.getAddress().length() > 0){
				c.andAddressLike("%" + param.getAddress() + "%");
			}
		}
		return (int)(mTbDoorMapper.countByExample(example));
	}
}
