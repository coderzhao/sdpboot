package com.anytec.sdproperty.util;

//import org.apache.commons.codec.binary.Base64;

public class HUtils {

//	public static String genFileGroupID(String userID) {
//		Random random = new Random();
//		int randomCount = random.nextInt(10000);
//		Long curtm = System.currentTimeMillis();
//		byte[] b = (userID + randomCount + curtm + "").getBytes();
//		String gwfid = Base64.encodeBase64String(b);
//		return Md5.getMD5Str(gwfid);
//	}
	
	public static String getImageRootPath(){
		return "http://image1.baobaogangwan.com/";//图片文件跟路径
	}
	
	/**
	 * 获取缩略图后缀， 如 _72
	 * @return
	 */
	public static String getThumbName(){
		return "_72";//图片文件跟路径
	}
}
