package cn.kgc.tangcco.tcbd1016.lihaozhe.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.bean.User;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.UserDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.impl.UserDaoImpl;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public Map<String, Object> loginByAccountAndPassword(User user) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("status", "failed");
		User newUser = userDao.selectUserByAccountAndPassword(user);
		if (newUser != null) {
			map.put("status", "success");
			map.put("user", newUser);
		}
		return map;
	}

}
