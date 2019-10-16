package cn.kgc.tangcco.tcbd1016.lihaozhe.front.service;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.PageRang;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.md5.MD5Code;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class FrontEmpServiceTest {
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

	@Test
	public void selectEmpByAccountAndPassword() {
		Map<String, Object> map = frontEmpService.loginByAccountAndPassword(new Emp("admin", new MD5Code().getMD5ofStr("123456")));
		switch (map.get("status").toString().trim()) {
		case "success":
			System.out.println(((Emp)map.get("emp")).getNickname());
			break;

		default:
			System.out.println("账号或者密码错误");
			break;
		}
	}
	@Test
	public void queryEmps() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pr", new PageRang(2, 5));
		Map<String, Object> empMap = frontEmpService.queryEmps(map);
		List<Emp> list = (List<Emp>) empMap.get("data");
		ListIterator<Emp> it = list.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	@Test
	public void queryEmpByUuid() {
		Map<String, Object> empMap = frontEmpService.queryEmpByUuid("6349352891511be940b3435a9d932df8edc2c5b612517925");
		switch (empMap.get("status").toString()) {
		case "success":
			System.out.println(empMap.get("emp"));
			break;

		default:
			System.out.println("没有复合条件的查询结果");
			break;
		}
	}
	@Test
	public void queryCountByAccount() {
		
	}
}
