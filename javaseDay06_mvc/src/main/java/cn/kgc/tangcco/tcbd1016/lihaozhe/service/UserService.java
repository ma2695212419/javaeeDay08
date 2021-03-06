package cn.kgc.tangcco.tcbd1016.lihaozhe.service;

import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.bean.User;

public interface UserService {
	/**
	 * 用户登录
	 * @param user	登录参数 主要参数为账号account和密码password
	 * @return		登录者信息
	 */
	public Map<String, Object> loginByAccountAndPassword(User user);
}
