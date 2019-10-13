package cn.kgc.tangcco.tcbd1016.lihaozhe.oop01;

public class Demo04 {
	private String name;
	private int age;

	public Demo04() {
		
	}
	// 使用共有方法访问私有变量
	public void setName(String name) {
		name = name;
	}
	public void setAge(int age) {
		age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
