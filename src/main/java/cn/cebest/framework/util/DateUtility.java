package cn.cebest.framework.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 日期处理工具类
 * 
 * @author gaopeng@300.cn
 * @version 2018年8月29日 下午1:04:12
 */
public class DateUtility extends DateUtils {

	// 一天的毫秒数 60*60*1000*24
	public static final long DAY_MILLIS = 86400000;
	public static final BigDecimal YEAR_DAYS = new BigDecimal(365);

	public static final String ISO_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String ISO_DATETIME_TIME_ZONE_FORMAT = "yyyy-MM-dd HH:mm:ssZZ";
	public static final String ISO_DATE_FORMAT = "yyyy-MM-dd";
	public static final String ISO_DATE_TIME_ZONE_FORMAT = "yyyy-MM-ddZZ";
	public static final String ISO_TIME_FORMAT = "HH:mm:ss";
	public static final String ISO_TIME_TIME_ZONE_FORMAT = "HH:mm:ssZZ";
	public static final String ISO_TIME_NO_T_FORMAT = "HH:mm:ss";
	public static final String ISO_TIME_NO_T_TIME_ZONE_FORMAT = "HH:mm:ssZZ";
	public static final String DEFAULT_DATE_PATTERN = ISO_DATETIME_FORMAT;

	public static String format(Date date) {
		return format(date, DEFAULT_DATE_PATTERN);
	}

	public static String format(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}

	public static String format(Calendar calendar) {
		return format(calendar, DEFAULT_DATE_PATTERN);
	}

	public static String format(Calendar calendar, String pattern) {
		return DateFormatUtils.format(calendar, pattern);
	}

	/**
	 * 比较两个日期的大小，
	 * 
	 * @param d1
	 * @param d2
	 * @param pattern
	 * @return d1小于d2 返回 -1 ; <br />
	 *         d1等于d2 返回 0；<br />
	 *         d1大于d2 返回 1；
	 * 
	 */
	public static int compare(Date d1, Date d2, String pattern) {
		if (d1 == null && d2 == null)
			return 0;
		if (d1 == null)
			return -1;
		if (d2 == null)
			return 1;

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		try {
			cal1.setTime(parseDate(format(d1, pattern), new String[] { pattern }));
			cal2.setTime(parseDate(format(d2, pattern), new String[] { pattern }));
			return cal1.compareTo(cal2);
		} catch (Exception e) {
			throw new RuntimeException("日期比较异常", e);
		}
	}

	public static int compare(String d1, String d2, String pattern) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		try {
			cal1.setTime(parseDate(d1, new String[] { pattern }));
			cal2.setTime(parseDate(d2, new String[] { pattern }));
			return cal1.compareTo(cal2);
		} catch (Exception e) {
			throw new RuntimeException("日期比较异常", e);
		}
	}

	public static double diffBetweenYear(Date d1, Date d2) {
		BigDecimal dayDiff = new BigDecimal(Math.abs(d2.getTime() - d1.getTime()) / DAY_MILLIS);

		return dayDiff.divide(YEAR_DAYS, 1, RoundingMode.HALF_UP).doubleValue();
	}

	public static Long diffBetweenMonth(Date d1, Date d2) {
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(d1);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(d2);
		long month = (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)) * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
		return month;
	}

}