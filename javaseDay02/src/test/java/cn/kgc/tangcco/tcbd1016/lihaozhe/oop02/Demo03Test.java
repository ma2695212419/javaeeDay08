package cn.kgc.tangcco.tcbd1016.lihaozhe.oop02;

import org.junit.Test;

public class Demo03Test {
	@Test
	public void test01() {
		Demo03 demo01 = new Demo03();
		Demo03 demo02 = new Demo03("李昊哲", 37);
	}
	@Test
	public void test02() {
		Demo03.fun01();
		Demo03.fun01();
	}
	@Test
	public void test03() {
		Demo03 demo01 = new Demo03();
		Demo03 demo02 = new Demo03("李昊哲", 37);
	}
}
