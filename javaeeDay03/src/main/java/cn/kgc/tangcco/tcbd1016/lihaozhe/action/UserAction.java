package cn.kgc.tangcco.tcbd1016.lihaozhe.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class UserAction
 */
@WebServlet("/user.action")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 8316520242466428534L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAction() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("user.action被访问了");
		optional(request, response);
		return;
	}

	private void optional(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getParameter("methodName")) {
		case "login":
			login(request, response);
			break;

		default:
			break;
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account").toString().trim();
		String password = request.getParameter("password").toString().trim();
		if (!StringUtils.isEmpty(account) && !StringUtils.isEmpty(password)) {
			if ("admin".equals(account) && "123456".equals(password)) {
				request.getRequestDispatcher("/loginSuccess.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/loginFailed.jsp").forward(request, response);
			}
		}
	}

}
