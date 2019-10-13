package cn.kgc.tangcco.tcbd1016.lihaozhe.b_oop01;

import java.util.Scanner;

/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月20日	下午3:15:38
 */
public class Demo03 {
	public static void main(String[] args) {
		String str =  "abc";
		System.out.print("请输入一个整数》》》");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		if (i < str.length()) {
			System.out.println(str.charAt(i));
		} else {
			System.out.println("你个sb");
		}
		
	}
}
