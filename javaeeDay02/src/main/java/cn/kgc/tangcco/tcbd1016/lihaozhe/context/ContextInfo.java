package cn.kgc.tangcco.tcbd1016.lihaozhe.context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextInfo
 */
@WebServlet("/contextInfo.action")
public class ContextInfo extends HttpServlet {
       
	private static final long serialVersionUID = -1398838019678212561L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ContextInfo() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		Enumeration<String> names = context.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name + " >>> " + context.getInitParameter(name));
		}
	}

}
