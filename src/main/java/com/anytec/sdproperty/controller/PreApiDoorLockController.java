package com.anytec.sdproperty.controller;

import com.alibaba.fastjson.JSONObject;
import com.anytec.sdproperty.data.ErrorCode;
import com.anytec.sdproperty.data.model.TbDoorLock;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.data.vo.TbDoorLockVo;
import com.anytec.sdproperty.service.DoorLockService;
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
@RequestMapping("/PreApiDoorLock")

public class PreApiDoorLockController extends BaseWebPreController{
	private static final Logger logger = LoggerFactory.getLogger(PreApiDoorLockController.class);

	@Autowired
	private DoorLockService mDoorLockService;

	/***************************************************************************************
	 * 分页查询所有记录
	 * @return
	 * @throws Exception
	 ***************************************************************************************/
	@RequestMapping(value="/queryList.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, TbDoorLock param, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		//todo 分页查询所有的日志记录
		try {
			TbUser self = getTbUser(request);
			int pageNum = dgm.getPage();
			int count = dgm.getRows();
			if(count <= 0){
				count = 200;
			}
			String order = dgm.getSort();
			String rule = dgm.getOrder();

			logger.info("pageNum:" + pageNum + "count:" + count + "order:" + order + "rule:" + rule);

			List<TbDoorLockVo> listData;
			listData = mDoorLockService.getListPage(param, pageNum, count, order, rule);
			Map<String, Object> responseDataMap = new HashMap<String, Object>();
			responseDataMap.put("total", mDoorLockService.getCount(param));
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
			mDoorLockService.delete(id);

		}catch (Exception e){
			e.printStackTrace();
			logger.info(e.getMessage());
		}

		return ;//重定向
	}

	@RequestMapping(value="/addOrUpdate.do",method=RequestMethod.POST)
	@ResponseBody
	public void addOrUpdate(TbDoorLock input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{

		Map<String, String> map = new HashMap<String, String>();
		input.setCreateTime(new Date());
		try {
			mDoorLockService.addOrUpdate(input);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			throw e;
		}
		return;
	}

	@RequestMapping(value="/openDoor.do",method=RequestMethod.POST)
	@ResponseBody
	public boolean openDoor(Integer doorId, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		try {
			return mDoorLockService.openDoor(doorId);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return false;
		}
	}

}
