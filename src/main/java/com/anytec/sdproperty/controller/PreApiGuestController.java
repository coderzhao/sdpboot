package com.anytec.sdproperty.controller;

import com.alibaba.fastjson.JSONObject;
import com.anytec.sdproperty.data.ErrorCode;
import com.anytec.sdproperty.data.model.TbGuest;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.data.vo.TbGuestModifyRecordVo;
import com.anytec.sdproperty.data.vo.TbGuestVo;
import com.anytec.sdproperty.service.GuestService;
import com.anytec.sdproperty.service.SnapshotService;
import com.anytec.sdproperty.data.model.DataGridModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xuxinjian
 * @des: 访客列表管理，
 */
@Controller
@RequestMapping("/PreApiGuest")

public class PreApiGuestController extends BaseWebPreController{
	private static final Logger logger = LoggerFactory.getLogger(PreApiGuestController.class);

	@Autowired
	private GuestService mGuestService;
	@Autowired
	private SnapshotService mSnapShotService;

	/***************************************************************************************
	 * 分页查询所有记录
	 * @return
	 * @throws Exception
	 ***************************************************************************************/
	@RequestMapping(value="/queryList.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, TbGuest param, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		//todo 分页查询所有的日志记录
		try {
			int pageNum = dgm.getPage();
			int count = dgm.getRows();
			String order = dgm.getSort();
			String rule = dgm.getOrder();

			logger.info("pageNum:" + pageNum + "count:" + count + "order:" + order + "rule:" + rule);

			List<TbGuestVo> listData;
			listData = mGuestService.getListPage(param, pageNum, count, order, rule);
			if (listData == null) {
				listData = new ArrayList<TbGuestVo>();
			}
			Map<String, Object> responseDataMap = new HashMap<String, Object>(16);
			responseDataMap.put("total", mGuestService.getCount(param));
			responseDataMap.put("rows", listData);

			return responseDataMap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value="/queryListRecord.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryListRecord(DataGridModel dgm, TbGuest param, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		//todo 分页查询所有的日志记录
		try {
			int pageNum = dgm.getPage();
			int count = dgm.getRows();
			String order = dgm.getSort();
			String rule = dgm.getOrder();

			logger.info("pageNum:" + pageNum + "count:" + count + "order:" + order + "rule:" + rule);

			List<TbGuestModifyRecordVo> listData;
			listData = mGuestService.getListPageRecord(param, pageNum, count, order, rule);
			if (listData == null) {
				listData = new ArrayList<TbGuestModifyRecordVo>();
			}
			Map<String, Object> responseDataMap = new HashMap<String, Object>(16);
			responseDataMap.put("total", mGuestService.getCountRecord(param));
			responseDataMap.put("rows", listData);
			return responseDataMap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

	}


	/*
     * 删除访客
     */
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean delete(Integer[] id, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		try {
			TbUser user = getTbUser(request);
			if(user == null){
				logger.info("用户未登录！");
				return false;
			}
			if(id.length>0){
				for (Integer guestId : id){
					mGuestService.delete(user, guestId);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return true;
	}

	/**
	 *
	 * @param snapshotId 如果是从快照列表添加的访客身份， 需要讲快照id传递过来
	 * @param input
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addOrUpdate.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addOrUpdate(Integer snapshotId, TbGuest input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		logger.info("snapshotid:" + snapshotId + "|input:" + input.toString());

		Map<String, Object> map = new HashMap<String, Object>(16);
		input.setCreateTime(new Date());
		try {
			TbUser user = getTbUser(request);
			if(user == null){
				map.put("result", 0);
				map.put("mes", "用户未登录");
			}else {
				TbGuest guest = mGuestService.addOrUpdate(user, input);
				if(null != guest){
					// 成功
					if(snapshotId != null){
						//从快照列表添加的访客，需要更新快照 id对应的数据
						mSnapShotService.updateSnapshot(snapshotId, guest.getCode());
					}

					map.put("result", 1);
				}else{
					map.put("result", 0);
					map.put("mes", "增加或修改访客信息失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			map.put("result", 0);
			map.put("mes", "增加或修改访客信息失败");
		}
		return map;
	}

	@RequestMapping(value="/addImages.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addImages(Integer snapshotId, TbGuest input,
										   @RequestParam(value = "uploadImageList", required = true) List<String> imagePathList,
										   @RequestParam(value = "webroot", required = true) String webroot,
										 HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		logger.info("snapshotid:" + snapshotId + "|input:" + input.toString());

		Map<String, Object> map = new HashMap<String, Object>(16);
		input.setCreateTime(new Date());
		try {
			TbUser user = getTbUser(request);
			if(imagePathList.size()>0){
				String result = mGuestService.addImages(user, input,imagePathList,webroot);
				if(result.equals("Success")){
					// 成功
					map.put("result", 1);
				}
			}else{
				map.put("result", 0);
				map.put("mes", "批量增加访客失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			map.put("result", 0);
			map.put("mes", "批量增加访客失败");
		}
		return map;
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
	      DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
	      binder.registerCustomEditor(Date.class, dateEditor);
//	      super.initBinder(request, binder);
	}

}
