package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

import lombok.Data;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午9:40:19
 */
@Data
public class Demo07 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		// 线程新建
		Demo07 demo071 = new Demo07();
		Demo07 demo072 = new Demo07();
		// 线程就绪
		demo071.start();
		demo072.start();
	}

}
