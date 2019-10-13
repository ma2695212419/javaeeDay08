package cn.kgc.tangcco.tcbd1016.commons.service;

import java.util.Map;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.commons.pojo.Emp;
import cn.kgc.tangcco.tcbd1016.commons.service.impl.EmpServiceImpl;

public class EmpServiceTest {
	EmpService empService = new EmpServiceImpl();
	@Test
	public void updateEmp() {
		Map<String, Object> map = empService.updateEmp(new Emp("1076f6aec30803e35de4ab0bacc09da7d54f861402c088", "李昊哲"));
		switch (map.get("status").toString()) {
		case "success":
			System.out.println("修改成功");
			break;
		case "failed":
			System.out.println("修改失败");
			break;

		default:
			break;
		}
	}
}
