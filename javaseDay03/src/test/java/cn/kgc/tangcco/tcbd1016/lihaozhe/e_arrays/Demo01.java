package cn.kgc.tangcco.tcbd1016.lihaozhe.e_arrays;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月20日 下午4:49:46
 */
public class Demo01 {
	@Test
	public void test01() {
		Object[] arr0 = { 0, 1, 2, 3, 4 };
		Object[] arr1 = Arrays.copyOf(arr0, 3);
		System.out.println(Arrays.toString(arr1));
	}
	@Test
	public void test02() {
		Object[] arr0 = { 0, 1, 2, 3, 4 };
		Object[] arr1 = Arrays.copyOf(arr0, 10);
		System.out.println(Arrays.toString(arr1));
	}
}
