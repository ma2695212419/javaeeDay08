package cn.kgc.tangcco.tcbd1016.lihaozhe.dao;

import java.sql.SQLException;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public interface EmpDao {
	public Emp selectEmpByAccountAndPassword(Emp emp) throws SQLException;
}
