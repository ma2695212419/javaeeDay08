package cn.kgc.tangcco.tcbd1016.lihaozhe.forword;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forword
 */
@WebServlet("/outerforword.action")
public class OuterForword extends HttpServlet {

	private static final long serialVersionUID = -1633453195413867618L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OuterForword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("outerforword");
		request.getRequestDispatcher("http://www.ekgc.cn").forward(request, response);
		return;
	}

}
