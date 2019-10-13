package cn.kgc.tangcco.tcbd1016.lihaozhe.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InnerRedirect
 */
@WebServlet("/outerRedirect.action")
public class OuterRedirect extends HttpServlet {

	private static final long serialVersionUID = 6491628255633740328L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OuterRedirect() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("outerRedirect");
		response.sendRedirect("http://www.ekgc.cn");
		return;
	}

}
