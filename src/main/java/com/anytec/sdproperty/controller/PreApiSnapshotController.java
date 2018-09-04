package com.anytec.sdproperty.controller;

import com.anytec.sdproperty.dao.TbGuestMapper;
import com.anytec.sdproperty.data.ErrorCode;
import com.anytec.sdproperty.data.model.TbGuest;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.data.vo.OutputSnapshotVo;
import com.anytec.sdproperty.data.vo.searchparam.ParamSnapshot;
import com.anytec.sdproperty.service.GuestService;
import com.anytec.sdproperty.service.SnapshotService;
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
 * @des: 快照列表管理，
 */
@Controller
@RequestMapping("/PreApiSnapshot")

public class PreApiSnapshotController extends BaseWebPreController{
	private static final Logger logger = LoggerFactory.getLogger(PreApiSnapshotController.class);

	@Autowired
	private SnapshotService mSnapshotService;
	@Autowired
	private GuestService mGuestService;
	@Autowired
	private TbGuestMapper mTbGuestMapper;

	/***************************************************************************************
	 * 分页查询所有记录
	 * @return
	 * @throws Exception
	 ***************************************************************************************/
	@RequestMapping(value="/queryList.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, ParamSnapshot param, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		//todo 分页查询所有的日志记录
		try {
			logger.info("queryList begin");

			TbUser self = getTbUser(request);

			int pageNum = dgm.getPage();
			int count = dgm.getRows();
//			String order = dgm.getSort();
//			String rule = dgm.getOrder();
			String order = "id";
			String rule = "desc";

			logger.info("pageNum:" + pageNum + "count:" + count + "order:" + order + "rule:" + rule);

			List<OutputSnapshotVo> listData;
			listData = mSnapshotService.getListPage(param, pageNum, count, order, rule);
			if (listData == null)
				listData = new ArrayList<OutputSnapshotVo>();
			Map<String, Object> responseDataMap = new HashMap<String, Object>();
			responseDataMap.put("total", mSnapshotService.getCount(param));
			responseDataMap.put("rows", listData);
//			super.outputRespBody(response, session, responseDataMap);
			return responseDataMap;
		}catch(Exception e){
			logger.info(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/***************************************************************************************
	 * 分页查询某个访客的所有访问记录
	 * @return
	 * @throws Exception
	 ***************************************************************************************/
	@RequestMapping(value="/queryListByGuest.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryListByGuest(DataGridModel dgm, ParamSnapshot param, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		//todo 分页查询所有的日志记录
		try {

			TbUser self = getTbUser(request);

			int pageNum = dgm.getPage();
			int count = dgm.getRows();
			String order = "id";
			String rule = "desc";

			logger.info("pageNum:" + pageNum + "count:" + count + "order:" + order + "rule:" + rule);
			if(null!=param.getGuestCode()) {
                List<OutputSnapshotVo> listData;
                listData = mSnapshotService.getListPage(param, pageNum, count, order, rule);
                if (listData == null)
                    listData = new ArrayList<OutputSnapshotVo>();
                int countNum = mSnapshotService.getCount(param);
                Map<String, Object> responseDataMap = new HashMap<String, Object>();
                responseDataMap.put("total", countNum);
                responseDataMap.put("rows", listData);

                TbGuest tbGuest = mGuestService.getByCode(param.getGuestCode());
                if (tbGuest != null && countNum != 0) {
                    tbGuest.setCount(countNum);
                    mTbGuestMapper.updateByPrimaryKeySelective(tbGuest);
                }
    //			super.outputRespBody(response, session, responseDataMap);
                return responseDataMap;
            }
            logger.info("no guestCode find for search");
            return null;
		}catch(Exception e){
			logger.info(e.getMessage());
			return null;
		}

	}





}
