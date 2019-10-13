package cn.kgc.tangcco.tcbd1016.lihaozhe.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Secret
 */
@WebServlet("/redirectsecret.action")
public class Secret extends HttpServlet {

	private static final long serialVersionUID = 2721090781721652230L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Secret() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 网页重定向到WEB-INF目录下的页面
		response.sendRedirect("/javaeeDay03/WEB-INF/secret.jsp");
	}

}
