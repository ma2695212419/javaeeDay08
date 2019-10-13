package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

import org.junit.Test;

public class BaseSystemTest {
	@Test
	public void test01() {
		Object[] arr0 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BaseSystem.arraycopy(arr0, 2, arr0, 4, 3);
		BaseArray.print(arr0);
	}
	@Test
	public void test02() {
		Object[] arr0 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.arraycopy(arr0, 2, arr0, 4, 3);
		BaseArray.print(arr0);
	}
}
