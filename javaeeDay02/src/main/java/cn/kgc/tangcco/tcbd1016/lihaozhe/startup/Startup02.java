package cn.kgc.tangcco.tcbd1016.lihaozhe.startup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月26日 下午2:52:27
 */
public class Startup02 extends HttpServlet {

	@Override
	public void destroy() {
		System.out.println("我是Startup02的destroy方法");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("我是Startup02的init方法");
	}

	private static final long serialVersionUID = -7696101356497433284L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("我是Startup02的service方法");
	}

}
