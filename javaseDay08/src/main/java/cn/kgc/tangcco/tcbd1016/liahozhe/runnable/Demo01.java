package cn.kgc.tangcco.tcbd1016.liahozhe.runnable;

public class Demo01 implements Runnable {
	public static void main(String[] args) {
		// 推荐实现Runnable接口的方式使用多线程
		// 理由1、java不支持多继承所有使用实现接口的方式更加灵活
		// 理由2、实现Runnable接口的方式比继承Thread类的方式更容易实现资源的共享
		Runnable runnable = new Demo01();
		Thread thread01 = new Thread(runnable);
		thread01.setName("马什么梅");
		Thread thread02 = new Thread(runnable);
		thread02.setName("马梅");
		thread01.start();
		thread02.start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
