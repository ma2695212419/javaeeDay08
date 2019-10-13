package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

import lombok.Data;

/**
 * @author 李昊哲
 * @version 1.0
 * 创建时间：	2019年6月22日 上午9:40:19
 */
@Data
public class Demo02 {
	private String name;
	
	public Demo02() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo02(String name) {
		super();
		this.name = name;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this);
		}
	}
	public void start() {
		run();
	}

	public static void main(String[] args) {
		Demo02 demo021 = new Demo02("李昊哲");
		Demo02 demo022 = new Demo02("马什么梅");
		demo021.start();
		demo022.start();
	}

}
