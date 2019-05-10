package com.ketangpai.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.TimeZone;

/**
 * 
 * @author zhaolizhen2009@gmail.com
 *
 */
public class DateUtils {

	private static long TIME_ZONE_OFFSET = TimeZone.getDefault().getRawOffset();

	private static final DateTimeFormatter defaultFormatter = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm:ss.SSS");

	private static final DateTimeFormatter secondFormatter = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm:ss");

	private static final DateTimeFormatter defaultDayFormatter = DateTimeFormat
			.forPattern("yyyy-MM-dd");

	private static final DateTimeFormatter ymdhmFormatter = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm");

	private static final DateTime dt = new DateTime();

	public static String format(long mills) {
		return defaultFormatter.print(mills);
	}

	public static long getMills(String datetime) {
		return defaultDayFormatter.parseDateTime(datetime).getMillis();// 返回1970-01-01
																		// 以来毫秒数
	}

	public static String formatYMD(long mills) {
		return defaultDayFormatter.print(mills);
	}

	public static String formatYMDHM(long mills) {
		return ymdhmFormatter.print(mills);
	}

	public static String toStringLowerSecond(long mills) {
		return secondFormatter.print(mills);
	}

	public static long getSecond(String datetime) {
		return secondFormatter.parseDateTime(datetime).getMillis() / 1000;
	}

	public static long toUTCMills(long mills) {
		return mills - TIME_ZONE_OFFSET;
	}

	public static long getCurrentSecond() {
		return System.currentTimeMillis() / 1000;
	}

	public static long getNextStartDay() {
		return getSecond(dt.plusDays(1).toString("yyyy-MM-dd 00:00:00"));
	}
}
