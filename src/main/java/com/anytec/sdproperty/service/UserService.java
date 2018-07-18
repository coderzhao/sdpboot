package com.anytec.sdproperty.service;


import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.data.vo.OutputUserVo;
import com.anytec.sdproperty.util.HException;

import java.util.List;

/**
 * 
 * @author user相关的service
 *
 */
public interface UserService extends BaseService {
    public OutputUserVo dologin(String username, String password);
    public TbUser getUserByName(String username) throws HException, com.anytec.sdproperty.service.impl.HException;//用户登陆,返回给客户端的json对象对应的java对象
    public TbUser getUserById(Integer id) throws HException, com.anytec.sdproperty.service.impl.HException;
    public List<OutputUserVo> getListPage(TbUser self, TbUser param, int pageNum, int count, String order, String orderRule);
    public void delete(List<Integer> usersId);
    public TbUser addOrUpdate(TbUser user) throws HException;
    public int getCount(TbUser param);
}
