package cn.kgc.tangcco.tcbd1016.lihaozhe.thread;

import cn.kgc.tangcco.tcbd1016.lihaozhe.common.LocalDateTimeUtil;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月22日 上午8:36:32
 */
public class Demo01 {
	public static void main(String[] args) {
		try {
			printTime();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void printTime() throws InterruptedException {
		while (true) {
			System.out.println(LocalDateTimeUtil.getStringByCurrentLocalDateTime());
			Thread.sleep(1000);
		}
	}
}
