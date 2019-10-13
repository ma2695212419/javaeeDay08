package cn.kgc.tangcco.tcbd1016.lihaozhe.singleton;


public class ServletTest implements Runnable {
	public static void main(String[] args) {
		new Thread(new ServletTest()).start();
		new Thread(new ServletTest()).start();
		new Thread(new ServletTest()).start();
		new Thread(new ServletTest()).start();
		new Thread(new ServletTest()).start();
		new Thread(new ServletTest()).start();
		new Thread(new ServletTest()).start();
	}

	@Override
	public void run() {
		Servlet serv = Servlet.create();
		serv.service();
	}
}
