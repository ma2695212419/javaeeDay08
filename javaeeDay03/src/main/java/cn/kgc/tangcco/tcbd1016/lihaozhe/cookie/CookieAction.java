package cn.kgc.tangcco.tcbd1016.lihaozhe.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.localdatetime.LocalDateTimeUtil;

/**
 * Servlet implementation class Cookie
 */
@WebServlet("/cookie.action")
public class CookieAction extends HttpServlet {

	private static final long serialVersionUID = 7296838969829893462L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieAction() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @throws ServletException
	 */
	private void optional(HttpServletRequest request, HttpServletResponse response, String methodName)
			throws IOException, ServletException {
		switch (methodName) {
		case "writeCookie":
			writeCookie(request, response);
			break;
		case "readCookie":
			readCookie(request, response);
			break;

		default:
			break;
		}

	}

	private void readCookie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cookie = request.getHeader("cookie");
		// URLEncode和URLDecode用于完成普通字符串和 application/x-www-from-urlencoded
		// MIME字符串之间的相互转化
		// 如果传递的字符串中包含非西欧字符的字符串，会被转化成%XX%XX XX为十六进制的数字
		System.out.println(URLDecoder.decode(cookie, "utf-8"));
		// 获取Cookie集合
		Cookie[] cookies = request.getCookies();

		// 遍历集合中的Cookie对象
		if (cookies == null || cookies.length == 0)
			System.out.println("未获取到任何Cookie对象");
		else {
			for (int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName() + "=" + URLDecoder.decode(cookies[i].getValue(), "utf-8"));
			}
		}
		// 跳回去
		request.getRequestDispatcher("/cookieRequest.jsp").forward(request, response);
		return;
	}

	private void writeCookie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理中文乱码
		// 处理post请求的中文乱码
		request.setCharacterEncoding("utf-8");
		// 处理响应的字符集中文乱码
		response.setCharacterEncoding("utf-8");
		// 处理浏览器字符集中文乱码
		response.setContentType("text/html;charset=utf-8");
		// Cookie为key-value结构
		// 1、服务器创建Cookie
		// URLEncode和URLDecode用于完成普通字符串和 application/x-www-from-urlencoded
		// MIME字符串之间的相互转化
		// 如果传递的字符串中包含非西欧字符的字符串，会被转化成%XX%XX XX为十六进制的数字
		Cookie c1 = new Cookie("c1", URLEncoder.encode(LocalDateTimeUtil.getStringByCurrentLocalDateTime(), "utf-8"));
		Cookie c2 = new Cookie("c2", URLEncoder.encode(LocalDateTimeUtil.getStringByCurrentLocalDateTime(), "utf-8"));
		Cookie c3 = new Cookie("c3", URLEncoder.encode(LocalDateTimeUtil.getStringByCurrentLocalDateTime(), "utf-8"));
		Cookie c4 = new Cookie("c4", URLEncoder.encode(LocalDateTimeUtil.getStringByCurrentLocalDateTime(), "utf-8"));
		// 2、设置Cookie过期时间
		/*
		 * 正整数：表示cookie数据保存浏览器的缓存目录（硬盘中），数值表示保存的时间。
		 * 负整数：表示cookie数据保存浏览器的内存中。浏览器关闭cookie就丢失了！！ 零：表示删除同名的cookie数据
		 */
		// 设置的方式：秒 * 分 * 时 * 天
		c2.setMaxAge(60 * 60 * 24 * 30);
		c4.setMaxAge(60 * 60);
		// 表示立即过期，浏览器关闭后立即过期（默认）
		c3.setMaxAge(-1);
		// 3、设置访问路径
		// 设置cookie的有效路径。默认情况：有效路径在当前web应用下。
		c4.setPath(this.getServletContext().getContextPath() + "/hero/shop/car");
		// 4、发送给客户端
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		response.addCookie(c4);
		// 跳回去
		request.getRequestDispatcher("/cookieRequest.jsp").forward(request, response);
		return;
	}

}
