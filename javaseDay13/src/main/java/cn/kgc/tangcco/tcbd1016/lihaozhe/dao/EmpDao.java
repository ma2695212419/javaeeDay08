package cn.kgc.tangcco.tcbd1016.lihaozhe.dao;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public interface EmpDao {
	/**
	 * 员工登录
	 * @param emp	登录查询条件
	 * @return		返回员工信息
	 */
	public Emp selectEmpByAccountAndPassword(Emp emp);
}
