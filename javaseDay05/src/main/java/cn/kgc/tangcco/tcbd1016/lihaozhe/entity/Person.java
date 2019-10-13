package cn.kgc.tangcco.tcbd1016.lihaozhe.entity;

public class Person implements Comparable{
	private String name;
	private int age;
	private int gender;

	public Person() {
		super();
	}

	public Person(String name, int age, int gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
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

	@Override
	public String toString() {
		return "姓名>>>" + this.name + "\t性别>>>" + ((this.gender == 2)? "女" : "男") + "\t年龄>>>" + this.age;
	}

	@Override
	public int compareTo(Object o) {
		Person p = (Person) o;
		int y = p.gender - this.gender;
		int z = p.age - this.age;
		int x = p.name.compareTo(this.getName());
		if (y != 0) {
			return y;
		} else if (z != 0) {
			return z;
		} else {
			return x;
		}
	}

}
