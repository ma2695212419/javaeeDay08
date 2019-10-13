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
@WebServlet(urlPatterns = "/session03.action")
public class Session03 extends HttpServlet {

	private static final long serialVersionUID = 9195551415856646061L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Session03() {
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
		String value = (String) session.getAttribute("session01");
		System.out.println("我是session03.action");
		System.out.println("我是session03.action 获取到的sessionid >>> " + session.getId());
		System.out.println("session域中获取的值 >>> " + value);
	}

}
