package cn.kgc.tangcco.tcbd1016.liahozhe.runnable;

public class Demo04 {
	public static void main(String[] args) {
		Demo04.run();
		Demo04.run();
		Demo04.run();
	}

	public static void run() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + ">>>" + i);
				}
			}
		}).start();
	}
}
