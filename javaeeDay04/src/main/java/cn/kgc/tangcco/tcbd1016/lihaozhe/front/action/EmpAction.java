package cn.kgc.tangcco.tcbd1016.lihaozhe.front.action;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.md5.MD5Code;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.front.service.FrontEmpService;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;
@WebServlet(urlPatterns = "/front/emp.action")
public class EmpAction extends BaseServlet{
	private static FrontEmpService frontEmpService;
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"spring/ApplicationContext-service.xml");
	static {
		try {
			frontEmpService = (FrontEmpService) context.getBean(FrontEmpService.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static final long serialVersionUID = -6337616634004146135L;
	public void login(HttpServletRequest request,HttpServletResponse response) {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		Map<String, Object> map = frontEmpService.loginByAccountAndPassword(new Emp(account, new MD5Code().getMD5ofStr(password)));
		switch (map.get("status").toString().trim()) {
		case "success":
			System.out.println(((Emp)map.get("emp")).getNickname());
			// 将操作者对象存储在session域中
			request.getSession().setAttribute("operator", (Emp)map.get("emp"));
			forword(request, response, subfix("/main"));
			break;

		default:
			System.out.println("账号或者密码错误");
			// 将登录信息存储在request域中
			request.setAttribute("status", "账号或者密码错误");
			forword(request, response, subfix("/login"));
			break;
		}
	}
	public void logout(HttpServletRequest request,HttpServletResponse response) {
		// 清空session域中的值
		request.getSession().invalidate();
		redirect(request, response, subfix(request.getServletContext().getContextPath() + "/index"));
	}
}
