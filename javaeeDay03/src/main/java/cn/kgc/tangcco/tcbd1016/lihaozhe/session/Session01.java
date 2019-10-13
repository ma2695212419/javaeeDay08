package cn.kgc.tangcco.tcbd1016.lihaozhe.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForwordAction01
 */
@WebServlet(urlPatterns = "/session01.action")
public class Session01 extends HttpServlet {

	private static final long serialVersionUID = 4705999213234051427L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Session01() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取HttpSession对象
		HttpSession session = request.getSession();
		// 向session域中存储数据 与当前session绑定
		session.setAttribute("session01", "session01");
		System.out.println("我是session01.action");
		System.out.println("我是session01.action 获取到的sessionid >>> " + session.getId());
		// 网页重定向跳转页面
		response.sendRedirect(this.getServletContext().getContextPath() + "/session02.action");
		return;
	}

}
