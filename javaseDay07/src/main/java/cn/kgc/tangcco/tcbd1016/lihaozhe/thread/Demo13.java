package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午10:37:14
 */
public class Demo13 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " = " + i);
			if (i > 10) {
				// 让出CPU资源
				Thread.yield();
			}
		}
	}
	public static void main(String[] args) {
		 Demo13 demo131 = new Demo13();
		 Demo13 demo132 = new Demo13();
		 demo131.start();
		 demo132.start();
	}
}
