package com.anytec.sdproperty.common;


public class Constant {
	
	private static ConfigManager config = ConfigManager.getInstance();

	public static final String TOKEN = config.getParameter("TOKEN");

	public static final String SDK_IP = config.getParameter("SDK_IP");

	public static final String SWITCH_IP_PORT = config.getParameter("SWITCH_IP_PORT");

	public static final String IMAGE_PATH = config.getParameter("snapshotFolder");

	public static final String ENROLL_PATH = config.getParameter("enrollPath");

	public static final int THREADS = Integer.parseInt(config.getParameter("THREADS_NUM"));

	public static final float FR_CONFIDENCE_THRESHOLD = Float.parseFloat(config.getParameter("FR_CONFIDENCE_THRESHOLD"));

	public static final int FR_CAMERA_DATA_THRESHOLD = Integer.parseInt(config.getParameter("cameraDataThreshold"));

	public static final double FACE_SIZE = Double.parseDouble(config.getParameter("FACE_SIZE"));

	public static final Integer dangerLevel = Integer.parseInt(config.getParameter("dangerLevel"));
//	public static final String PROXY_IDENTIFY = config.getParameter("proxy_identify");
}
