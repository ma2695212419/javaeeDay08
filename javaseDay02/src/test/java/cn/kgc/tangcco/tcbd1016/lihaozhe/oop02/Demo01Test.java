package cn.kgc.tangcco.tcbd1016.lihaozhe.oop02;

import org.junit.Test;

public class Demo01Test {
	@Test
	public void test01() {
		Demo01.fun01();
	}
	@Test
	public void test02() {
		Demo01 demo01 = new Demo01();
		demo01.fun01();
		demo01.fun02();
	}
}
