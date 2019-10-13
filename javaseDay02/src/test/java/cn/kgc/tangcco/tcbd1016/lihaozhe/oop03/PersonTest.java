package cn.kgc.tangcco.tcbd1016.lihaozhe.oop03;

import org.junit.Test;

/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月19日	下午3:51:29
 */
public class PersonTest {
	@Test
	public void test01() {
		// 父类的引用指向子类的实例化对象
		Person p01 = new Man();
		p01.eat();
	}
	@Test
	public void test02() {
		// 父类的引用指向子类的实例化对象
		Person p01 = new Man();
		((Man)p01).work();
	}
	@Test
	public void test03() {
		// 父类的引用指向子类的实例化对象
		Person p01 = new Man();
		// instanceof 判断该对象是否属于某个类
		System.out.println(p01 instanceof Man);
		System.out.println(p01 instanceof Person);
	}
}
