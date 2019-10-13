package cn.kgc.tangcco.tcbd1016.lihaozhe.c_string;

import org.junit.Test;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月20日 下午2:53:12
 */
public class StringTest01 {
	/**
	 * equals方法只比较字符串的内容大小写敏感 equalsIgnoreCase方法只比较字符串的内容大小写不敏感
	 */
	@Test
	public void test01() {
		String str01 = "abc";
		String str02 = "abc";
		String str03 = "aBc";
		// true
		System.out.println(str01 == str02);
		System.out.println(str01.equals(str02));
		System.out.println(str01.equals(str03));
		System.out.println(str01.equalsIgnoreCase(str03));
	}

	@Test
	public void test02() {
		String str01 = "abc";
		String str02 = "abc";
		String str03 = new String("abc");
		String str04 = new String("abc");
		// true
		System.out.println(str01 == str02);
		// true
		System.out.println(str01.equals(str02));
		// false
		System.out.println(str01 == str03);
		// true
		System.out.println(str01.equals(str03));
		// false
		System.out.println(str03 == str04);
		// true
		System.out.println(str03.equals(str04));
	}
	@Test
	public void test03() {
		// 加号遇到字符串就不再是数学运算了而是字符串的拼接
		int a = 10, b = 20 , c;
		c = a + b;
		System.out.println(c);
		String str = "" + 50;
		System.out.println(str instanceof String);
		String d = "a".concat("b");
		// concat方法代表字符串的拼接
		System.out.println(d);
	}
}
