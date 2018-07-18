package com.anytec.sdproperty.service.impl;


import com.anytec.sdproperty.dao.TbGuestRoleMapper;
import com.anytec.sdproperty.data.model.TbGuestRole;
import com.anytec.sdproperty.data.model.TbGuestRoleExample;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.service.GuestRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("GuestRoleService")
public class GuestRoleServiceImpl implements GuestRoleService {
	private static final Logger logger = LoggerFactory.getLogger(GuestRoleServiceImpl.class);
	@Autowired
	private TbGuestRoleMapper mTbGuestRoleMapper;



	public TbGuestRole getByName(String name) throws HException {
		try {
			TbGuestRoleExample ue = new TbGuestRoleExample();
			ue.createCriteria().andNameEqualTo(name);
			List<TbGuestRole> listGuestRole = mTbGuestRoleMapper.selectByExample(ue);
			if (listGuestRole != null && listGuestRole.size() > 0) {
				TbGuestRole ret = listGuestRole.get(0);
				return ret;
			} else {
				logger.info("has no GuestRole:" + name);
				return null;
			}
		}catch (Exception e){
			logger.error(e.getMessage());
			throw new HException("没有当前名称的访客角色");
		}
	}

	public TbGuestRole getById(Integer id){
		return mTbGuestRoleMapper.selectByPrimaryKey(id);
	}

	//取当前用户所属代理商及其下属代理商的所有用户
	public List<TbGuestRole> getListPage(TbUser self, TbGuestRole param, int pageNum, int count, String order, String orderRule){

		TbGuestRoleExample example = new TbGuestRoleExample();
		if(param != null){
			TbGuestRoleExample.Criteria c = example.createCriteria();

			if(param.getName() != null && param.getName().length() > 0){
				c.andNameLike("%" + param.getName() + "%");
			}
		}
		if(order == null || orderRule == null)
			example.setOrderByClause("id desc");
		else
			example.setOrderByClause(order + " " + orderRule);
		PageHelper.startPage(pageNum, count);
		Page<TbGuestRole> listData = mTbGuestRoleMapper.selectByExample(example);
		if(listData == null){
			return new ArrayList<TbGuestRole>();
		}

		return listData;
	}

	public void delete(Integer id){
			mTbGuestRoleMapper.deleteByPrimaryKey(id);
	}

	public TbGuestRole addOrUpdate(TbGuestRole GuestRole){
		GuestRole.setCreateTime(new Date());
		if(GuestRole.getId() == null){
			mTbGuestRoleMapper.insert(GuestRole);
		}else{
			TbGuestRole oldGuestRole = mTbGuestRoleMapper.selectByPrimaryKey(GuestRole.getId());
			try{
				TbGuestRole sameGuestRolename = getByName(oldGuestRole.getName());
				if(sameGuestRolename != null){
					throw new Exception("名称: " + GuestRole.getName() + " 已存在");
				}
			}catch(Exception e){

			}
			mTbGuestRoleMapper.updateByPrimaryKey(GuestRole);
		}
		return GuestRole;
	}

	public int getCount(TbGuestRole param){
		TbGuestRoleExample example = new TbGuestRoleExample();
		if(param != null){
			TbGuestRoleExample.Criteria c = example.createCriteria();
			if(param.getName() != null && param.getName().length() > 0){
				c.andNameLike("%" + param.getName() + "%");
			}

		}
		return (int)(mTbGuestRoleMapper.countByExample(example));
	}

	public List<TbGuestRole> getAllGuestRole(){
		TbGuestRoleExample example = new TbGuestRoleExample();
		example.setOrderByClause("id desc");
		List<TbGuestRole> listData = mTbGuestRoleMapper.selectByExample(example);
		if(listData == null){
			listData = new ArrayList<TbGuestRole>();
		}
		return listData;
	}
}
