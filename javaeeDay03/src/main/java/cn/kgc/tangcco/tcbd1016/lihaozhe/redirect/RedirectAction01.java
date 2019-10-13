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
@WebServlet(urlPatterns = "/redirect01.action")
public class RedirectAction01 extends HttpServlet {

	private static final long serialVersionUID = -8803665981214501643L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectAction01() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 向request域中存储数据	与request绑定
		request.setAttribute("redirect01", "redirect01");
		System.out.println("我是redirect01.action");
		// 网页重定向跳转页面
		// response.sendRedirect("/javaeeDay03/redirect02.action");
		response.sendRedirect(this.getServletContext().getContextPath() + "/redirect02.action");
		return;
	}

}
