package com.anytec.sdproperty.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class DateUtils {
	public static final TimeZone GTM8TimeZone = TimeZone.getTimeZone("GMT+8");
	private static Log log = LogFactory.getLog(com.anytec.sdproperty.util.DateUtils.class);
	private static final String dateFormat = "yyyy-MM-dd";
	private static final String dateTimeFormat = "MM/dd/yyyy HH:mm:ss";
	private static final String dateTimeFormatForChina = "yyyy-MM-dd HH:mm:ss";
	private static final String dateFormatForTeamCode = "yyyyMMdd";
	
	public static Date convertStringToDate(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setTimeZone(GTM8TimeZone);
		return sdf.parse(time);
	}
	
	public static String refFormatNowDate() {
		  Date nowTime = new Date(System.currentTimeMillis());
		  SimpleDateFormat sdFormatter = new SimpleDateFormat(dateFormat);
		  String retStrFormatNowDate = sdFormatter.format(nowTime);
		  return retStrFormatNowDate;
	}
	public static Date convertStringToDate(String time, String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(GTM8TimeZone);
		return sdf.parse(time);
	}
	
	public static Date convertStringToDateTime(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat);
		sdf.setTimeZone(GTM8TimeZone);
		return sdf.parse(time);
	
	}
	public static Date convertStringToDateTimeForChina(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormatForChina);
		sdf.setTimeZone(GTM8TimeZone);
		return sdf.parse(time);
	}
	
	public static String convertDateToStringForChina(Date date){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormatForChina);
			sdf.setTimeZone(GTM8TimeZone);
			return sdf.format(date);
		}catch(Exception e){
			return "1970-00-00 00:00:00";
		}
	}
	
	public static String convertDateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setTimeZone(GTM8TimeZone);
		return sdf.format(date);
	}
	
	public static String convertDateToStringForTeamCode(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormatForTeamCode);
		sdf.setTimeZone(GTM8TimeZone);
		return sdf.format(date);
	}	
	
	public static Date getSearchMonthFromDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(GTM8TimeZone);
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getSearchMonthToDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(GTM8TimeZone);
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}	
	
	public static Date getSearchYearFromDate(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(GTM8TimeZone);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getSearchYearToDate(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(GTM8TimeZone);
		calendar.set(Calendar.YEAR, year+1);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static String convertDateToString(Date date,String partten){
		SimpleDateFormat sdf = new SimpleDateFormat(partten);
		sdf.setTimeZone(GTM8TimeZone);
		return sdf.format(date);		
	}
	
	public static Date getSearchFromDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(GTM8TimeZone);
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getSearchToDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(GTM8TimeZone);
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}	
	
	public static Date makeDayByHourAndMinute(int hour, int minute){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		return calendar.getTime();
	}
	
	public static int getHourByDate(Date date){
		if(date == null){
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public static int getMinuteByDate(Date date){
		if(date == null){
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);		
	}
	
	/**
	 * 得到当前日期，只保留年、月、日的信息
	 * @return
	 */
	public static Date getCurrentDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(GTM8TimeZone);
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static String getMessageID(){
		String msgID = null;
		try{
			Date now = new Date();
//			String userid = App.getApp().getmAppData().getUser().mID + "";
			String userid = "";
			Random ran = new Random(System.currentTimeMillis());
			msgID = userid + now + ran.nextLong();
			msgID = Md5.getMD5Str(msgID);
		}catch(Exception e){
			
		}
		return msgID;
	}


		public static final int SECONDS_IN_DAY = 60 * 60 * 24;
		public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;

	/**
	 *  判断两个毫秒时间是不是同一天
	 * @param ms1
	 * @param ms2
	 * @return
	 */
	public static boolean isSameDayOfMillis(final long ms1, final long ms2) {
		final long interval = ms1 - ms2;
		return interval < MILLIS_IN_DAY
				&& interval > -1L * MILLIS_IN_DAY
				&& toDay(ms1) == toDay(ms2);
	}

	private static long toDay(long millis) {
		return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
	}

}
