package cn.kgc.tangcco.tcbd1016.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo01
 */
@WebServlet(urlPatterns = "/ServletDemo01.action")
public class ServletDemo01 extends HttpServlet {
       
	private static final long serialVersionUID = 6719819160544436357L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo01() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("每时每课给你薪机会");
	}

}
