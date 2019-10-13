package cn.kgc.tangcco.tcbd1016.lihaozhe.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

public class DateTest {
	@Test
	public void test01() {
		Date date = new Date();
		System.out.println(date);
		int year = date.getYear() + 1900;
		System.out.println(year);
		int month = date.getMonth() + 1;
		String monthString = (month > 9) ? String.valueOf(month) : "0" + month;
		System.out.println(month);
		int dayOfMonth = date.getDate();
		System.out.println(dayOfMonth);
		String dayOfMonthString = (dayOfMonth > 9) ? String.valueOf(dayOfMonth) : "0" + dayOfMonth;
		System.out.print(year + "-" + monthString + "-" + dayOfMonthString + "\t");
		int hours = date.getHours();
		String hoursString = (hours > 9) ? String.valueOf(hours) : "0" + hours;
		int minutes = date.getMinutes();
		String minutesString = (minutes > 9) ? String.valueOf(minutes) : "0" + minutes;
		int seconds = date.getSeconds();
		String secondsString = (seconds > 9) ? String.valueOf(seconds) : "0" + seconds;
		System.out.println(hoursString + ":" + minutesString + ":" + secondsString);
		// 1566799872896
		// GMT
		System.out.println(date.getTime());
		// UTC
		System.out.println(System.currentTimeMillis());
		// 北京时间=UTC+8=GMT+8。
		Date date2 = new Date(1566799872896L);
		System.out.println(date2);
	}

	@Test
	public void test02() {
		Date date = new Date();
		int day = date.getDay();
		System.out.print("星期");
		switch (day % 7) {
		case 0:
			System.out.println("日");
			break;
		case 1:
			System.out.println("一");
			break;
		case 2:
			System.out.println("二");
			break;
		case 3:
			System.out.println("三");
			break;
		case 4:
			System.out.println("四");
			break;
		case 5:
			System.out.println("五");
			break;
		case 6:
			System.out.println("六");
			break;

		default:
			System.out.println("OMG");
			break;
		}
	}

	@Test
	public void test03() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(date);
		System.out.println(format);
		String source = "1983-11-22 20:30:00";
		try {
			Date parse = sdf.parse(source);
			System.out.println(parse);
			System.out.println(parse.before(date));
			System.out.println(parse.after(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test04() {
		System.out.println(System.currentTimeMillis());
		Date date = new Date();
		System.out.println(date.getTime());
		String gmtString = date.toGMTString();
		System.out.println(gmtString);
		System.out.println(date.getTimezoneOffset());
		System.out.println(TimeZone.getDefault());
		
	}

	@Test
	public void test05() {
		Date date = new Date();

		SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 北京
		bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai")); // 设置北京时区

		SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 东京
		tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo")); // 设置东京时区

		SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
		londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London")); // 设置伦敦时区

		System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
		System.out.println("毫秒数:" + date.getTime() + ", 东京时间:" + tokyoSdf.format(date));
		System.out.println("毫秒数:" + date.getTime() + ", 伦敦时间:" + londonSdf.format(date));
	}
}
