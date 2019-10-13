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
 * Servlet implementation class Columnar
 */
@WebServlet(urlPatterns = "/columnar")
public class Columnar extends HttpServlet {
	
	private static final long serialVersionUID = -663803038353495266L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Columnar() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, List> map = new HashMap<String, List>();
		List<String> categories = new ArrayList<String>() {{
			add("衬衫");
			add("羊毛衫");
			add("雪纺衫");
			add("裤子");
			add("高跟鞋");
			add("袜子");
		}};
		List<Integer> data = new ArrayList<Integer>() {{
			add(5);
			add(20);
			add(36);
			add(10);
			add(10);
			add(20);
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
