package cn.kgc.tangcco.tcbd1016.commons.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseDateUitls {
	private final static String formatString = "yyyy-MM-dd HH:mm:ss";

	public static String getDateString(Date date) {
		return getDateString(date, formatString);
	}

	public static String getDateString(Date date, String formatString) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		return sdf.format(date);
	}
}
