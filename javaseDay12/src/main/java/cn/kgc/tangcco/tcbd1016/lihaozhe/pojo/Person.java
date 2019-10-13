package cn.kgc.tangcco.tcbd1016.lihaozhe.pojo;

public class Person {
	static {
		System.out.println("我是Person的静态代码块");
	}
	{
		System.out.println("我是Person的构造代码块");
	}
	private String name;

	private Person() {
		System.out.println("我是Person的无参构造方法");
	}

	public Person(String name) {
		System.out.println("我是Person有参构造方法");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void haha() {
		System.out.println("我是静态方法");
	}

	public void hehe() {
		System.out.println("我是非静态方法");
	}

	public int sum(int a, int b) {
		return a + b;
	}

}
