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
@WebServlet(urlPatterns = "/redirect02.action")
public class RedirectAction02 extends HttpServlet {

	private static final long serialVersionUID = -1029849396618487484L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectAction02() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("我是redirect02.action");
		// 网页重定向跳转页面
		// response.sendRedirect("/javaeeDay03/redirect03.action");
		response.sendRedirect(this.getServletContext().getContextPath() + "/redirect03.action");
		return;
	}

}
