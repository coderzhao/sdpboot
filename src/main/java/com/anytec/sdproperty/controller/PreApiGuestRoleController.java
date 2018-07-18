package com.anytec.sdproperty.controller;

import com.alibaba.fastjson.JSONObject;
import com.anytec.sdproperty.data.ErrorCode;
import com.anytec.sdproperty.data.model.TbGuestRole;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.service.GuestRoleService;
import com.anytec.sdproperty.data.model.DataGridModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author xuxinjian
 * @des: 管理后台用，
 */
@Controller
@RequestMapping("/PreApiGuestRole")

public class PreApiGuestRoleController extends BaseWebPreController{
	private static final Logger logger = LoggerFactory.getLogger(PreApiGuestRoleController.class);

	@Autowired
	private GuestRoleService mGuestRoleService;

	/***************************************************************************************
	 * 分页查询所有记录
	 * @return
	 * @throws Exception
	 ***************************************************************************************/
	@RequestMapping(value="/queryList.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, TbGuestRole param, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		//todo 分页查询所有的日志记录
		try {
//			int ret = this.requestProcess(request, session, false);
//			if(ret != ErrorCode.EC_OK){
//				//请求出错
//				this.respondException(response, session, ret, errorMessageList.get(0));
//				return;
//			}

			TbUser self = getTbUser(request);
			int pageNum = dgm.getPage();
			int count = dgm.getRows();
			String order = dgm.getSort();
			String rule = dgm.getOrder();

			logger.info("pageNum:" + pageNum + "count:" + count + "order:" + order + "rule:" + rule);

			List<TbGuestRole> listData;
			listData = mGuestRoleService.getListPage(self, param, pageNum, count, order, rule);
			if (listData == null)
				listData = new ArrayList<TbGuestRole>();
			Map<String, Object> responseDataMap = new HashMap<String, Object>();
			responseDataMap.put("total", mGuestRoleService.getCount(param));
			responseDataMap.put("rows", listData);
			return responseDataMap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

	}

	/*
     * 删除用户
     */
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	@ResponseBody
	public void delete(Integer id, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		try {
			mGuestRoleService.delete(id);

		}catch (Exception e){
			e.printStackTrace();
			logger.info(e.getMessage());
		}

		return ;//重定向
	}

	@RequestMapping(value="/addOrUpdate.do",method=RequestMethod.POST)
	@ResponseBody
	public void addOrUpdate(TbGuestRole input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{

		Map<String, String> map = new HashMap<String, String>();
		input.setCreateTime(new Date());
		try {
			mGuestRoleService.addOrUpdate(input);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			throw e;
		}
		return;
	}


	@RequestMapping(value="/getAllGuestRole.do",method=RequestMethod.POST)
	@ResponseBody
	public List<TbGuestRole> getAllGuestRole(HttpServletRequest request, HttpSession session) throws Exception{
		//spring会利用jackson自动将返回值封装成JSON对象，比struts2方便了很多
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info("getAllGuestRole:11" );
		try {
			//mAgentService.addOrUpdate(item);
			List<TbGuestRole> listVO;
			TbUser self = getTbUser(request);
			listVO = mGuestRoleService.getListPage(self, null, 1, 200, null, null);
			return listVO;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			throw e;
		}
	}

	@RequestMapping(value="/getAllGuestRoleWithUnknown.do",method=RequestMethod.POST)
	@ResponseBody
	public List<TbGuestRole> getAllGuestRoleWithUnknown(HttpServletRequest request, HttpSession session) throws Exception{
		//spring会利用jackson自动将返回值封装成JSON对象，比struts2方便了很多
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info("getAllGuestRole:11" );
		try {
			//mAgentService.addOrUpdate(item);
			List<TbGuestRole> listVO;
			TbUser self = getTbUser(request);
			listVO = mGuestRoleService.getListPage(self, null, 1, 200, null, null);
			{
				TbGuestRole role = new TbGuestRole();
				role.setName("全部");
				role.setId(0);
				role.setAutoOpenDoor((byte)0);
				listVO.add(0, role);
			}

			{
				TbGuestRole role = new TbGuestRole();
				role.setName("未知");
				role.setId(-1);
				role.setAutoOpenDoor((byte)0);
				listVO.add(role);
			}

			return listVO;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			throw e;
		}
	}
}
