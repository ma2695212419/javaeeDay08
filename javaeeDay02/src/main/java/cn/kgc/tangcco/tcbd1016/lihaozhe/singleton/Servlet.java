package cn.kgc.tangcco.tcbd1016.lihaozhe.singleton;

public class Servlet {
	// 私有的静态成员变量
	private static Servlet serv = null;

	/**
	 * 无参数构造函数
	 */
	private Servlet() {
	}

	/**
	 * 公共静态方法 用于返回实例
	 * 
	 * @return
	 */
	public static Servlet create() {
		// 第一重锁
		if (serv == null) {
			synchronized (Servlet.class) {
				// 第二重锁
				// 双重锁
				if (serv == null) {
					// 加载
					serv = new Servlet();
					// 初始化
					serv.init();
				}
			}
		}
		return serv;
	}

	public void init() {
		System.out.println("init()方法被调用......");
	}

	public void service() {
		System.out.println("service()方法被调用......");
	}


}
