package cn.kgc.tangcco.tcbd1016.lihaozhe.oop5;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月19日 下午4:28:50
 */
public class Demo03 {
	private String name;
	private int age;
	private int gender;

	public Demo03() {
	}

	public Demo03(String name, int age, int gender) {
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

	public static void main(String[] args) {
		Demo03 demo01 = new Demo03("李昊哲", 37, 1);
		Demo03 demo02 = new Demo03("李昊哲", 37, 1);
		System.out.println(demo01.equals(demo02));
	}
}
