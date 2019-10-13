package cn.kfgc.tangcco.lihaozhe.action;

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

import cn.kfgc.tangcco.lihaozhe.action.pojo.Point;

/**
 * Servlet implementation class KgcMapACtion
 */
@WebServlet(urlPatterns = "/kgcMap.action")
public class KgcMapAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KgcMapAction() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(116.426745, 39.785977));
		list.add(new Point(116.468357, 39.880442));
		list.add(new Point(116.325061, 39.998907));
		list.add(new Point(116.578825, 39.919159));
		PrintWriter writer = response.getWriter();
		writer.print(JSON.toJSONString(list));
		writer.flush();
		writer.close();
	}

}
