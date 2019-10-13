package cn.kgc.tangcco.lihaozhe.echarts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class Diagram
 */
@WebServlet(urlPatterns = "/diagram")
public class Diagram extends HttpServlet {
	
	private static final long serialVersionUID = -1863824950796407562L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Diagram() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, List> map = new HashMap<String, List>();
		List<String> categories = new ArrayList<String>() {{
			add("星期一");
			add("星期二");
			add("星期三");
			add("星期四");
			add("星期五");
			add("星期六");
			add("星期日");
		}};
		List<Integer> data = new ArrayList<Integer>() {{
			add(820);
			add(932);
			add(901);
			add(934);
			add(1290);
			add(1330);
			add(1320);
		}};
		map.put("categories", categories);
		map.put("data", data);
		String jsonString = JSON.toJSONString(map);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(jsonString);
		writer.flush();
		writer.close();
	}

}
