package cn.kgc.tangcco.tcbd1016.lihaozhe.dao;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public interface EmpDao {
	/**
	 *	员工登录
	 * @param emp	员工登录必要的参数 主要是账号和密码
	 * @return		登录成功后的员工的信息
	 */
	public abstract Emp selectEmpsByAccountAndPassword(Emp emp);
}
