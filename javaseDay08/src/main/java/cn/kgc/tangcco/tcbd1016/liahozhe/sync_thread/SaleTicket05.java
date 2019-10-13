package cn.kgc.tangcco.tcbd1016.liahozhe.sync_thread;

public class SaleTicket05 extends Thread {
	private static int ticket = 50;

	@Override
	public void run() {
		print();
	}
	//默认的锁：当前类本身：SaleTicket05.class，是唯一的
	private static synchronized void print() {
		while (ticket > 0) {
			// 同步代码块
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

	public static void main(String[] args) {
		SaleTicket05 saleTicket01 = new SaleTicket05();
		saleTicket01.setName("窗口01");
		SaleTicket05 saleTicket02 = new SaleTicket05();
		saleTicket02.setName("窗口02");
		SaleTicket05 saleTicket03 = new SaleTicket05();
		saleTicket03.setName("窗口03");
		saleTicket01.start();
		saleTicket02.start();
		saleTicket03.start();
	}

}
