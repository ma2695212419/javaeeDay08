package cn.kgc.tangcco.tcbd1016.lihaozhe.oop01;

import org.junit.Test;

public class Demo08Test {
	@Test
	public void test01() {
		 Demo08 demo01 = new Demo08();
		 demo01.setName("李昊哲");
		 demo01.setAge(37);
		 System.out.println(demo01);
	}
	@Test
	public void test02() {
		Demo08 demo01 = new Demo08("李昊哲", 37);
		System.out.println(demo01);
	}
}
