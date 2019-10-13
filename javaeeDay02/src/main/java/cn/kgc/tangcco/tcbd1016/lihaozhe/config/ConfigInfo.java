package cn.kgc.tangcco.tcbd1016.lihaozhe.config;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigInfo
 */
public class ConfigInfo extends HttpServlet {
       
	private static final long serialVersionUID = -5521446446248044768L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig conf = this.getServletConfig();
		String slogan = conf.getInitParameter("slogan");
		System.out.println(slogan);
	}

}
