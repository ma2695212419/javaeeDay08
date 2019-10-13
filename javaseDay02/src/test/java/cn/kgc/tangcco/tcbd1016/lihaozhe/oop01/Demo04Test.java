package cn.kgc.tangcco.tcbd1016.lihaozhe.oop01;

import org.junit.Test;

public class Demo04Test {
	@Test
	public void test01() {
		Demo04 demo02 = new Demo04();
//		demo02.name = "李昊哲";
//		demo02.age = 37;
//		System.out.println("姓名:" + demo02.name + "\t年龄:" + demo02.age);
		demo02.setName("李昊哲");
		demo02.setAge(37);
		System.out.println("姓名:" + demo02.getName() + "\t年龄:" + demo02.getAge());
	}
}
