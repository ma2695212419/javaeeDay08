package cn.kgc.tangcco.tcbd1016.lihaozhe.dao.impl;

import java.util.List;
import java.util.ListIterator;

import cn.kgc.tangcco.tcbd1016.lihaozhe.bean.User;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.UserDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.db.UserDB;

public class UserDaoImpl implements UserDao {
	UserDB userDb = UserDB.newInstance();
	@Override
	public User selectUserByAccountAndPassword(User user) {
		List<User> userList = userDb.getUserList();
		ListIterator<User> it = userList.listIterator();
		User user2 = null;
		while (it.hasNext()) {
			user2 = it.next();
			if (user2.getAccount().equals(user.getAccount()) && user2.getPassword().equals(user.getPassword())) {
				// System.out.println("操作者>>>" + user.getNickname());
				return user2;
			}
		}
		return null;
	}

}
