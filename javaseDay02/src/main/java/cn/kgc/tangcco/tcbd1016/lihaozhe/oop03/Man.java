package cn.kgc.tangcco.tcbd1016.lihaozhe.oop03;
/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月19日	下午3:47:21
 */
public class Man extends Person{

	public Man() {
		// 调用父类的构造方法
		super();
	}

	public Man(String name, int age) {
		super(name, age);
	}

	@Override
	public void eat() { 
		// 当父类的方法无法满足子类需求的时候 子类可以重写父类的方法 这种表现形式我们称之为方法的重写
		System.out.println("生蚝");
		// 掉用父类的方法
		super.haha();
	}
	public void work() {
		System.out.println("我为心爱的女人打天下");
	}
}
