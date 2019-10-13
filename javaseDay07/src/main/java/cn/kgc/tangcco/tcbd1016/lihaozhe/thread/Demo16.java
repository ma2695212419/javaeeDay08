package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午10:55:55
 */
public class Demo16 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		Demo16 demo161 = new Demo16();
		demo161.setName("李昊哲");
		Demo16 demo162 = new Demo16();
		demo162.setName("马什么梅");
//		System.out.println(demo161.getPriority());
//		System.out.println(demo162.getPriority());
		demo162.setPriority(MIN_PRIORITY);
		demo161.setPriority(MAX_PRIORITY);
//		System.out.println(demo161.getPriority());
//		System.out.println(demo162.getPriority());
		demo162.start();
		demo161.start();

	}
}
