package cn.kgc.tangcco.tcbd1016.liahozhe.sync_thread;

public class SaleTicket03 extends Thread {
	private static int ticket = 50;

	@Override
	public void run() {
		while (ticket > 0) {
			// 同步代码块
			synchronized (SaleTicket03.class) {
				if (ticket == 0) {
					return;
				}
				System.out.println(Thread.currentThread().getName() + "售出了第" + ticket + "号票");
				ticket--;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		SaleTicket03 saleTicket01 = new SaleTicket03();
		saleTicket01.setName("窗口01");
		SaleTicket03 saleTicket02 = new SaleTicket03();
		saleTicket02.setName("窗口02");
		SaleTicket03 saleTicket03 = new SaleTicket03();
		saleTicket03.setName("窗口03");
		saleTicket01.start();
		saleTicket02.start();
		saleTicket03.start();
	}

}
