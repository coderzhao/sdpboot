package com.anytec.sdproperty.controller;

import com.alibaba.fastjson.JSONObject;
import com.anytec.sdproperty.data.ErrorCode;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.data.vo.OutputUserVo;
import com.anytec.sdproperty.service.UserService;
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
 * @des: 管理后台用， 用来管理日志记录
 */
@Controller
@RequestMapping("/PreApiUser")

public class PreApiUserController extends BaseWebPreController{
	private static final Logger logger = LoggerFactory.getLogger(PreApiUserController.class);

	@Autowired
	private UserService mUserService;

	//管理平台登录
	@RequestMapping(value="/dologin.do",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> dologin(String username, String password, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			OutputUserVo vo = mUserService.dologin(username, password);
			if(vo != null){
				map.put("code", 0);
				map.put("user", vo);
//				session.setAttribute("type", vo.getRoleId());
				session.setAttribute("username", username);
				session.setAttribute("OutputUserVo", vo);
				map.put("msg", "访客添加成功");
			}else{
				map.put("code", 100);
				map.put("msg", "登录失败，请检查用户名密码");
			}
			return map;
		}catch(Exception e){
			return null;
		}
	}
//
	/***************************************************************************************
	 * 分页查询所有记录
	 * @return
	 * @throws Exception
	 ***************************************************************************************/
	@RequestMapping(value="/queryUserList.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryUserList(DataGridModel dgm, TbUser param, HttpServletRequest request, HttpServletResponse response, HttpSession session)
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

			List<OutputUserVo> listData;
			listData = mUserService.getListPage(self, param, pageNum, count, order, rule);
			if (listData == null)
				listData = new ArrayList<OutputUserVo>();
			Map<String, Object> responseDataMap = new HashMap<String, Object>();
			responseDataMap.put("total", mUserService.getCount(param));
			responseDataMap.put("rows", listData);

//			super.outputRespBody(response, session, responseDataMap);
			return responseDataMap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

	}

	/*
     * 删除用户
     */
	@RequestMapping(value = "/deleteUsers.do", method = RequestMethod.POST)
	@ResponseBody
	public void deleteUser(Integer id, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		try {
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(id);
			mUserService.delete(ids);

		}catch (Exception e){
			e.printStackTrace();
			logger.info(e.getMessage());
		}

		return ;//重定向
	}

	@RequestMapping(value="/addOrUpdate.do",method=RequestMethod.POST)
	@ResponseBody
	public void addOrUpdate(TbUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		//spring会利用jackson自动将返回值封装成JSON对象，比struts2方便了很多
//		int ret = this.requestProcess(request, session, true);
//		if(ret != ErrorCode.EC_OK){
//			//请求出错
//			this.respondException(response, session, ret, errorMessageList.get(0));
//			return;
//		}
//		TbUser user;
//		JSONObject j = JSONObject.parseObject(requestJson);
//		user = (TbUser)j.getObject("TbUser", TbUser.class);

		Map<String, String> map = new HashMap<String, String>();
		user.setCreateTime(new Date());
		try {
			mUserService.addOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			throw e;
		}
		return;
	}


	private long getCurTime(){
		return new Date().getTime();
	}

	private void logCost(long begin){
		long cost = new Date().getTime() - begin;
		if(cost > 1000){
			//查询时间超过1s的接口
//			logger.info();
		}
	}



}
