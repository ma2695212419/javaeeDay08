package cn.kgc.tangcco.tcbd1016.lihaozhe.oop07;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.oop7.Demo;

/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月19日	下午5:25:47
 */
public class DemoTest {
	@Test
	public void test01() {
		Demo demo = new Demo();
		demo.haha();
	}
	@Test
	public void test02() {
		// 匿名对象
		new Demo().haha();
	}
} 
