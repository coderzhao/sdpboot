package com.anytec.sdproperty.jedis;

import java.io.*;

public class JSerialize {

    //序列化
    public static byte [] serialize(Object obj){
        ObjectOutputStream obi=null;
        ByteArrayOutputStream bai=null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt=bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(obi != null)
                    obi.close();
                if(bai != null)
                    bai.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }finally {
            try {
                if(oii != null)
                    oii.close();
                if(bis!=null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
