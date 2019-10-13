package cn.kgc.tangcco.tcbd1016.commons.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.kgc.tangcco.tcbd1016.commons.dao.EmpDao;
import cn.kgc.tangcco.tcbd1016.commons.jdbc.BaseDBUtils10;
import cn.kgc.tangcco.tcbd1016.commons.pojo.Emp;

public class EmpDaoImpl implements EmpDao{
	QueryRunner queryRunner = new QueryRunner();
	@Override
	public int updateEmp(Emp emp) {
		StringBuilder sql = new StringBuilder("UPDATE emp SET nickname = ? WHERE 1 = 1");
		sql.append(" AND uuid = ? ");
		Object[] param = { emp.getNickname(), emp.getUuid() };
		int update = 0;
		try {
			 update = queryRunner.update(BaseDBUtils10.getConnection(),sql.toString(), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}

}
