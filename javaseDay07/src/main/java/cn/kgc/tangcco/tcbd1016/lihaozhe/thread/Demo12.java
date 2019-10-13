package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午10:37:14
 */
public class Demo12 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " = " + i);
		}
	}

	public static void main(String[] args) {
		Demo12 demo121 = new Demo12();
		demo121.start();
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " = " + i);
		}
	}
}
