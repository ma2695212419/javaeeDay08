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
@WebServlet("/innerforword.action")
public class InnerForword extends HttpServlet {
	private static final long serialVersionUID = -7052334262406491958L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InnerForword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("innerforword");
		request.getRequestDispatcher("/inner.jsp").forward(request, response);
		return;
	}

}
