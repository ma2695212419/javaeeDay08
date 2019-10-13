package cn.kgc.tangcco.tcbd1016.lihaozhe.c_string;

import java.util.UUID;

import org.junit.Test;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月20日 下午3:58:46
 */
public class StringTest04 {
	@Test
	public void test01() {
		String str01 = "abcdefgh";
		// 字符串截取
		System.out.println(str01.substring(2));
		// 前包后不包
		System.out.println(str01.substring(2, 6));
	}

	@Test
	public void test02() {
		String str01 = "abcdabcd";
		// 字符串替换
		System.out.println(str01.replace('c', 'e'));
		System.out.println(str01.replaceFirst("b", "f"));
		System.out.println(str01.replaceAll("ab", "h"));
	}

	@Test
	public void test03() {
		String str01 = "2019-08-20";
		String[] split = str01.split("-");
		for (String string : split) {
			System.out.println(string);
		}
	}

	@Test
	public void test04() {
		String str01 = "2019-06-17 10:37:25";
		String[] split = str01.split(" ");
		// 2019-06-17
		// 10:37:25
		String[] split2 = split[0].split("-");
		String[] split3 = split[1].split(":");
	}

	@Test
	public void test05() {
		String str01 = " a b c ";
		System.out.println(str01.length());
		// trim首尾祛空格
		System.out.println(str01.trim().length());
		System.out.println(str01);
		System.out.println(str01.trim());
		System.out.println(str01.replaceAll(" ", ""));
		System.out.println(str01.replaceAll(" ", "").length());
	}

	@Test
	public void test06() {
		String str01 = "abcabcabc";
		System.out.println(str01.lastIndexOf("abc"));
		System.out.println(str01.indexOf("abc"));
	}

	@Test
	public void test07() {
		String str01 = "照片.jpg";
		System.out.println(str01.lastIndexOf(".jpg"));
		System.out.println(str01.substring(0, str01.lastIndexOf(".jpg")));
		System.out.println(str01.substring(str01.lastIndexOf(".")));
	}

	@Test
	public void test08() {
		String str01 = "婚礼.rmvb";
		String endString = str01.substring(str01.lastIndexOf("."));
		System.out.println(endString);
		String startString = UUID.randomUUID().toString();
		String fileName = startString + endString;
		System.out.println(fileName);
	}
	@Test
	public void test09() {
		String str01 = "123456.rmvb";
		// true
		System.out.println(str01.startsWith("123"));
		// false
		System.out.println(str01.startsWith("23"));
		// true
		System.out.println(str01.startsWith("23", 1));
		// trues
		System.out.println(str01.endsWith(".rmvb"));
	}

}
