package cn.kgc.tangcco.tcbd1016.lihaozhe.oop02;

public class Demo02 {
	private String name;
	private int age;

	public Demo02() {
		System.out.println("我是Demo02的无参构造方法");
	}

	public Demo02(String name, int age) {
		System.out.println("我是Demo02的有参构造方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void fun01() {
		System.out.println("我是Demo01的静态方法fun01()");
	}

	public void fun02() {
		System.out.println("我是Demo01的非静态方法fun02()");
	}
}
