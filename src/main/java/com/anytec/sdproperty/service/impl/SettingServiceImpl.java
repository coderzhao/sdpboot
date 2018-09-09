package com.anytec.sdproperty.service.impl;


import com.anytec.sdproperty.dao.TbSysMapper;
import com.anytec.sdproperty.data.model.TbSys;
import com.anytec.sdproperty.data.model.TbSysExample;
import com.anytec.sdproperty.jedis.RedisService;
import com.anytec.sdproperty.service.SDKService;
import com.anytec.sdproperty.service.SettingService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


@Service("SettingService")
public class SettingServiceImpl implements SettingService {
	private static final Logger logger = LoggerFactory.getLogger(SettingServiceImpl.class);
	@Autowired
	private TbSysMapper mTbSysMapper;
	@Autowired
	private RedisService redisService;
	@Autowired
	private SDKService mSDKService;


	@Override
	public TbSys getByKeyName(String name){

		TbSysExample example = new TbSysExample();
		TbSysExample.Criteria c = example.createCriteria();
		c.andKeynameEqualTo(name);
		List<TbSys> list = mTbSysMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Boolean checkConfidenceEnough(double confidence) {
		try {
			String confidenceValue;
			if(redisService.get("sysConfidence") == null){
				TbSys sys = getByKeyName(SettingService.KEY_CONFIDENCE);
				confidenceValue = sys.getValue();
				redisService.set("sysConfidence",confidenceValue);
			}else {
				confidenceValue = redisService.get("sysConfidence");
			}
			double sysconfidence = Double.parseDouble(confidenceValue);
			confidence = confidence * 100;
			logger.info("confidence: "+confidence);
			if (confidence > sysconfidence) {
				return TRUE;
			} else {
				return FALSE;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return TRUE;
	}

	@Override
	public TbSys getById(int id) {
		return mTbSysMapper.selectByPrimaryKey(id);
	}


	@Override
	public TbSys addOrUpdate(TbSys input) throws HException {
		if(input.getId() == null){
			mTbSysMapper.insert(input);
		}else{
//			TbSys old = mTbSysMapper.selectByPrimaryKey(input.getId());
			mTbSysMapper.updateByPrimaryKey(input);
			redisService.remove("sysConfidence");
		}
		return input;
	}

	//取当前用户所属代理商及其下属代理商的所有用户
	public List<TbSys> getListPage(int pageNum, int count, String order, String orderRule){
		TbSysExample example = new TbSysExample();
		TbSysExample.Criteria c = example.createCriteria();
		if(order == null || orderRule == null){
			example.setOrderByClause("id desc");
		} else{
			example.setOrderByClause(order + " " + orderRule);
		}
		PageHelper.startPage(pageNum, count);
		Page<TbSys> listData = mTbSysMapper.selectByExample(example);
		return listData;
	}

	public int getCount(){
		TbSysExample example = new TbSysExample();
		return (int)(mTbSysMapper.countByExample(example));
	}

	/**
	 * 获取采集服务程序存放图片路径对应的 根域名
	 * @return
	 */
	@Override
	public String getSdkImageUrlRoot(){
		TbSys sys  = getByKeyName(SettingService.KEY_STORAGE_URL_ROOT);
		return sys.getValue();
	}

	@Override
	public String getPhotoByImageFile(String imageFile){
		try {
			String url = getSdkImageUrlRoot();
			TbSys sys = getByKeyName(SettingService.KEY_STORAGE_PATH);
			String filePath = sys.getValue();

			int index = imageFile.indexOf(filePath);
			java.lang.String subStr = imageFile.substring(index + filePath.length());
			java.lang.String strPhoto = url + "/" + subStr;
			return strPhoto;
		}catch (Exception e){
			logger.error(e.getLocalizedMessage());
			return "http://localhost/";
		}
	}


}
