package cn.kgc.tangcco.tcbd1016.lihaozhe.single;

public class HungryMan {
	// 创建该类的静态实例化对象
	// 由于类对象为static修饰则该类的对象在jvm中只有一个对象
	private static HungryMan instance = new HungryMan();
	// 私有化构造方法防止外部类对该类进行实例化
	private HungryMan() {

	}
	// 根据共有方法访问私有变量赶回该类的实例化对象
	public static HungryMan newInstatnce() {
		return instance;
	}
}
