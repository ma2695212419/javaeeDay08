package cn.kgc.tangcco.tcbd1016.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo02
 */
@WebServlet(urlPatterns = "/ServletDemo02.action")
public class ServletDemo02 extends HttpServlet {
	private static final long serialVersionUID = -4336738582858901848L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo02() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.println(account);
		System.out.println(password);
	}

}
