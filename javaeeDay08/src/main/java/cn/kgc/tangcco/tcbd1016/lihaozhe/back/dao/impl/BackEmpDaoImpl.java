package cn.kgc.tangcco.tcbd1016.lihaozhe.back.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.kgc.tangcco.tcbd1016.lihaozhe.back.dao.BackEmpDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class BackEmpDaoImpl implements BackEmpDao{
	// 手动管理事务
	QueryRunner queryRunner = new QueryRunner();
	@Override
	public int insertEmp(Emp emp) throws SQLException {
		StringBuilder sql = new StringBuilder(
				"insert into `emp` (`nickname`,`account`,`birthday`,`gender`,`powernum`,`uuid`,`did`) ");
		sql.append(" select ?,?,?,?,?,?,? ");
		sql.append(" from dual ");
		sql.append(" WHERE NOT EXISTS  ");
		sql.append(" ( ");
		sql.append(" select `id` from `emp` WHERE  1 = 1 ");
		sql.append(" and `account` = ? ");
		sql.append(" ) ");
		System.out.println(sql.toString());
		Object[] params = { emp.getNickname(), emp.getAccount(), emp.getBirthday(), emp.getGender(),
				emp.getPowernum(), emp.getUuid(), emp.getDid(), emp.getAccount() };
		return queryRunner.update(BaseDBUtils.getConnection(), sql.toString(), params);
	}

	@Override
	public int deleteEmpByUuid(String uuid) throws SQLException {
		StringBuilder sql = new StringBuilder("DELETE FROM emp WHERE 1 = 1 ");
		sql.append(" AND uuid = ? ");
		return  queryRunner.update(BaseDBUtils.getConnection(), sql.toString(), uuid);
	}

	@Override
	public int updateEmp(Emp emp) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
