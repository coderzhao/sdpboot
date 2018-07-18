package com.anytec.sdproperty.service;

import com.anytec.sdproperty.data.model.*;
import com.anytec.sdproperty.data.vo.TbDoorLockVo;
import com.anytec.sdproperty.util.HException;

import java.util.List;

/**
 * 
 * @author door 相关的service
 *
 */
public interface DoorLockService extends BaseService{

    public List<TbDoorLockVo> getListPage(TbDoorLock param, int pageNum, int count, String order, String orderRule);
    public void delete(Integer id);
    public TbDoorLock addOrUpdate(TbDoorLock user) throws HException;
    public int getCount(TbDoorLock param);
    public TbDoorLock getByDoorId(Integer id,boolean dangerFlag);//获取某个门的门禁
    public boolean openDoor(Integer id);
    void alarmDangerLock(TbDoorLock dangerLock);

    void openDoorLock(TbDoorLock openLock , TbGuest guest, TbGuestRole role);
}
