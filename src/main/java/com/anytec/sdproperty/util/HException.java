package com.anytec.sdproperty.util;

public class HException extends Exception{
	
	private int code;

	/**
	 * 
	 */
	private static final long serialVersionUID = -9166091990447266596L;

	public HException(int code, String message, Throwable throwable) {
		super(message, throwable);
		this.code = code;
		
		// TODO Auto-generated constructor stub
	}

	public HException(String message, Throwable throwable) {
		super(message, throwable);
		// TODO Auto-generated constructor stub
	}
	
	public HException(int code, String message) {
		super(message);
		this.code = code;
		// TODO Auto-generated constructor stub
	}

	public HException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	

}
