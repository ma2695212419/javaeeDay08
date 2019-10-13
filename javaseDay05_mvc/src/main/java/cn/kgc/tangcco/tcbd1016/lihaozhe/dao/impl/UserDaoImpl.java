package cn.kgc.tangcco.tcbd1016.lihaozhe.dao.impl;

import cn.kgc.tangcco.tcbd1016.lihaozhe.bean.User;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.UserDao;

public class UserDaoImpl implements UserDao {
	User userDB = new User("admin", "123456", "李昊哲");
	@Override
	public User selectUserByAccountAndPassword(User user) {
		if (userDB.getAccount().equals(user.getAccount()) && userDB.getPassword().equals(user.getPassword())) {
			// System.out.println("操作者>>>" + user.getNickname());
			return userDB;
		}
		return null;
	}

}
