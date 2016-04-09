/*
 * Created on 2005-6-28
 */
package com.xcooper.Common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;


public class DateUtil {

    public static Timestamp getNowTime(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getYear(){
        SimpleDateFormat date = new SimpleDateFormat("yy");
        return date.format(new Date());
    }

    public static String getYearYYYY(){
        SimpleDateFormat date = new SimpleDateFormat("yyyy");
        return date.format(new Date());
    }

    public static String getMonth(){
        SimpleDateFormat date = new SimpleDateFormat("MM");
        return date.format(new Date());
    }

    public static String getDay(){
        SimpleDateFormat date = new SimpleDateFormat("dd");
        return date.format(new Date());
    }

    public static String getHour(){
        SimpleDateFormat date = new SimpleDateFormat("HH");
        return date.format(new Date());
    }

    public static String getMinute(){
        SimpleDateFormat date = new SimpleDateFormat("mm");
        return date.format(new Date());
    }

    public static String getSecond(){
        SimpleDateFormat date = new SimpleDateFormat("ss");
        return date.format(new Date());
    }

    public static String getMillisecond (){
        SimpleDateFormat date = new SimpleDateFormat("SSS");
        return date.format(new Date());
    }


    public static boolean isToday(Timestamp time){
        SimpleDateFormat format=new SimpleDateFormat("yy-MM-dd");

        if(format.format(time).equals(format.format(new Date()))){
            return true;
        }

        return false;
    }

    public static String getCurrentDay(String dateFormat){
        SimpleDateFormat format=new SimpleDateFormat(dateFormat);
        return format.format(new Date());
    }

    public static long getDayBetween(String now,String fore){
    	long count = 0;

        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date nowDate = myFormatter.parse(now);
            Date foreDate = myFormatter.parse(fore);

            count = (long)(nowDate.getTime()-foreDate.getTime())/(24*60*60*1000);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            count = 0;
            e.printStackTrace();
        }

        return count;
    }


