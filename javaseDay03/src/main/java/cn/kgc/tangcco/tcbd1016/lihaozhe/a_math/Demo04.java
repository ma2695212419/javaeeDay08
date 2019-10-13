package cn.kgc.tangcco.tcbd1016.lihaozhe.a_math;

import java.util.Random;

/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月20日	下午1:53:24
 */
public class Demo04 {

	public static void main(String[] args) {
		// 0 到 1 之间但是不包含1的小数
		double random = Math.random();
		// 0到10之间不包含10 的整数
		double floor = Math.floor(random * 10);
		int a = (int) floor;
		System.out.println(a);
		System.out.println("++++++++++++++++++++++++");
		for (int i = 0; i <10; i++) {
			 System.out.println((int)Math.floor(Math.random() * 10));
		}
	}

}
