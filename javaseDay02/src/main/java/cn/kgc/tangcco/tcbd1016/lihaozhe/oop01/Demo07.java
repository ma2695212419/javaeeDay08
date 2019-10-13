package cn.kgc.tangcco.tcbd1016.lihaozhe.oop01;

public class Demo07 {
	private String food;
	private int count;

	public Demo07() {

	}
	public Demo07(int count) {
		sleep();
		this.eat(food, count);
	}
	public Demo07(String food, int count) {
		// this.setFood(food);
		// 调用本类的构造方法
		// this调用本类的构造方法 该行代码必须在该方法的首行
		this(count);
	}

	/**
	 * this关键字代表当前的调用者，this为当前对象 this.属性名指的是当前类的成员变量
	 */

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private void eat(String food, int count) {
		System.out.println("吃" + count + "个" + food);
	}
	private void sleep() {
		System.out.print("睡美人");
	}
}
