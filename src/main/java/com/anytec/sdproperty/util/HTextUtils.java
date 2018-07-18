package com.anytec.sdproperty.util;

/**
 * Created by xuxinjian on 16/6/16.
 */
public class HTextUtils {
    /**
     * 检查一个字符串对象是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(String obj){
        if(obj != null && obj.length() > 0)
            return false;
        else
        return true;
    }
}
