package cn.kgc.tangcco.tcbd1016.liahozhe.runnable;

public class Demo02 {
	public static void main(String[] args) {
		new Demo02().run();
		new Demo02().run();
		new Demo02().run();
	}

	public void run() {
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
