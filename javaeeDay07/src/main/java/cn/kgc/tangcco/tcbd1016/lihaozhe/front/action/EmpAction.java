package cn.kgc.tangcco.tcbd1016.lihaozhe.front.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.PageRang;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.md5.MD5Code;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.front.service.FrontDeptService;
import cn.kgc.tangcco.tcbd1016.lihaozhe.front.service.FrontEmpService;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

@WebServlet(urlPatterns = "/front/emp.action")
public class EmpAction extends BaseServlet {
	private static FrontEmpService frontEmpService;
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"spring/ApplicationContext-service.xml");
	private static FrontDeptService frontDeptService = null;
	static {
		try {
			frontEmpService = (FrontEmpService) context.getBean(FrontEmpService.class.getSimpleName());
			frontDeptService = (FrontDeptService) context.getBean(FrontDeptService.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static final long serialVersionUID = -6337616634004146135L;

	/**
	 * 员工登录
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String account = null;
		String password = null;
		if (StringUtils.isEmpty(request.getParameter("account"))) {
			request.setAttribute("status", "账号不能为空");
			forword(request, response, subfix("/login"));
			return;
		} else if (StringUtils.isEmpty(request.getParameter("password"))) {
			request.setAttribute("status", "密码不能为空");
			forword(request, response, subfix("/login"));
			return;
		}
		account = request.getParameter("account");
		password = request.getParameter("password");
		
		Map<String, Object> map = frontEmpService
				.loginByAccountAndPassword(new Emp(account, new MD5Code().getMD5ofStr(password)));
		switch (map.get("status").toString().trim()) {
		case "success":
			System.out.println(((Emp) map.get("emp")).getNickname());
			// 将操作者对象存储在session域中
			request.getSession().setAttribute("operator", (Emp) map.get("emp"));
			// 调用查询员工简略信息方法返回查询结果并存储在requeset域中
			queryEmps(request, response);
			// 跳转页面
			// forword(request, response, subfix("/main"));
			break;

		default:
			System.out.println("账号或者密码错误");
			// 将登录信息存储在request域中
			request.setAttribute("status", "账号或者密码错误");
			forword(request, response, subfix("/login"));
			break;
		}
	}

	/**
	 * 退出系统
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		// 清空session域中的值
		request.getSession().invalidate();
		redirect(request, response, subfix(request.getServletContext().getContextPath() + "/index"));
	}

	/**
	 * 查询员工简略信息
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 */
	public void queryEmps(HttpServletRequest request, HttpServletResponse response) {
		// 存储查询条件
		Map<String, Object> map = new HashMap<String, Object>();
		// 存储分页数据
		map.put("pr", new PageRang(2, 5));
		// 返回查询结果
		Map<String, Object> empMap = frontEmpService.queryEmps(map);
		// 将查询结果存储到request域中
		request.setAttribute("empMap", empMap);
		// 跳转页面
		forword(request, response, subfix("/main"));
	}

	/**
	 * 查询员工详细信息
	 * 
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 */
	public void queryEmpByUuid(HttpServletRequest request, HttpServletResponse response) {
		String uuid = request.getParameter("uuid");
		// 返回查询结果
		Map<String, Object> map = frontEmpService.queryEmpByUuid(uuid);
		switch (map.get("status").toString()) {
		case "success":
			// 将查询结果存储到request域中
			request.setAttribute("emp", map.get("emp"));
			// 跳转页面
			forword(request, response, subfix("/empinfo"));
			break;

		default:
			break;
		}
	}
	/**
	 * 按条件查询员工
	 * 
	 * @param request  请求
	 * @param response 响应
	 */
	private void addEmp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> deptMap = frontDeptService.queryDepts(new HashMap<String, Object>());
//		// 创建令牌
//		String token = request.getSession().getId() + TokenProccessor.getInstance().makeToken();
//		// 输出令牌
//		System.out.println("原始token >>> " + token);
//		// 在服务器使用session保存token(令牌)
//		request.getSession().setAttribute("tokenAdd", token);
		request.setAttribute("deptMap", deptMap);
		forword(request, response, subfix("/add"));
	}
	/**
	 * 判断账号是否存在
	 * 
	 * @param request  请求
	 * @param response 响应
	 */
	public void checkAccount(HttpServletRequest request, HttpServletResponse response) {
		String account = request.getParameter("account");
		printJson(request, response, frontEmpService.queryCountByAccount(account));
	}
}
