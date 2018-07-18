package com.anytec.sdproperty.controller;

import com.alibaba.fastjson.JSONObject;
import com.anytec.sdproperty.data.model.TbIpc;
import com.anytec.sdproperty.data.model.TbSys;
import com.anytec.sdproperty.jedis.RedisService;
import com.anytec.sdproperty.pojo.Person;
import com.anytec.sdproperty.service.DoorLockService;
import com.anytec.sdproperty.service.IpcService;
import com.anytec.sdproperty.service.SettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private RedisService redisService;
    @Autowired
    DoorLockService doorLockService;
    @Autowired
    private SettingService settingService;
    @Autowired
    private IpcService ipcService;

    private JSONObject jsonObject = new JSONObject();


    @RequestMapping("test")
    public void test(){
        logger.info("test");
        logger.info(doorLockService.getByDoorId(11,false).getName());
        logger.info(doorLockService.getByDoorId(11,true).getName());
    }

    @RequestMapping("/getHeadTitle")
    @ResponseBody
    public String getHeadTitle(){
        TbSys tbSys = settingService.getByKeyName(SettingService.KEY_SYSNAME);
        return tbSys.getValue();
    }

    @RequestMapping("/getCameraList")
    @ResponseBody
    public List<TbIpc> queryAllIpc(){
        return ipcService.getAllIpc();
    }

   @RequestMapping("/person")
   @ResponseBody
   public void person(){
        logger.info("set result: "+redisService.set("first","haha"));
        logger.info("get result: "+redisService.get("first"));
        Person person = new Person("person1","male");
        logger.info("setObject result: "+redisService.set("person",jsonObject.toJSONString(person)));
        Person person2 = jsonObject.parseObject(redisService.get("person"),Person.class);
        logger.info("getObject result: "+jsonObject.toJSONString(person2));

   }

}
