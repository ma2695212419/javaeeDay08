package cn.kgc.tangcco.tcbd1016.lihaozhe.oop07;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.oop7.Outter01;
import cn.kgc.tangcco.tcbd1016.lihaozhe.oop7.Outter02;
import cn.kgc.tangcco.tcbd1016.lihaozhe.oop7.Outter03;

/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月19日	下午5:23:37
 */
public class Outter03Test {
	@Test
	public void test01() {
		new Outter03().getInner().excute();
	}
	@Test
	public void test02() {
		new Outter03().newInner().excute();
	}
}
