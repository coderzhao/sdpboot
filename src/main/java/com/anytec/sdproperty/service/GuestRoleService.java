package com.anytec.sdproperty.service;


import com.anytec.sdproperty.data.model.TbGuestRole;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.util.HException;

import java.util.List;

/**
 * 
 * @author door 相关的service
 *
 */
public interface GuestRoleService extends BaseService{

    public TbGuestRole getByName(String name) throws HException, com.anytec.sdproperty.service.impl.HException;//根据名称返回对象
    public TbGuestRole getById(Integer id);

    public List<TbGuestRole> getAllGuestRole();
    public List<TbGuestRole> getListPage(TbUser self, TbGuestRole param, int pageNum, int count, String order, String orderRule);
    public void delete(Integer id);
    public TbGuestRole addOrUpdate(TbGuestRole data) throws HException;
    public int getCount(TbGuestRole param);
}
