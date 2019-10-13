package cn.kgc.tangcco.tcbd1016.liahozhe.runnable;

public class Demo03 {
	public static void main(String[] args) {
		Demo03.run();
		Demo03.run();
		Demo03.run();
	}

	public static void run() {
		Thread thread01 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + ">>>" + i);
				}
			}
		});
		thread01.start();
	}
}
