package cn.kgc.tangcco.tcbd1016.lihaozhe.data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class LocalDateTimeTest {
	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	@Test
	public void test01() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		String format = now.format(formatter);
		System.out.println(format);
	}
	@Test
	public void test02() {
		String text = "1983-11-22 20:30:30";
		LocalDateTime parse = LocalDateTime.parse(text, formatter);
		System.out.println(parse);
		LocalDateTime now = LocalDateTime.now();
		System.out.println(parse.isBefore(now));
		System.out.println(parse.isAfter(now));
	}
	@Test
	public void test03() {
		LocalDateTime bj = LocalDateTime.now();
		LocalDateTime Tokyo = LocalDateTime.now(ZoneOffset.of("+9"));
		System.out.println(bj);
		System.out.println(Tokyo);
	}
	@Test
	public void test04() {
		// 秒级别
		Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
		// 毫秒级别
		Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
		System.out.println(second);
		System.out.println(milliSecond);
	}
}
