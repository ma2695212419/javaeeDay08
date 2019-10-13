package cn.kgc.tangcco.tcbd1016.lihaozhe.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Context
 */
@WebServlet("/context.action")
public class Context extends HttpServlet {
       
	private static final long serialVersionUID = 4566084673974235339L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Context() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		// 获取的真实路径
		String realPath = context.getRealPath("/");
		System.out.println(realPath);
		String contextPath = context.getContextPath();
		System.out.println(contextPath);
	}

}
