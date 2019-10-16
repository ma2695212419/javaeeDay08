package cn.kgc.tangcco.tcbd1016.lihaozhe.back.service;

import java.util.Map;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;

public class BackEmpServiceTest {
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
	@Test
	public void removeEmpByUuid() {
		Map<String, Object> map = backEmpService.removeEmpByUuid("6349352891511be940b3435a9d932df8edc2c5b612517925");
		switch (map.get("status").toString()) {
		case "success":
			System.out.println("删除成功");
			break;

		default:
			System.out.println("删除失败");
			break;
		}
	}
}
