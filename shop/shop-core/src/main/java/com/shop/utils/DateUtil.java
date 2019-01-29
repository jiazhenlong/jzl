package com.shop.utils;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

/**
 * 
 * @author huyp
 *
 */
public class DateUtil {
  private final static String YYMMDD = "yyyy-MM-dd";
  
  private final static String YYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
  
  public static String getCurrentDateString(String pattern) {
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    return format.format(new Date());
  }

  private DateUtil(){}
  
  /**
   * The date is formatted according to default1 pattern
   * @param date
   * @return
   */
  public static String formatToYYMMDD(Date date){
    SimpleDateFormat format = new SimpleDateFormat(YYMMDD);
    return format.format(date);
  }
  
  /**
   * the date is formatter according to default2 pattern
   * @param date
   * @return
   */
  public static String formatToYYMMDDhhmmss(Date date){
    SimpleDateFormat format = new SimpleDateFormat(YYMMDD_HHMMSS);
    return format.format(date);
  }
  
  /**
   * The date is formatted according to pattern
   * will use default1 pattern if pattern is null
   * @param date
   * @param pattern
   * @return
   */
  public static String format(Date date,String pattern){
    if(StringUtils.isNotEmpty(pattern)){
      return formatToYYMMDD(date);
    }
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    return format.format(date);
  }
  
  /**
   * To get the result of the date plus/subtract  days
   * @param date
   * @param days
   * @return
   */
  public static Date addDay(Date date,int days){
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DAY_OF_MONTH, days);
    return calendar.getTime();
  }
  
  public static void setCalendar(Calendar calendar,int day,int hour,int minute,int second){
    if(day != -1){calendar.set(Calendar.DAY_OF_MONTH, day);}
    if(hour != -1){calendar.set(Calendar.HOUR_OF_DAY, hour);}
    if(minute != -1){calendar.set(Calendar.MINUTE, minute);}
    if(second != -1){calendar.set(Calendar.SECOND, second);}
    calendar.set(Calendar.MILLISECOND, 0);
  }
  
  /**
   * Accurate time to minute
   * @param date
   * @return
   */
  public static Date getDateAccurateAtMinute(Date date){
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    setCalendar(calendar, -1, -1, -1, 0);
    return calendar.getTime();
  }
  
  /**
   * Accurate time to hour
   * @param date
   * @return
   */
  public static Date getDateAccurateAtHour(Date date){
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    setCalendar(calendar, -1, -1, 0, 0);
    return calendar.getTime();
  }
  
  /**
   * Accurate time to day
   * @param date
   * @return
   */
  public static Date getDateAccurateAtDay(Date date){
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    setCalendar(calendar, -1, 0, 0, 0);
    return calendar.getTime();
  }
  
  /**
   * Accurate time to month
   * @param date
   * @return
   */
  public static Date getDateAccurateAtMonth(Date date){
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    setCalendar(calendar, 0, 0, 0, 0);
    return calendar.getTime();
  }
  
  /**
   * To get time range
   * @param start
   * @param end
   * @return
   */
  public static String getTimeRangeString(Date start,Date end){
    SimpleDateFormat format = new SimpleDateFormat(YYMMDD_HHMMSS);
    return MessageFormat.format("{0} - {1} ",format.format(start),format.format(end));
  }
  
  /**
   * to get current date by according pattern
   * will use default2 pattern if pattern is null
   * @param pattern
   * @return
   */
  public static String getCurrentTimeString(String pattern){
    if(StringUtils.isEmpty(pattern)){
      return formatToYYMMDDhhmmss(new Date());
    }
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    return format.format(new Date());
  }
  
  /**
   * to get start time of the date
   * @param date
   * @return
   */
  public static Date toDayStart(Date date){
    return null == date ? null : getDateAccurateAtDay(date);
  }
  
  /**
   * to get start time of the next date
   * @param date
   * @return
   */
  public static Date toNextDayStart(Date date){
    return null == date ? null : getDateAccurateAtDay(addDay(date, 1));
  }
  
  /**
   * Allocates a Date object and initializes it to represent the specified number of milliseconds
   * @param instance
   * @return
   */
  public static Date toDate(Long instance){
    return null == instance ? null :new Date(instance);
  }
  
  /**
   * Determines whether the time is the current time
   * @param time
   * @return
   */
  public static boolean isToday(DateTime time){
    return null != time && time.isBefore(DateTime.now().plusDays(1).withTimeAtStartOfDay()) && time.isAfter(DateTime.now().withTimeAtStartOfDay().minusSeconds(1));
  }
}
