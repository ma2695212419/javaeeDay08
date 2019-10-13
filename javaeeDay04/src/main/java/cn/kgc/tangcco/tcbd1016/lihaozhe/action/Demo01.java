package cn.kgc.tangcco.tcbd1016.lihaozhe.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.servlet.BaseServlet;
@WebServlet(urlPatterns = "/demo01.action")
public class Demo01 extends BaseServlet{
	private static final long serialVersionUID = 5051148512663946163L;
	public void haha(HttpServletRequest request ,HttpServletResponse response)  {
		System.out.println("二十四笑头一笑，仰天长笑");
	}
}
