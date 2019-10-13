package cn.kgc.tangcco.tcbd1016.lihaozhe.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class Emp
 */
@WebServlet(urlPatterns = "/emp.action")
public class EmpAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpAction() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 请请求域中获取实体内容
		String methodName = request.getParameter("methodName");
		if (!StringUtils.isEmpty(methodName)) {
			optional(request, response, methodName);
		} else {
			System.out.println("请求参数错误");
		}
	}
    /**
     * 方法映射器
     * @param request		客户端请求
     * @param response		服务端响应
     * @param methodName
     */
	private void optional(HttpServletRequest request, HttpServletResponse response, String methodName) {
		switch (methodName) {
		case "login":
			login(request,response);
			break;

		default:
			break;
		}

	}
	/**
     * 登录方法
     * @param request		客户端请求
     * @param response		服务端响应
     */
	private void login(HttpServletRequest request, HttpServletResponse response) {
		String account = request.getParameter("account").trim();
		String password = request.getParameter("password").trim();
		if ("admin".equals(account) && "123456".equals(password)) {
			System.out.println("恭喜登录成功");
		}else {
			System.out.println("账号或者密码错误");
		}
	}
}
