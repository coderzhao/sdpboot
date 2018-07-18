package com.anytec.sdproperty.jedis;

import com.alibaba.fastjson.JSONObject;
import com.anytec.sdproperty.dao.TbGuestRoleMapper;
import com.anytec.sdproperty.data.model.TbDoorLock;
import com.anytec.sdproperty.data.model.TbGuest;
import com.anytec.sdproperty.data.model.TbGuestRole;
import com.anytec.sdproperty.data.model.TbIpc;
import com.anytec.sdproperty.service.DoorLockService;
import com.anytec.sdproperty.service.GuestService;
import com.anytec.sdproperty.service.IpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class NecessaryDataServiceImpl implements NecessaryDataService {

    private static final Logger logger = LoggerFactory.getLogger(NecessaryDataServiceImpl.class);

    @Autowired
    private RedisService redisService;
//    private static JedisService jedisService = JedisService.getInstance();

    @Autowired
    private GuestService mGuestService;
    @Autowired
    private IpcService ipcService;
    @Autowired
    private TbGuestRoleMapper mTbGuestRoleMapper;
    @Autowired
    private DoorLockService mDoorLockService;


    @Override
    public TbIpc getCamera(String mac) {
        TbIpc camera = null;
        String macResult = redisService.get(mac);
        if(StringUtils.isEmpty(macResult)){
            try {
                camera = ipcService.getByAddress(mac);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(camera != null){
                redisService.set(mac,JSONObject.toJSONString(camera));
            }
        }else{
            camera = JSONObject.parseObject(macResult,TbIpc.class);
        }
        return camera;
    }

    @Override
    public TbGuest getTbGuest(String sdkId) {
        TbGuest guest = null;
        String guestResult = redisService.get("guest:"+sdkId);
        if(StringUtils.isEmpty(guestResult)){
            guest = mGuestService.getByCode(sdkId);
            if(guest != null){
                redisService.set("guest:"+sdkId,JSONObject.toJSONString(guest));
            }
        }else{
            guest = JSONObject.parseObject(guestResult,TbGuest.class);
        }
        return guest;
    }

    @Override
    public TbGuestRole getTbGuestRole(Integer guestRoleId) {
        TbGuestRole guestRole = null;
        String guestRoleResult = redisService.get("role:"+guestRoleId);
        if(StringUtils.isEmpty(guestRoleResult)){
            guestRole = mTbGuestRoleMapper.selectByPrimaryKey(guestRoleId);
            if(guestRole != null){
                redisService.set("role:"+guestRoleId,JSONObject.toJSONString(guestRole));
            }
        }else{
            guestRole = JSONObject.parseObject(guestRoleResult,TbGuestRole.class);
        }
        return guestRole;
    }

    @Override
    public TbDoorLock getTbOpenLock(Integer doorId) {
        TbDoorLock lock = null;
        String lockResult = redisService.get("lock:"+doorId);
        if(StringUtils.isEmpty(lockResult)){
            lock = mDoorLockService.getByDoorId(doorId,false);
            if(lock != null){
                redisService.set("lock:"+doorId,JSONObject.toJSONString(lock));
            }else {
                logger.info("根据doorId:"+doorId+" 获取lock对象为null");
            }
        }else{
            lock = JSONObject.parseObject(lockResult,TbDoorLock.class);
        }
        return lock;
    }

    @Override
    public TbDoorLock getTbDangerLock(Integer doorId) {
        TbDoorLock lock = null;
        String dlockResult = redisService.get("dangerLock:"+doorId);
        if(StringUtils.isEmpty(dlockResult)){
            lock = mDoorLockService.getByDoorId(doorId,true);
            if(lock != null){
                redisService.set("dangerLock:"+doorId,JSONObject.toJSONString(lock));
            }
        }else{
            lock = JSONObject.parseObject(dlockResult,TbDoorLock.class);
        }
        return lock;
    }


}
