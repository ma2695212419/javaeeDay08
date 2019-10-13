package cn.kgc.tangcco.tcbd1016.lihaozhe.oop01;

public class Demo05 {
	private String name;
	private int age;

	public Demo05() {
		
	}
	/**
	 * this关键字代表当前的调用者，this为当前对象
	 * this.属性名指的是当前类的成员变量
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
