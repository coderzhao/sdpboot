package com.anytec.sdproperty.util;

import com.anytec.sdproperty.util.HTextUtils;
import com.anytec.sdproperty.util.Md5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuxinjian on 17/7/15.
 */
public class NUtil {
    public static String date2String(Date in){
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str=sdf.format(in);
            return str;
        }catch (Exception e){
            return "日期解析失败";
        }
    }

    /**
     * 将sdk传递过来的本地文件路径， 转换为url
     * @param imageFile
     * @return
     */
    public static String getUrlFromPhoto(String imageFile){
        if(HTextUtils.isEmpty(imageFile))
            return "";
        //此处将imagefile临时作为photo返回 －test
        int index = imageFile.indexOf("/images/");
        java.lang.String subStr = imageFile.substring(index);
        java.lang.String strPhoto = "http://1747785do9.imwork.net:8889" + subStr;
        return strPhoto;
    }

    /**
     * 加密一个文件名
     * @param fileName
     * @return
     */
    public static String makeFilename(String fileName){
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        return Md5.getMD5Str(fileName + System.currentTimeMillis()) + prefix;
    }
}
