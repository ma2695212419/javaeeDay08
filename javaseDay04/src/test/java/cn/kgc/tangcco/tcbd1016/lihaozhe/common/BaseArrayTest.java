package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

import java.util.Arrays;

import org.junit.Test;

public class BaseArrayTest {
	@Test
	public void test01() {
		Object[] arr0 = { 0, 1, 2, 3, 4 };
		Object[] arr1 = BaseArray.copyOf(arr0, 3);
		BaseArray.print(arr1);
	}
	@Test
	public void test02() {
		Object[] arr0 = { 0, 1, 2, 3, 4 };
		Object[] arr1 = BaseArray.copyOf(arr0, 10);
		BaseArray.print(arr1);
	}
}
