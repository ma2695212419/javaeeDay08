package cn.kgc.tangcco.tcbd1016.lihaozhe.b_oop01;
/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月20日	下午2:12:40
 */
public class Demo01 {
	private static int a;
	private int b;
	public Demo01() {
		a++;
		b++;
	}
	public static int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	
	public void show() {
		int a = 10;
		int b = 20;
		System.out.println("show方法中a的值>>>" + a);
		System.out.println("show方法中b的值>>>" + b);
	}
}
