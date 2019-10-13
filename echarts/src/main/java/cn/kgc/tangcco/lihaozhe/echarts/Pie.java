package cn.kgc.tangcco.lihaozhe.echarts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.lihaozhe.pojo.Percent;

/**
 * Servlet implementation class Pie
 */
@WebServlet(urlPatterns = "/pie")
public class Pie extends HttpServlet {
	

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Pie() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Percent> list = new ArrayList<Percent>() {{
			add(new Percent(235, "视频广告"));
			add(new Percent(274, "联盟广告"));
			add(new Percent(310, "邮件营销"));
			add(new Percent(335, "直接访问"));
			add(new Percent(400, "搜索引擎"));
		}};
		String jsonString = JSON.toJSONString(list);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(jsonString);
		writer.flush();
		writer.close();
	}

}
