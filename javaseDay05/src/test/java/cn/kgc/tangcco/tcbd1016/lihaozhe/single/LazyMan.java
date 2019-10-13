package cn.kgc.tangcco.tcbd1016.lihaozhe.single;

public class LazyMan {
	// 声明该类的实例化对象变量
	private static  LazyMan instance = null;
	// 私有化构造方法
	private LazyMan() {
		
	}
	// 使用共有方法访问私有变量
	public static LazyMan newInstatnce() {
		if (instance == null) {
			instance = new LazyMan();
		}
		return instance;
	}
}
