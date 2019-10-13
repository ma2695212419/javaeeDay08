package cn.kgc.tangcco.tcbd1016.lihaozhe.oop07;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.oop7.Outter01;
import cn.kgc.tangcco.tcbd1016.lihaozhe.oop7.Outter02;

/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月19日	下午5:23:37
 */
public class Outter02Test {
	@Test
	public void test01() {
		new Outter02().new Inner().excute();
	}
	@Test
	public void test02() {
		
	}
}
