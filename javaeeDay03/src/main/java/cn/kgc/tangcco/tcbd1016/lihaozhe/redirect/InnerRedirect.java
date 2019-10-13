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
@WebServlet("/innerRedirect.action")
public class InnerRedirect extends HttpServlet {
       
	private static final long serialVersionUID = 8009674728105234389L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public InnerRedirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("innerRedirect");
		response.sendRedirect("/javaeeDay03/inner.jsp");
		return;
	}

}
