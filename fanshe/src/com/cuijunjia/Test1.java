package com.cuijunjia;

import java.util.Date;

//什么是反射？
//所谓的“反” 就是对象找到它的对象出处。
public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException {
		//简单的实现反射的例子
		//第一种方式
		Date date = new Date();
		Class<?> c1 = date.getClass();
		System.out.println("第一种方式："+c1);
		
		//第二种方式
		Class<?> c2 = Date.class;
		System.out.println("第二种方式："+c2);
		
		//第三中方式 也就是最常用的一种方式
		Class<?> c3 = Class.forName("java.util.Date");
		System.out.println("第三种方式："+c3);
		
	}
	

}
