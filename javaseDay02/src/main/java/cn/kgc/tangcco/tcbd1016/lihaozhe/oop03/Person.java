package cn.kgc.tangcco.tcbd1016.lihaozhe.oop03;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月19日 下午3:46:00
 */
public class Person {
	private String name;
	private int age;

	public Person() {

	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void eat() {
		System.out.println("吃吃吃");
	}
	public void haha() {
		System.out.println("哈哈");
	}
}
