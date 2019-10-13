package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月23日 上午8:21:12
 */
public class Demo18 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " : " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}
	}

	public static void main(String[] args) {
		Demo18 demo18 = new Demo18();
		demo18.start();
		// 线程中断
		demo18.interrupt();
	}

}
