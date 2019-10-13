package cn.kgc.tangcco.tcbd1016.liahozhe.sync_runnable;

public class SaleTicket06 implements Runnable {
	private int ticket = 50;

	@Override
	public void run() {
		while (ticket > 0) {
			print();
		}
	}
	// 该类只被实例化了一次 所以只用当前对象作为锁即可
	private synchronized void print() {
		if (ticket == 0) {
			return;
		}
		System.out.println(Thread.currentThread().getName() + "售出了第" + ticket + "号票");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ticket--;
	}

	public static void main(String[] args) {
		SaleTicket06 saleTicket01 = new SaleTicket06();
		Thread thread01 = new Thread(saleTicket01);
		Thread thread02 = new Thread(saleTicket01);
		Thread thread03 = new Thread(saleTicket01);
		thread01.setName("窗口01");
		thread02.setName("窗口02");
		thread03.setName("窗口03");
		thread01.start();
		thread02.start();
		thread03.start();
	}

}
