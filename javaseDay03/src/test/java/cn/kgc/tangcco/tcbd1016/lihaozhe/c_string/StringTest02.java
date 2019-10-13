package cn.kgc.tangcco.tcbd1016.lihaozhe.c_string;

import org.junit.Test;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月20日 下午2:53:12
 */
public class StringTest02 {
	@Test
	public void test01() {
		char[] chars = { 'l', 'o', 'v', 'e' };
		// 利用构造方法生成字符串
		String str01 = new String(chars);
		System.out.println(str01);
		// 利用valueOf法生成字符串
		String str02 = String.valueOf(chars);
		System.out.println(str02);
	}

	@Test
	public void test02() {
		// contains字符串中是否包含另外一个字符串返回值为布尔类型
		String str01 = "abc";
		// true
		System.out.println(str01.contains("b"));
		// false
		System.out.println(str01.contains("d"));
	}

	@Test
	public void test03() {
		// indexOf字符串中是否包含另外一个字符串第一次出现的index
		String str01 = "abcbcbe";
		// 1
		System.out.println(str01.indexOf("b"));
		// -1
		System.out.println(str01.indexOf("d"));
		System.out.println(str01.lastIndexOf("b"));
	}

	@Test
	public void test04() {
		String str01 = "abc";
		System.out.println(str01.charAt(1));
		System.out.println(str01.length());
		System.out.println(str01.charAt(4));
	}

	@Test
	public void test05() {
		String str01 = "abc";
		for (int i = 0; i < str01.length(); i++) {
			System.out.println(str01.charAt(i));
		}
	}

	@Test
	public void test06() {
		String str01 = "abc";
		String str02 = "ABC";
		System.out.println(str01.toUpperCase());
		System.out.println(str02.toLowerCase());
	}

	@Test
	public void test07() {
		String str01 = "abc";
		char c = str01.charAt(0);
		char d = (char) (c - 32);
		char[] chars = new char[str01.length()];
		chars[0] = d;
		for (int i = 1; i < str01.length(); i++) {
			chars[i] = str01.charAt(i);
		}
		String str02 = new String(chars);
		System.out.println(str02);
	}
	@Test
	public void test08() {
		System.out.println(Character.toLowerCase('A'));
		System.out.println(Character.toLowerCase(65));
		System.out.println(Character.toUpperCase(97));
		System.out.println(Character.toUpperCase('a'));
	
	}
	@Test
	public void test09() {
		String str01  = "abc";
		String str02 = "";
		for (int i = str01.length() - 1; i >= 0; i--) {
			str02 += str01.charAt(i);
		}
		System.out.println(str02);
	}
}
