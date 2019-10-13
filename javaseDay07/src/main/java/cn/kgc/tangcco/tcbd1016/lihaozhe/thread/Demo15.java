package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午10:37:14
 */
public class Demo15 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " = " + i);
			try {
				// 资源被抢走
				if (i == 5) {
					Thread.currentThread().join(1);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Demo15 demo141 = new Demo15();
		demo141.start();
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " = " + i);
		}
	}
}
