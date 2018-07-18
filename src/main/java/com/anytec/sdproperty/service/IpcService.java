package com.anytec.sdproperty.service;


import java.util.List;

import com.anytec.sdproperty.data.model.TbIpc;
import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.data.vo.TbIpcVo;
import com.anytec.sdproperty.util.HException;
import com.github.pagehelper.Page;

/**
 *
 * @author door 相关的service
 *
 */
public interface IpcService extends BaseService{

    public TbIpc getByName(String name) throws HException, com.anytec.sdproperty.service.impl.HException;//根据名称返回门岗对象
    public TbIpc getById(Integer id) throws HException, com.anytec.sdproperty.service.impl.HException;
    public TbIpc getByAddress(String mac) throws HException, com.anytec.sdproperty.service.impl.HException;//mac address
    /**
     * @param self 当前登陆用户
     * @param param 前端页面搜索传递来的参数对象
     * @param pageNum
     * @param count
     * @param order
     * @param orderRule
     * @return
     */
    public List<TbIpcVo> getListPage(TbUser self, TbIpc param, int pageNum, int count, String order, String orderRule);
    public void delete(Integer id);
    public TbIpc addOrUpdate(TbIpc data) throws HException;
    public int getCount(TbIpc param);
    public List<TbIpc> getAllIpc();
}
