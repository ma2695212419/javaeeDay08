package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

import lombok.Data;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午9:40:19
 */
@Data
public class Demo04 extends Thread {
	private String lastName;

	public Demo04() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo04(String lastName) {
		super();
		this.lastName = lastName;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this);
		}
	}

	public static void main(String[] args) {
		// 线程新建
		Demo04 demo021 = new Demo04("李昊哲");
		Demo04 demo022 = new Demo04("马什么梅");
		// 线程就绪
		demo021.start();
		demo022.start();
	}

}
