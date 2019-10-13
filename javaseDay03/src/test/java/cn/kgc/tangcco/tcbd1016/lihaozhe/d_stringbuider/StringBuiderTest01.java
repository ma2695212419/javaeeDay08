package cn.kgc.tangcco.tcbd1016.lihaozhe.d_stringbuider;

import org.junit.Test;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月20日 下午4:22:10
 */
public class StringBuiderTest01 {
	@Test
	public void test01() {
		String str01 = "a";
		str01 += "b";
		str01 += "c";
		System.out.println(str01);
	}

	@Test
	public void test02() {
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		sb.append("b");
		sb.append("c");
		System.out.println(sb.toString());
	}

	@Test
	public void test03() {
		StringBuilder sb = new StringBuilder("abc");
		System.out.println(sb.reverse().toString());
	}

	@Test
	public void test04() {
		StringBuilder sb = new StringBuilder("abc");
		sb.insert(1, "d");
		System.out.println(sb.toString());
	}

	@Test
	public void test05() {
		StringBuilder sb = new StringBuilder("abc");
		sb.setCharAt(1, 'd');
		System.out.println(sb.toString());
	}

	@Test
	public void test06() {
		StringBuilder sb = new StringBuilder("abcdefg");
		sb.replace(2, 4, "我爱你中国");
		System.out.println(sb.toString());
	}

	@Test
	public void test07() {
		StringBuilder sb = new StringBuilder();
		int capacity = sb.capacity();
		System.out.println(capacity);
	}

	@Test
	public void test08() {
		StringBuilder sb = new StringBuilder(32);
		int capacity = sb.capacity();
		System.out.println(capacity);
	}

	@Test
	public void test09() {
		StringBuilder sb = new StringBuilder("abcde");
		sb.deleteCharAt(1);
		System.out.println(sb.toString());
	}

	@Test
	public void test10() {
		StringBuilder sb = new StringBuilder("abcde");
		sb.delete(1, 3);
		System.out.println(sb.toString());
	}
}
