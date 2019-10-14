package cn.kgc.tangcco.tcbd1016.lihaozhe.front.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Dept;

public class FrontDeptServiceTest {
	private static FrontDeptService frontDeptService;
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"spring/ApplicationContext-service.xml");
	static {
		try {
			frontDeptService = (FrontDeptService) context.getBean(FrontDeptService.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void queryDepts() {
		Map<String, Object> map = frontDeptService.queryDepts(null);
		List<Dept> list = (List<Dept>) map.get("data");
		for (Dept dept : list) {
			System.out.println(dept);
		}
	}
}