	public static long getCurrentDayLongTime(String dateFormat){
		SimpleDateFormat myFormatter = new SimpleDateFormat(dateFormat);
		long time = 0;

		try {
			Date nowDate = myFormatter.parse(getCurrentDay(dateFormat));

			time = nowDate.getTime();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return time;
	}


    public static Timestamp getTodayTimestamp(){
		String nowDateStr = getCurrentDay("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Timestamp timestamp = null;
		try {
			timestamp = new Timestamp(sdf.parse(nowDateStr).getTime());
		} catch (ParseException e) {

			e.printStackTrace();
		}

    	//System.err.println("Now day is:  " + timestamp.toString());

    	return timestamp;
    }



	public static String rollDayStrForToday(String dateFormat,int amount){
		SimpleDateFormat format=new SimpleDateFormat(dateFormat);
		return format.format(rollDayTimestamp(null,amount));
	}


    public static Timestamp rollDayTimestamp(String dateStr,int amount){

		String nowDate = dateStr;

		if(null == nowDate || nowDate.trim().equals("")){
			nowDate = getCurrentDay("yyyy-MM-dd");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    	Calendar nowCalendar = Calendar.getInstance();

    	try {
			nowCalendar.setTime(sdf.parse(nowDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}


		nowCalendar.add(Calendar.DATE,amount);


		Timestamp timestamp = new Timestamp(nowCalendar.getTimeInMillis());

//		System.err.println("rollDayTimestamp: " + timestamp.toString());

    	return timestamp;
    }



	public static Timestamp rollMonthTimestamp(String dateStr,int amount){


		String nowDate = dateStr;

		if(null == nowDate || nowDate.trim().equals("")){
			nowDate = getCurrentDay("yyyy-MM-dd");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


		Calendar nowCalendar = Calendar.getInstance();

		try {
			nowCalendar.setTime(sdf.parse(nowDate));
		} catch (ParseException e) {

			e.printStackTrace();
		}


		nowCalendar.add(Calendar.MONTH,amount);


		Timestamp timestamp = new Timestamp(nowCalendar.getTimeInMillis());


		return timestamp;
	}



	public static String format(Timestamp time,String formatStr){
		if(null == time){
			return null;
		}

    	SimpleDateFormat format = new SimpleDateFormat(formatStr);
		String date = format.format(time);
		return date;
    }


	public static String format(String time,String formatStr){
		if(StrUtil.isNull(time)){
			return null;
		}

		String date = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat(formatStr);
			date = format.format(new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}

		return date;
    }


	public static String dateToStrLong(Long Date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(new Date(Date));
		return dateString;
	}


	public static int getWeekOfYear(){
		int week = 0;

		Calendar c = Calendar.getInstance();
		week = c.get(Calendar.WEEK_OF_YEAR);

		return week;
	}

	public static String getStartDate(int year, int weekNo){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,   year);
		cal.set(Calendar.WEEK_OF_YEAR, weekNo);
		cal.set(Calendar.DAY_OF_WEEK,   Calendar.MONDAY);
		SimpleDateFormat returnDate=new SimpleDateFormat("yyyy��MM��dd��");

		return returnDate.format(cal.getTime());
	}

	public static String getEndDate(int year, int weekNo){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,   year);
		cal.set(Calendar.WEEK_OF_YEAR,   weekNo+1);
		cal.set(Calendar.DAY_OF_WEEK,   Calendar.SUNDAY);
		SimpleDateFormat returnDate=new SimpleDateFormat("yyyy��MM��dd��");

		return returnDate.format(cal.getTime());
	}

	public static Collection getTwoDateDayList(String endDate,String beginDate){
		Collection resultList=new ArrayList();
		long dayCount = DateUtil.getDayBetween(endDate, beginDate);
		resultList.add(beginDate);
		for (int i = 0; i < dayCount; i++) {
			Timestamp now = DateUtil.rollDayTimestamp(beginDate, 1);
			beginDate = DateUtil.format(now, "yyyy-MM-dd");
			//resultList.add(beginDate.substring(0,4)+"��"+beginDate.substring(5,7)+"��"+beginDate.substring(8,10)+"��");
			resultList.add(beginDate);
		}
		return resultList;

	}


	public static Collection getTwoDateDayListDesc(String endDate,String beginDate){
		Collection resultList=new ArrayList();
		long dayCount = DateUtil.getDayBetween(endDate, beginDate);
		resultList.add(endDate);
		for (long i = dayCount; i>0 ; i--) {
			Timestamp now = DateUtil.rollDayTimestamp(endDate, -1);
			endDate = DateUtil.format(now, "yyyy-MM-dd");
			//resultList.add(beginDate.substring(0,4)+"��"+beginDate.substring(5,7)+"��"+beginDate.substring(8,10)+"��");
			resultList.add(endDate);
		}
		return resultList;

	}


	public static String getWeekForDate(String date,String format){
		String week = "";

		//mydate= myFormatter.parse("2001-1-1");
		SimpleDateFormat f1 = new SimpleDateFormat(format);
		Date d = null;
		try {
			d = f1.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SimpleDateFormat formatter = new SimpleDateFormat("E");
		week = formatter.format(d);


		return week;
	}


	public static String getStandardDate(int year,int month,int day){
		String yearStr = String.valueOf(year);
		String monthStr = String.valueOf(month);
		String dayStr = String.valueOf(day);
		if(month < 10){
			monthStr = "0" + month;
		}
		if(day <10){
			dayStr = "0" + day;
		}
		return yearStr + "-" + monthStr + "-" + dayStr;
	}





	public static boolean compareTotime(String dateStr){
		boolean isOK=false;
        long count = 0;
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtimeStr=getCurrentDay("yyyy-MM-dd HH:mm:ss");
        try {
            Date nowDate = myFormatter.parse(nowtimeStr);
            Date foreDate = myFormatter.parse(dateStr);
            count = (long)(nowDate.getTime()-foreDate.getTime());

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            count = 0;
            e.printStackTrace();
        }
       if(count>0){
    	   isOK= true;
       }
       return isOK;
	}



	public static boolean compareTotime(String oneStr, String twoStr){
		boolean isOK=false;
         long count = 0;
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date nowDate = myFormatter.parse(oneStr);
            Date foreDate = myFormatter.parse(twoStr);
            count = (long)(nowDate.getTime()-foreDate.getTime());

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            count = 0;
            e.printStackTrace();
        }
       if(count>0){
    	   isOK= true;
       }
       return isOK;
	}

	public static Timestamp getCurrTime(){
		return getNotNullTimestampValue(null,"yyyy-MM-dd HH:mm:ss:SSS");
	}


    public static Timestamp getNotNullTimestampValue(String data, String dateFormat){
        Timestamp value;
        try{
            if (null == data || data.equals("")){
                value = new Timestamp(System.currentTimeMillis());
            }else{
                SimpleDateFormat smd = new SimpleDateFormat( dateFormat);
                value = new Timestamp(smd.parse(data).getTime());
            }
        }catch(Exception e){
            e.printStackTrace();
            value = new Timestamp(System.currentTimeMillis());
        }
        
        return value;
    }
    
	public static int compareTimstampStr(String sourceStr,String destStr,String formartStr){
		int result = 10;
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat(formartStr);
		long temp = 10;
	 	try {
            Date beginDate = dateFormatter.parse(sourceStr);
            Date endDate = dateFormatter.parse(destStr);
            temp = (long)(beginDate.getTime()-endDate.getTime());
	    } catch (ParseException e) {
            // TODO Auto-generated catch block
        	result = Integer.MAX_VALUE;
        	e.printStackTrace();
        }
	    if(temp>0){
	    	result = 1;
	    }else if(temp==0){
	    	result = 0;
	    }else if(temp<0){
	    	result = -1;
	    }
	        
       return result; 
	}


}
