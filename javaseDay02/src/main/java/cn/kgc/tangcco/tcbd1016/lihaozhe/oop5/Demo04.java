package cn.kgc.tangcco.tcbd1016.lihaozhe.oop5;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月19日 下午4:28:50
 */
public class Demo04 {
	private String name;
	private int age;
	private int gender;

	public Demo04() {
	}

	public Demo04(String name, int age, int gender) {
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
	public int hashCode() {
		int code = 1024;
		if (gender == 1) {
			code += 1267;
		}else if(gender == 2){
			code += 1268;
		}
		return code + age + name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

	public static void main(String[] args) {
		Demo04 demo01 = new Demo04("李昊哲", 37, 1);
		Demo04 demo02 = new Demo04("李昊哲", 37, 1);
		System.out.println(demo01.equals(demo02));
	}
}
