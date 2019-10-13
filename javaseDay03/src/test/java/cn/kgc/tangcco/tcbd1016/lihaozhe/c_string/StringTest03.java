package cn.kgc.tangcco.tcbd1016.lihaozhe.c_string;

import org.junit.Test;

/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月20日	下午3:55:04
 */
public class StringTest03 {
	@Test
	public void test01() {
		String str01 = "abc";
		String str02 = "abc";
		String str03 = "abcd";
		String str04 = "aBc";
		// true
		System.out.println(str01.equals(str02));
		// false
		System.out.println(str01.equals(str03));
		// 两个字符串如果内容一致则返回数字0
		System.out.println(str01.compareTo(str02));
		// 两个字符串如果内容一直则返回非0的数字
		System.out.println(str01.compareTo(str03));
		// compareTo大小写敏感
		System.out.println(str02.compareTo(str04));
		// compareToIgnoreCase大小写不敏感
		System.out.println(str02.compareToIgnoreCase(str04));
	}
	@Test
	public void test02() {
		System.out.println("a".compareTo("b"));
		System.out.println("b".compareTo("a"));
		System.out.println("a".compareTo("c"));
		System.out.println("c".compareTo("a"));
		System.out.println("ab".compareTo("ac"));
	}
	@Test
	public void test07() {
		// 需求将字符串转大写注意不允许使用Character中的方法
		String str01 = "abc";
		System.out.println(str01.toUpperCase());
	}

	@Test
	public void test08() {
		// 需求将字符串转小写注意不允许使用Character中的方法
		String str01 = "ABC";
		System.out.println(str01.toLowerCase());
	}
}
