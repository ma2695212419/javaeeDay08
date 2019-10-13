package cn.kgc.tangcco.tcbd1016.liahozhe.communication;

public class Accounting02 extends Thread {
	private int total;

	@Override
	public synchronized void run() {
		String accountingName = this.getName();
		for (int i = 0; i <= 100; i++) {
			total += i;
			try {
				Thread.sleep(100);
				System.out.println(total);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("会计:" + accountingName + "已经计算出结果了");
	}

	public int getToale() {
		return total;
	}
}
