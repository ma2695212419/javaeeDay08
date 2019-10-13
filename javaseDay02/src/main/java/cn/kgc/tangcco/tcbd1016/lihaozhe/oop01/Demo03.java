package cn.kgc.tangcco.tcbd1016.lihaozhe.oop01;

public class Demo03 {
	private String name;
	private int age;

	public Demo03() {
		
	}
	// 使用共有方法访问私有变量
	public void setName(String string) {
		name = string;
	}
	public void setAge(int i) {
		age = i;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
