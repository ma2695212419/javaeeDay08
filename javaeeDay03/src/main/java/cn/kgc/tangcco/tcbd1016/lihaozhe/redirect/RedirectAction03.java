package cn.kgc.tangcco.tcbd1016.lihaozhe.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwordAction01
 */
@WebServlet(urlPatterns = "/redirect03.action")
public class RedirectAction03 extends HttpServlet {

	private static final long serialVersionUID = -3963135097531260461L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectAction03() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("我是redirect03.action");
		// 从request域中获取的值
		String value = (String) request.getAttribute("redirect01");
		System.out.println("request域中获取的值 >>> " + value);
	}

}
