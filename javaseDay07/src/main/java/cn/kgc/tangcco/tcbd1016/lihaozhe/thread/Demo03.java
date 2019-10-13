package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

import lombok.Data;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午9:40:19
 */
@Data
public class Demo03 extends Thread {
	private String lastName;

	public Demo03() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo03(String lastName) {
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
		Demo03 demo021 = new Demo03("李昊哲");
		Demo03 demo022 = new Demo03("马什么梅");
		demo021.run();
		demo022.run();
	}

}
