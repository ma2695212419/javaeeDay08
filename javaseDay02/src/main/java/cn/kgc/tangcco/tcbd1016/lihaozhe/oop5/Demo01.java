package cn.kgc.tangcco.tcbd1016.lihaozhe.oop5;
/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月19日	下午4:15:10
 */
public class Demo01 {
	public static void main(String[] args) {
		Demo01 demo01 = new Demo01();
		System.out.println(demo01);
		System.out.println(demo01.hashCode());
		System.out.println(Integer.toHexString(demo01.hashCode()));
		// 内存地址的hash值的十六进制
	}
}
