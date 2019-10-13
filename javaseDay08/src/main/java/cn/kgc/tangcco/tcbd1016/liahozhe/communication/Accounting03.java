package cn.kgc.tangcco.tcbd1016.liahozhe.communication;

public class Accounting03 extends Thread {
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
		this.notify();
	}

	public synchronized int getToale() {
		try {
			System.out.println("经理进入等待状态...");
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
}
