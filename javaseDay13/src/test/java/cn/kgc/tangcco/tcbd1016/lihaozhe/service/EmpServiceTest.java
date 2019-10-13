package cn.kgc.tangcco.tcbd1016.lihaozhe.service;

import java.util.Map;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.impl.EmpServiceImpl;

public class EmpServiceTest {
	EmpService empService = new EmpServiceImpl();
	@Test
	public void empLoginByAccountAndPassword() {
		Map<String, Object> map = empService.empLoginByAccountAndPassword(null);
		switch (map.get("status").toString()) {
		case "success":
			System.out.println("操作者>>>" + ((Emp)map.get("emp")).getNickname());
			break;
		case "failed":
			System.out.println("账号或者密码错误");
			break;

		default:
			break;
		}
	}
}
