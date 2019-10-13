package cn.kgc.tangcco.tcbd1016.liahozhe.thread;

public class Demo01 extends Thread{

	public static void main(String[] args) {
		Demo01 demo01 = new Demo01();
		demo01.start();
		for (int i = 0; i < 30; i++) {
			System.out.println(Thread.currentThread().getName() + "\t" + i);
			if (i == 10) {
				try {
					demo01.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println(Thread.currentThread().getName() + "\t" + i);
		}
	}
	

}
