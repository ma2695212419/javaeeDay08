package cn.kgc.tangcco.tcbd1016.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.tcbd1016.action.pojo.Emp;

/**
 * Servlet implementation class ServletDemo03
 */
@WebServlet("/ServletDemo03.action")
public class ServletDemo03 extends HttpServlet {
       
	private static final long serialVersionUID = 9166222489486328856L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo03() {
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		if ("admin".equals(account) && "123456".equals(password)) {
			Emp emp = new Emp(account, password, "phoenix");
			map.put("status", "success");
			map.put("emp", emp);
		}
		PrintWriter writer = response.getWriter();
		String jsonString = JSON.toJSONString(map);
		writer.print(jsonString);
		writer.flush();
		writer.close();
	}
}
