package com.anytec.sdproperty.service;


import com.anytec.sdproperty.data.model.TbSnapshot;
import com.anytec.sdproperty.data.vo.InputSnapshotVo;
import com.anytec.sdproperty.data.vo.OutputSnapshotVo;
import com.anytec.sdproperty.data.vo.searchparam.ParamSnapshot;
import com.anytec.sdproperty.util.HException;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author door 相关的service
 *
 */
public interface SnapshotService extends BaseService{

    public TbSnapshot getById(Integer id) throws HException, com.anytec.sdproperty.service.impl.HException;

    public List<OutputSnapshotVo> getListPage(ParamSnapshot param, int pageNum, int count, String order, String orderRule);
    public void delete(Integer id);
    public Map<String, Object> add(InputSnapshotVo data) throws Exception;
    public int getCount(ParamSnapshot param);
    public void updateSnapshot(Integer snapshotId, String guest_code);
    int insert(TbSnapshot snapshot);
    public void openDoorCheck(int doorId, String person_id,float confidence);

}
