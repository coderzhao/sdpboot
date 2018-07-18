package com.anytec.sdproperty.service;


import com.anytec.sdproperty.data.model.TbSys;
import com.anytec.sdproperty.util.HException;

import java.util.List;

/**
 * 
 * @author 系统设置 相关的service
 *
 */
public interface SettingService extends BaseService{
    public final static String KEY_FMANAGER_HOST = "fmanager_host";
    public final static String KEY_CONFIDENCE = "confidence";
    public final static String KEY_STORAGE_PATH = "storage_path";
    public final static String KEY_STORAGE_URL_ROOT = "storage_url_root";
    public final static String KEY_STORAGE_MAX = "storage_max";
    public final static String KEY_SDK_API_URL_ROOT = "sdk_api_url_root";
    public final static String KEY_TOKEN = "token";
    public final static String KEY_SYSNAME ="sysname";


    public TbSys getById(int id);
    public TbSys getByKeyName(String name);
    public TbSys addOrUpdate(TbSys user) throws HException, com.anytec.sdproperty.service.impl.HException;
    public List<TbSys> getListPage(int pageNum, int count, String order, String orderRule);
    public int getCount();

    public String getSdkImageUrlRoot();
    public String getPhotoByImageFile(String imageFile);
    //检查相似度是否够，输入的是入0.820
    Boolean checkConfidenceEnough(double confidence);
}
