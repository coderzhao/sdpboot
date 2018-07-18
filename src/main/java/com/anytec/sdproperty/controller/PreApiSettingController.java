package com.anytec.sdproperty.controller;

import com.anytec.sdproperty.dao.TbSysMapper;
import com.anytec.sdproperty.data.ErrorCode;
import com.anytec.sdproperty.data.model.TbSys;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.service.SettingService;
import com.anytec.sdproperty.data.model.DataGridModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuxinjian
 * @des: 管理后台用，
 */
@Controller
@RequestMapping("/PreApiSetting")

public class PreApiSettingController extends BaseWebPreController{
	private static final Logger logger = LoggerFactory.getLogger(PreApiSettingController.class);

	@Autowired
	private SettingService mSettingService;
	@Autowired
	private TbSysMapper mTbSysMapper;
	@Autowired
	private SettingService settingService;

	/***************************************************************************************
	 * 分页查询所有记录
	 * @return
	 * @throws Exception
	 ***************************************************************************************/
	@RequestMapping(value="/queryList.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, TbSys param, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		//todo 分页查询所有的日志记录
		try {
			TbUser self = getTbUser(request);

			int pageNum = dgm.getPage();
			int count = dgm.getRows();
			String order = dgm.getSort();
			String rule = dgm.getOrder();

			logger.info("pageNum:" + pageNum + "count:" + count + "order:" + order + "rule:" + rule);

			List<TbSys> listData = mSettingService.getListPage(pageNum, count, order, rule);
			Map<String, Object> responseDataMap = new HashMap<String, Object>();
			responseDataMap.put("total", mSettingService.getCount());
			responseDataMap.put("rows", listData);

//			super.outputRespBody(response, session, responseDataMap);
			return responseDataMap;
		}catch(Exception e){
			logger.error(e.getMessage());
			return null;
		}

	}

	/*
     * 删除设置
     */
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	@ResponseBody
	public void delete(Integer id, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		try {
			mTbSysMapper.deleteByPrimaryKey(id);

		}catch (Exception e){
			e.printStackTrace();
			logger.info(e.getMessage());
		}

		return ;//重定向
	}

	@RequestMapping(value="/addOrUpdate.do",method=RequestMethod.POST)
	@ResponseBody
	public void addOrUpdate(TbSys input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		String username= (String) WebUtils.getSessionAttribute(request, "username");
		input.setUpdateTime(new Date());
		input.setUpdateUserId(username);

		Map<String, String> map = new HashMap<String, String>();
		try {
			mSettingService.addOrUpdate(input);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			throw e;
		}
		return;
	}

	/*
     * 查询监控画面标题
     */
	@RequestMapping(value = "/querySysName.do", method = RequestMethod.GET)
	@ResponseBody
	public TbSys querySysName() {
		TbSys tbSys = settingService.getByKeyName(SettingService.KEY_SYSNAME);
		return tbSys;//
	}
}
