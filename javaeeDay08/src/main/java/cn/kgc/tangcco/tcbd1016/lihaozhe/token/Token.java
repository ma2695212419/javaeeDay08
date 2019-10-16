package cn.kgc.tangcco.tcbd1016.lihaozhe.token;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.servlet.BaseServlet;


/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年7月22日 上午10:11:07 <br>
 *          类说明:
 */
@WebServlet(urlPatterns = "/token.action")
public class Token extends BaseServlet {
	private static final long serialVersionUID = 8780436736062216776L;

	private void token01(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("username"));
	}
}
