package com.anytec.sdproperty.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);


    public static byte[] getBinaryDataByURL(String httpURL) throws IOException {

    	try {
			URL url = new URL(httpURL);
			logger.debug("URL :" + url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			connection.setDoOutput(false);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod("GET");

			int status = connection.getResponseCode();
			if (status != 200) {
				logger.error("请求二进制数据响应失败");
				return null;
			}
			byte[] binany = streamToByte(connection.getInputStream());
			if(binany == null)
				return null;
			logger.debug("binary_length:" + binany.length);
			connection.disconnect();
			return binany;
		}catch (Exception e){
    		e.printStackTrace();
    		return null;
		}
    }

	public static byte[] streamToByte(InputStream is) {
    	if(is == null)
    		return null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int c = 0;
		byte[] buffer = new byte[8 * 1024];
		try {
			while ((c = is.read(buffer)) != -1) {
				baos.write(buffer, 0, c);
				baos.flush();
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}