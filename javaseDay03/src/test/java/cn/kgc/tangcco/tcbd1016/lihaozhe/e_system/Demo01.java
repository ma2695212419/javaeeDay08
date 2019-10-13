package cn.kgc.tangcco.tcbd1016.lihaozhe.e_system;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月20日 下午4:54:08
 */
public class Demo01 {
	@Test
	public void test01() {
		Object[] src = { 0, 1, 2, 3, 4 };
		Object[] dest = { 5, 6, 7, 8, 9 };
		System.arraycopy(src, 1, dest, 2, 2);
		System.out.print(Arrays.toString(dest));
	}
	@Test
	public void test02() {
		Object[] src = { 0, 1, 2, 3, 4 };
		Object[] dest = { 5, 6, 7, 8, 9 };
		System.arraycopy(src, 1, dest, 2, 20);
		System.out.print(Arrays.toString(dest));
	}
	@Test
	public void test03() {
		Object[] src = { 0, 1, 2, 3, 4 };
		Object[] dest = new Object[src.length];
		System.arraycopy(src, 0, dest, 0, src.length);
		System.out.print(Arrays.toString(dest));
	}
}
