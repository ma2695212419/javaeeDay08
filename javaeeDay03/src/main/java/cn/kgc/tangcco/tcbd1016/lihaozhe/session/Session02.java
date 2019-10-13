package cn.kgc.tangcco.tcbd1016.lihaozhe.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwordAction01
 */
@WebServlet(urlPatterns = "/session02.action")
public class Session02 extends HttpServlet {

	private static final long serialVersionUID = -341835658463192619L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Session02() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("我是session02.action");
		System.out.println("我是session02.action 获取到的sessionid >>> " + request.getSession().getId());
		// 网页重定向跳转页面
		response.sendRedirect(this.getServletContext().getContextPath() + "/session03.action");
		return;
	}

}
