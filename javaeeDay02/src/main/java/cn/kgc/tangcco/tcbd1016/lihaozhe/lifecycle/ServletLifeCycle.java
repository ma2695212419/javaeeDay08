package cn.kgc.tangcco.tcbd1016.lihaozhe.lifecycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycle extends HttpServlet{
	private static final long serialVersionUID = 3734222592844102805L;
	private static int count;

	public ServletLifeCycle() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count++;
		System.out.println("来了老弟" + count);
	}

	@Override
	public void destroy() {
		System.out.println("轻轻的我走了，不带走一片云彩");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("轻轻的我来了");
	}
	

}
