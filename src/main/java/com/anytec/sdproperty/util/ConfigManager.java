package com.anytec.sdproperty.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager instance;
	private static Properties properties;
	       private ConfigManager() {
	    	   String configFile = "config.properties";
	    	   properties = new Properties();
	    	   InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
	    	   try {
				properties.load(is);
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }
	       public static ConfigManager getInstance(){    //对获取实例的方法进行同步
	         if (instance == null){
	             synchronized(ConfigManager.class){
	                if (instance == null)
	                    instance = new ConfigManager(); 
	             }
	         }
	       return instance;
	       }
	       public String getParameter(String key) {
	    	   return properties.getProperty(key);
	       }
	       
}
