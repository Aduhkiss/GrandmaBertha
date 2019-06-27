package me.atticusthecoder.bertha.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {
	public static String getMilliToFormatted(long milli) {
		Date date = new Date(milli);
		DateFormat formatter = new SimpleDateFormat("YY-MM-DD HH:MM");
		formatter.setTimeZone(TimeZone.getTimeZone("PDT"));
		return formatter.format(date);
	}
}
