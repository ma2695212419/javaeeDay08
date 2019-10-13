package cn.kgc.tangcco.tcbd1016.liahozhe.sync_thread;

public class SaleTicket02 extends Thread {
	private static int ticket = 50;

	@Override
	public void run() {
		while (ticket > 0) {
			System.out.println(Thread.currentThread().getName() + "售出了第" + ticket + "号票");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ticket--;
		}
	}

	public static void main(String[] args) {
		SaleTicket02 saleTicket01 = new SaleTicket02();
		saleTicket01.setName("窗口01");
		SaleTicket02 saleTicket02 = new SaleTicket02();
		saleTicket02.setName("窗口02");
		SaleTicket02 saleTicket03 = new SaleTicket02();
		saleTicket03.setName("窗口03");
		saleTicket01.start();
		saleTicket02.start();
		saleTicket03.start();
	}

}
