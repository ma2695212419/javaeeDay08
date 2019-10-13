package cn.kgc.tangcco.tcbd1016.lihaozhe.front.service;

import java.util.Map;

import org.junit.Test;

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
}
