package cn.kgc.tangcco.tcbd1016.lihaozhe.service;

import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public interface EmpService {
	/**
	 * 员工登录
	 * 
	 * @param emp 登录查询条件
	 * @return 返回员工信息
	 */
	public Map<String, Object> empLoginByAccountAndPassword(Emp emp);
}
