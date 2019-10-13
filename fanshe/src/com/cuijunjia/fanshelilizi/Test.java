package com.cuijunjia.fanshelilizi;

import java.util.Scanner;

//吃苹果
class Appele extends Shuiguo{

	@Override
	public void eat() {
		System.out.println("我正在吃苹果！");
		
	}
	
}

//吃橘子
class Orange extends Shuiguo{

	@Override
	public void eat() {
		System.out.println("我正在吃橘子！");
		
	}
	
}


//水果的父类
abstract class Shuiguo{
	public abstract void eat();
}

////创建一个简单的工场
//class Factort{
//	public static Shuiguo jiaGong(String name) {
//		switch (name) {
//		case "苹果":
//			return new Appele();
//		case "橘子":
//			return new Orange();
//		default:
//			return null;
//		}
//		
//	}
//}

//达到一个很完美的工场
//通过反射
class Factory{
	public static Shuiguo wanmei(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> c1 = Class.forName(name);
		return (Shuiguo)c1.newInstance();
	}
}



public class Test {
//	//第一种测试方法
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		System.out.println("你想吃苹果还是橘子");
//		String name = s.next();
//		Shuiguo ss = Factort.jiaGong(name);
//		ss.eat();
//	}
	
	//第二种测试方法
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Shuiguo ss = Factory.wanmei("com.cuijunjia.fanshelilizi.Appele");
		ss.eat();
	}
}
