package cn.kgc.tangcco.tcbd1016.lihaozhe.dao;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.bean.User;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.impl.UserDaoImpl;

public class UserDaoTest {
	UserDao userDao = new UserDaoImpl();
	@Test
	public void selectUserByAccountAndPassword() {
		User user = userDao.selectUserByAccountAndPassword(new User("user0", "123456"));
		if (user != null) {
			System.out.println("操作者>>>" + user.getNickname());
		}else{
			System.out.println("账号或者密码错误");
		}
	}
}
