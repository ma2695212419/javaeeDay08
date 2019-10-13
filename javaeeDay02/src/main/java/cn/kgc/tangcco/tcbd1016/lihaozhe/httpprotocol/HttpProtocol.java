package cn.kgc.tangcco.tcbd1016.lihaozhe.httpprotocol;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpProtocol
 */
@WebServlet(urlPatterns = "/httpProtocol.action")
public class HttpProtocol extends HttpServlet {

	private static final long serialVersionUID = 5964629180843955900L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HttpProtocol() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("methodName");
		optional(methodName, request, response);
	}

	// 适配器方法
	private void optional(String methodName, HttpServletRequest request, HttpServletResponse response) {
		switch (methodName) {
		case "requestLine":
			requestLine(request, response);
			break;
		case "requestHeader":
			requestHeader(request, response);
			break;
		case "getNetwork":
			getNetwork(request, response);
			break;
		case "getContent":
			getContent(request, response);
			break;

		default:
			break;
		}

	}
	
	/**
	 * 获取请求行中的 信息
	 * http://192.168.43.66:8080/javaeeDay02/httpProtocol.action?methodName=getRequestLine
	 * 
	 * @param request httpRequests
	 */
	private void requestLine(HttpServletRequest request, HttpServletResponse response) {
		// 获取请求方式
		System.out.println("请求方式：" + request.getMethod());
	
		// 获取路径(URL、URI)
		System.out.println("请求的URL：" + request.getRequestURL());
		System.out.println("请求的URI：" + request.getRequestURI());
		// 协议
		System.out.println("获取的是协议的名称：" + request.getProtocol());
		System.out.println("获取的是使用的协议：" + request.getScheme());
		// 获取查询字符串（基本不用）
		System.out.println("请求的查询字符串：" + request.getQueryString());
	
		// 上下文路径
		System.out.println("请求的上下文路径" + request.getContextPath());
	}
	
	/**
	 * 获取请求头中的 信息
	 * http://192.168.43.66:8080/javaeeDay02/httpProtocol.action?methodName=getRequestHeader
	 * 
	 * @param request httpRequests
	 */
	private void requestHeader(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("connection:" + request.getHeader("connection"));
		System.out.println("User-Agent:" + request.getHeader("User-Agent"));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		// 定义枚举对象Qure
		Enumeration<String> names = request.getHeaderNames();
		// hasMoreElements() —— 返回是否包含元素
		String name = null;
		while (names.hasMoreElements()) {
			// nextElement() —— 返回下一个元素项
			name = names.nextElement();
			System.out.println(name + ":" + request.getHeader(name));
		}
	}
	/**
	 * 获取网络信息
	 * http://192.168.43.66:8080/javaeeDay02/httpProtocol.action?methodName=getNetwork
	 * 
	 * @param request request httpRequests
	 */
	private void getNetwork(HttpServletRequest request, HttpServletResponse response) {
		// 客户端(远程机器)
		System.out.println("客户IP地址：" + request.getRemoteHost());
		System.out.println("客户端口：" + request.getRemotePort());

		// 服务器端（本地机器）
		System.out.println("服务器IP地址：" + request.getLocalAddr());
		System.out.println("服务器端口：" + request.getLocalPort());
		System.out.println("----------------------------------------------------");

	}
	/**
	 * 获取请求中的实体内容信息
	 * http://192.168.43.66:8080/javaeeDay02/httpProtocol.action?methodName=getContent
	 * @param request	request httpRequests
	 */
	private void getContent(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("nickname:" + request.getParameter("nickname"));
		System.out.println("account:" + request.getParameter("account"));
		System.out.println("password:" + request.getParameter("password"));
		System.out.println("gender:" + request.getParameter("gender"));
		// System.out.println("hobby:" + request.getParameter("hobby"));

		// getParameterValues() ：返回参数的一组值（返回值为字符串数组）
		String[] hobbys = request.getParameterValues("hobby");
		System.out.print("hobby:");
		for (int i = 0; i < hobbys.length; i++) {
			System.out.print(hobbys[i]);
			if (i < hobbys.length - 1) {
				System.out.print(",");
			}
		}

		// 写入到数据库
		// 。。。。。。
	}

}
