package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

import lombok.Data;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午9:40:19
 */
@Data
public class Demo08 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		// 线程新建
		Demo08 demo081 = new Demo08();
		Demo08 demo082 = new Demo08();
		// 线程就绪
		demo081.start();
		demo082.start();
		// 线程执行之后被销毁无法再次被调用
		demo081.start();
	}

}
