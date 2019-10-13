package cn.kgc.tangcco.tcbd1016.lihaozhe.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.EmpService;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpAction
 */
@WebServlet("/emp.action")
public class EmpAction extends HttpServlet {

	private static final long serialVersionUID = -8746251770243875746L;
	EmpService empService = new EmpServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpAction() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
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
	 * 
	 * @param request    客户端请求
	 * @param response   服务端响应
	 * @param methodName
	 * @throws IOException 
	 */
	private void optional(HttpServletRequest request, HttpServletResponse response, String methodName) throws IOException {
		switch (methodName) {
		case "login":
			login(request, response);
			break;

		default:
			break;
		}

	}

	/**
	 * 登录方法
	 * 
	 * @param request  客户端请求
	 * @param response 服务端响应
	 * @throws IOException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String account = request.getParameter("account").trim();
		String password = request.getParameter("password").trim();
		Map<String, Object> map = empService.loginByAccountAndPassword(new Emp(account, password));
		BaseServlet.printJson(map, response);
	}

}
