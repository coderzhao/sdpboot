package com.anytec.sdproperty.service;


import com.anytec.sdproperty.data.model.TbGuest;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.data.vo.TbGuestModifyRecordVo;
import com.anytec.sdproperty.data.vo.TbGuestVo;
import com.anytec.sdproperty.util.HException;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author door 相关的service
 *
 */
public interface GuestService extends BaseService{

    public TbGuest getByName(String name) throws HException, com.anytec.sdproperty.service.impl.HException;//根据名称返回对象
    public TbGuest getByCode(String code);
    public TbGuest getById(Integer id) throws HException, com.anytec.sdproperty.service.impl.HException;
    public TbGuest getByCardNo(String cardNo);
    public List<TbGuestModifyRecordVo> getListPageRecord(TbGuest param, int pageNum, int count, String order, String orderRule);
    public long getCountRecord(TbGuest param);

    public List<TbGuestVo> getListPage(TbGuest param, int pageNum, int count, String order, String orderRule);
    public void delete(TbUser user, Integer id);
    public TbGuest addOrUpdate(TbUser user, TbGuest data) throws HException;
    public String addImages(TbUser user, TbGuest data,List<String> imagePathList,String webroot) throws HException;
    public int getCount(TbGuest param);


}
