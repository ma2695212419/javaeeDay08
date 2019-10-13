package cn.kgc.tangcco.tcbd1016.lihaozhe.dao;

import cn.kgc.tangcco.tcbd1016.lihaozhe.bean.User;

public interface UserDao {
	/**
	 * 用户登录
	 * @param user	登录参数 主要参数为账号account和密码password
	 * @return		登录者信息
	 */
	public User selectUserByAccountAndPassword(User user);
}
