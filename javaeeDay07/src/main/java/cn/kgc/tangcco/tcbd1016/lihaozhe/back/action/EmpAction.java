package cn.kgc.tangcco.tcbd1016.lihaozhe.back.action;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import cn.kgc.tangcco.tcbd1016.lihaozhe.back.service.BackEmpService;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.date.BaseDateUitls;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.uuid.BaseUUID;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;
@WebServlet(urlPatterns = "/back/emp.action")
public class EmpAction extends BaseServlet{
	private static BackEmpService backEmpService;
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"spring/ApplicationContext-service.xml");
	static {
		try {
			backEmpService = (BackEmpService) context.getBean(BackEmpService.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据员工uuid删除员工
	 * @param request	HttpServletRequest
	 * @param response	HttpServletResponse
	 */
	public void removeEmpByUuid(HttpServletRequest request, HttpServletResponse response) {
		// 从页面获取uuid
		String uuid = request.getParameter("uuid");
		// 调用接口中的方法
		Map<String, Object> map = backEmpService.removeEmpByUuid(uuid);
		switch (map.get("status").toString()) {
		case "success":
			forword(request, response, "/front/emp.action?methodName=queryEmps");
			break;

		default:
			forword(request, response, "/front/emp.action?methodName=queryEmps");
			break;
		}
	}
	/**
	 * 新增员工
	 * @param request	HttpServletRequest
	 * @param response	HttpServletResponse
	 */
	public void addEmp(HttpServletRequest request, HttpServletResponse response) {
		String nickname = request.getParameter("nickname");
		String account = request.getParameter("account");
		String birthday = request.getParameter("birthday");
		int gender = Integer.parseInt(request.getParameter("gender"));
		int did = Integer.parseInt(request.getParameter("did"));
		int powernum = (!StringUtils.isEmpty(request.getParameter("powernum")))?Integer.parseInt(request.getParameter("powernum")) : 2;
		Emp emp;
		try {
			emp = new Emp(nickname, account, BaseDateUitls.parse(birthday, "yyyy-MM-dd"), gender, powernum, BaseUUID.generate().toString(), did);
			Map<String, Object> map = backEmpService.saveEmp(emp);
			switch (map.get("status").toString()) {
			case "success":
				request.setAttribute("msg", "成功");
				forword(request, response, "/front/emp.action?methodName=addEmp");
				break;

			default:
				request.setAttribute("msg", "失败");
				forword(request, response, "/front/emp.action?methodName=addEmp");
				break;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
