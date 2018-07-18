package com.anytec.sdproperty.service;

import com.anytec.sdproperty.data.model.TbIpc;

import java.util.Map;

/**
 * 
 * @author door 相关的service
 *
 */
public interface SDKService extends BaseService{
    public Map<String, Object> addFace(String image, String meta) throws Exception;
    public boolean deleteFace(String id);

    //闪开门
    public void flashOpenDoor(String ip, Integer port, Integer line, Integer time);
}
