package cn.kgc.tangcco.tcbd1016.lihaozhe.forword;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Secret
 */
@WebServlet("/forwordsecret.action")
public class Secret extends HttpServlet {
	private static final long serialVersionUID = 5319834482668026705L;

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
		// 请求转发到WEB-INF目录下的页面
		request.getRequestDispatcher("/WEB-INF/secret.jsp").forward(request, response);
	}

}
