package cn.kgc.tangcco.tcbd1016.lihaozhe.objectstram;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = -6012688308659353644L;
	private String name;
	// transient 透明的 在序列化该类的实例化对象的时候 不序列化该属性
	private transient int age;
	private int gender;
	private Address address;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, int gender, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
