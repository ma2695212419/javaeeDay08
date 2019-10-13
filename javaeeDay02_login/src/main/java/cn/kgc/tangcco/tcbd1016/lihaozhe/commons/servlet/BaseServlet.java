package cn.kgc.tangcco.tcbd1016.lihaozhe.commons.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public abstract class BaseServlet {
	private static PrintWriter writer;
	public static void printJson(Object object,HttpServletResponse response) throws IOException {
		// 解决中文乱码
		response.setContentType("text/html;charset=utf-8");
		writer = response.getWriter();
		writer.print(JSON.toJSONString(object));
		writer.flush();
		writer.close();
	}
}
