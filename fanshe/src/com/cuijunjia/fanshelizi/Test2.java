package com.cuijunjia.fanshelizi;

public class Test2 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//1.通过实例化的方式进行new对象
//		Person person = new Person();
//		System.out.println(person);
		
		//2.通过反射去实现
		Class<?> c1 = Class.forName("com.cuijunjia.fanshelizi.Person");
		Object o = c1.newInstance();//相当于调用了无参构造
		System.out.println(o);
		
		
		
		
	}
}
