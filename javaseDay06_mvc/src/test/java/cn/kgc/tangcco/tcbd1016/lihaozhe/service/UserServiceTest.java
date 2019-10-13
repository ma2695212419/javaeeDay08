package cn.kgc.tangcco.tcbd1016.lihaozhe.service;

import java.util.Map;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.bean.User;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.impl.UserServiceImpl;

public class UserServiceTest {
	UserService userService = new UserServiceImpl();
	@Test
	public void loginByAccountAndPassword() {
		Map<String, Object> map = userService.loginByAccountAndPassword(new User("user0", "123456"));
		switch (map.get("status").toString()) {
		case "success":
			System.out.println("操作者>>>" + ((User)map.get("user")).getNickname());
			break;
		case "failed":
			System.out.println("账号或者密码错误");
			break;

		default:
			break;
		}
	}
}
