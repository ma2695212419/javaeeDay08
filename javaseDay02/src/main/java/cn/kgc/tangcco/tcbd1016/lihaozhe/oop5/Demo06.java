package cn.kgc.tangcco.tcbd1016.lihaozhe.oop5;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月19日 下午4:28:50
 */
public class Demo06 {
	private String name;
	private int age;
	private int gender;

	public Demo06() {
	}

	public Demo06(String name, int age, int gender) {
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
	protected Object clone() throws CloneNotSupportedException {
		// 浅克隆
		return this;
	}

	public static void main(String[] args) {
		Demo06 demo01 = new Demo06("李昊哲", 37, 1);
		Demo06 demo02 = demo01;

		System.out.println(demo01.getName());
		System.out.println(demo02.getName());
		System.out.println("++++++++++++++++++++++++++++++++");
		demo01.setName("李爽");
		System.out.println(demo01.equals(demo02));
		System.out.println(demo01.getName());
		System.out.println(demo02.getName());
		System.out.println("++++++++++++++++++++++++++++++++");
		try {
			Demo06 demo03 = (Demo06) demo01.clone();
			demo01.setName("李奇媛");
			System.out.println(demo01.equals(demo03));
			System.out.println(demo01.getName());
			System.out.println(demo03.getName());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
