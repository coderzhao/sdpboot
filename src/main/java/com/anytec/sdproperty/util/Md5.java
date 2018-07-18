package com.anytec.sdproperty.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 
 * @author Administrator
 *
 */
public class Md5 {


    private Md5() {
    }


    public static String md5(final String in) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(in.getBytes());
            final byte[] a = digest.digest();
            final int len = a.length;
            final StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++) {
                sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
                sb.append(Character.forDigit(a[i] & 0x0f, 16));
            }
            return sb.toString();
        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

   
    
    /**
     * MD5 加密
     * 
     * @param str
     * @return
     */
    public static String getMD5Str(String str) {
        if (str !=null && str.length()>0) {
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(str.getBytes("UTF-8"));
            } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                return null;
            } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                return null;
            }

            final byte[] byteArray = messageDigest.digest();

            final StringBuffer md5StrBuff = new StringBuffer();

            for (int i = 0; i < byteArray.length; i++) {
                if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                    md5StrBuff.append("0").append(
                            Integer.toHexString(0xFF & byteArray[i]));
                } else {
                    md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
                }
            }
            // 16位加密，从第9位到25位
            //return md5StrBuff.substring(8, 24).toString().toUpperCase();
            return md5StrBuff.toString().toUpperCase();
        }
        return "";
    }
    
}
