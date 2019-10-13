package cn.kgc.tangcco.tcbd1016.lihaozhe.enumeration;

import org.junit.Test;

/**
 * 
 * @author	张仙利
 * @version	1.0	<br>
 *	创建时间:	2019年8月23日	下午2:29:19
 */
public class WeekDayTest {
	@Test
	public void test01() {
		System.out.print("今天是星期");
		switch (WeekDay01.Friday) {
		case "Sunday":
			System.out.println("日");
			break;
		case "Monday":
			System.out.println("一");
			break;
		case "Tuesday":
			System.out.println("二");
			break;
		case "Wednesday":
			System.out.println("三");
			break;
		case "Thursday":
			System.out.println("四");
			break;
		case "Friday":
			System.out.println("五");
			break;
		case "Saturday":
			System.out.println("六");
			break;

		default:
			System.out.println("程序异常");
			break;
		}
	}
	@Test
	public void test02() {
		System.out.print("今天是星期");
		switch (WeekDay02.Friday) {
		case "Sunday":
			System.out.println("日");
			break;
		case "Monday":
			System.out.println("一");
			break;
		case "Tuesday":
			System.out.println("二");
			break;
		case "Wednesday":
			System.out.println("三");
			break;
		case "Thursday":
			System.out.println("四");
			break;
		case "Friday":
			System.out.println("五");
			break;
		case "Saturday":
			System.out.println("六");
			break;
			
		default:
			System.out.println("程序异常");
			break;
		}
	}
	@Test
	public void test03() {
		System.out.print("今天是星期");
		switch (WeekDay.Friday.toString()) {
		case "Sunday":
			System.out.println("日");
			break;
		case "Monday":
			System.out.println("一");
			break;
		case "Tuesday":
			System.out.println("二");
			break;
		case "Wednesday":
			System.out.println("三");
			break;
		case "Thursday":
			System.out.println("四");
			break;
		case "Friday":
			System.out.println("五");
			break;
		case "Saturday":
			System.out.println("六");
			break;
			
		default:
			System.out.println("程序异常");
			break;
		}
	}
}

