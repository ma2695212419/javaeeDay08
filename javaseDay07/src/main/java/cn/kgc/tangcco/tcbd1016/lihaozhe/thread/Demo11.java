package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午10:00:06
 */
public class Demo11 extends Thread {

	@Override
	public void run() {
		int count = 0;
		while (true) {
			System.out.println(Thread.currentThread().getName() + count++);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Demo11 demo10 = new Demo11();
		demo10.setName("Jack");
		// 子线程模式守护线程状态为false	主线程destroy 但是不影响子线继续执行
		// 子线程模式守护线程状态为true	主线程destroy 子线destroy
		demo10.setDaemon(true);
		demo10.start();
		int count = 0;
		while (true) {
			Thread.currentThread().setName("Rose");
			System.out.println(Thread.currentThread().getName() + count++);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (count == 25) {
				System.out.println(Thread.currentThread().getName() + "Jump");
				break;
			}
		}
	}
}
