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
@WebServlet(urlPatterns = "/forword01.action")
public class ForwordAction01 extends HttpServlet {
       
	private static final long serialVersionUID = 5832089714991143215L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ForwordAction01() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("我是forword01.action");
		// 向request域中存储数据	与request绑定
		request.setAttribute("forword01", "forword01");
		// 请求转发页面跳转
		request.getRequestDispatcher("/forword02.action").forward(request, response);
	}

}
