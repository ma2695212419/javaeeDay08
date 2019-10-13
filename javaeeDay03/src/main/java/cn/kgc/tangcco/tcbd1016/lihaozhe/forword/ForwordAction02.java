package cn.kgc.tangcco.tcbd1016.lihaozhe.forword;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwordAction01
 */
@WebServlet(urlPatterns = "/forword02.action")
public class ForwordAction02 extends HttpServlet {
       
	private static final long serialVersionUID = 4607384638200249078L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ForwordAction02() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("我是forword02.action");
		// 请求转发页面跳转
		request.getRequestDispatcher("/forword03.action").forward(request, response);
	}

}
