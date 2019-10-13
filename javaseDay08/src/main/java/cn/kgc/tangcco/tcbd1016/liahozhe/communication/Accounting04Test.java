package cn.kgc.tangcco.tcbd1016.liahozhe.communication;

public class Accounting04Test {
	private static int NUM_OF_THREAD = 10;
	static Thread[] threads = new Thread[NUM_OF_THREAD];

	public static void main(String[] args) {
		final Accounting04 acc = new Accounting04("John", 1000.0f);
		for (int i = 0; i < NUM_OF_THREAD; i++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					acc.deposit(100.0f);
					System.out.println(Thread.currentThread().getName() + "\t存完钱余额：" + acc.getBalance());
					acc.withdraw(10.0f);
					System.out.println(Thread.currentThread().getName() + "\t取完钱余额：" + acc.getBalance());
				}
			});
			threads[i].start();
		}

		for (int i = 0; i < NUM_OF_THREAD; i++) {
			try {
				threads[i].join(); // 等待所有线程运行结束
			} catch (InterruptedException e) {
				// ignore
			}
		}
		System.out.println("最后, John's balance is:" + acc.getBalance());
	}
}
