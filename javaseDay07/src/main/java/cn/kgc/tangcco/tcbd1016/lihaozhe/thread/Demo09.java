package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

import lombok.Data;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午9:40:19
 */
@Data
public class Demo09 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		// 线程新建
		Demo09 demo091 = new Demo09();
		demo091.setName("李昊哲");
		Demo09 demo092 = new Demo09();
		demo092.setName("马什么梅");
		// 线程就绪
		demo091.start();
		demo092.start();
	}

}
