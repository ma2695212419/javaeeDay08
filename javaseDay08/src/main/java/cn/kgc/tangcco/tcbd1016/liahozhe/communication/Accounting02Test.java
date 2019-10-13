package cn.kgc.tangcco.tcbd1016.liahozhe.communication;

public class Accounting02Test {
	public static void main(String[] args) {
		Thread.currentThread().setName("经理");
		String managerName = Thread.currentThread().getName();
		System.out.println(managerName + "开始工作了...");
		Accounting02 accounting01 = new Accounting02();
		accounting01.setName("小丽");
		System.out.println(managerName + "问：你能把1 + 2 + 3 + ... + 50的结果给我吗");
		System.out.println(accounting01.getName() + "答：OK");
		accounting01.start();
		try {
			accounting01.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int toale = accounting01.getToale();
		System.out.println("结果是>>>" + toale);
	}
}
