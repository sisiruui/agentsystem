package ssru.myw.agentsystem.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	/**
	 * 这个方法   根据输入的时间    与根据输入年份  的政府   做时间的加减
	 * @param date
	 * @param year
	 * @return
	 */
	public static Date getYearDate(Date date,int year) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);//输入时间
		/**
		 *  rightNow.add(Calendar.YEAR,-1);//日期减1年
  			rightNow.add(Calendar.MONTH,3);//日期加3个月      后期拓展用
  			rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
		 */
		rightNow.add(Calendar.YEAR,year);
		return rightNow.getTime();
		
		
	}
	/**
	 * 日期转字符串   转化成 2000-01-01
	 * @return
	 */
	public static String toStringYearMouthDat(Date date){
		SimpleDateFormat sdf  =   new  SimpleDateFormat( "yyyy-MM-dd" );
		String string = sdf.format(date);
		return string;
	}
	
	
	public static Date getNextMouthDate(Date date) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);//输入时间
		/**
		 *  rightNow.add(Calendar.YEAR,-1);//日期减1年
  			rightNow.add(Calendar.MONTH,3);//日期加3个月      后期拓展用
  			rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
		 */
		rightNow.add(Calendar.MONTH,1);
		return rightNow.getTime();
		
	}
	
	
	
}
