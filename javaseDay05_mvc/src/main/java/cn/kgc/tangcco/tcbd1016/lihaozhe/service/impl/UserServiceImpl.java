package cn.kgc.tangcco.tcbd1016.lihaozhe.service.impl;

import cn.kgc.tangcco.tcbd1016.lihaozhe.bean.User;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.UserDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.impl.UserDaoImpl;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public User loginByAccountAndPassword(User user) {
		User newUser = userDao.selectUserByAccountAndPassword(user);
		if (newUser != null) {
			return newUser;
		}
		return newUser;
	}

}
