package cn.kgc.tangcco.tcbd1016.lihaozhe.forword;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwordAction01
 */
@WebServlet(urlPatterns = "/forword03.action")
public class ForwordAction03 extends HttpServlet {

	private static final long serialVersionUID = 9076176277145823019L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForwordAction03() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("我是forword03.action");
		// 从request域中获取的值
		String value = (String) request.getAttribute("forword01");
		System.out.println("request域中获取的值 >>> " + value);
	}

}
