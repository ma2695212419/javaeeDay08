package cn.kgc.tangcco.tcbd1016.lihaozhe.action;

import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.common.SingleFactory;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.EmpService;

public class EmpAction {
	// EmpService empService = new EmpServiceImpl();
	EmpService empService = (EmpService) SingleFactory.newInstance(EmpService.class.getSimpleName());
	public void login() {
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
