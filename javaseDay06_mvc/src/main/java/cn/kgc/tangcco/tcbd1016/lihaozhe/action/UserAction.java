package cn.kgc.tangcco.tcbd1016.lihaozhe.action;

import java.util.Map;
import java.util.Scanner;

import cn.kgc.tangcco.tcbd1016.lihaozhe.bean.User;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.UserService;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.impl.UserServiceImpl;

public class UserAction {
	Scanner sc = new Scanner(System.in);
	UserService userService = new UserServiceImpl();
	public void login() {
		System.out.print("请输入账号>>>");
		String account = sc.next();
		System.out.print("请输入密码>>>");
		String password = sc.next();
		User user = new User(account, password);
		Map<String, Object> map = userService.loginByAccountAndPassword(user);
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
