package cn.kgc.tangcco.tcbd1016.lihaozhe.b_oop01;
/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月20日	下午2:15:18
 */
public class Demo01Test {

	public static void main(String[] args) {
		Demo01 demo01 = new Demo01();
		Demo01 demo02 = new Demo01();
		// 2
		System.out.println(demo01.getA());
		// 1
		System.out.println(demo01.getB());
		// 2
		System.out.println(demo02.getA());
		// 1
		System.out.println(demo02.getB());
		// 10	20
		demo01.show();
		// 10	20
		demo02.show();
	}

}
