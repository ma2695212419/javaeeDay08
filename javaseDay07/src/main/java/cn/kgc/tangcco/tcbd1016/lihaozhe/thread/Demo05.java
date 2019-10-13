package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

import lombok.Data;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午9:40:19
 */
@Data
public class Demo05 extends Thread {
	private String lastName;

	public Demo05() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo05(String lastName) {
		super();
		this.lastName = lastName;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// 线程新建
		Demo05 demo021 = new Demo05("李昊哲");
		Demo05 demo022 = new Demo05("马什么梅");
		// 线程就绪
		demo021.start();
		demo022.start();
	}

}
