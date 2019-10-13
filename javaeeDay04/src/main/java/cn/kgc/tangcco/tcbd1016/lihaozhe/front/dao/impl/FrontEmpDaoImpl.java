package cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao.FrontEmpDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class FrontEmpDaoImpl implements FrontEmpDao {
	// 手动管理事务
	QueryRunner queryRunner = new QueryRunner();
	@Override
	public Emp selectEmpByAccountAndPassword(Emp emp) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from `emp` ");
		sql.append(" where 1 = 1 ");
		sql.append(" and `account` = ? ");
		sql.append(" and `password` = ? ");
		System.out.println(sql.toString());
		Object[] params = { emp.getAccount(), emp.getPassword() };
		emp = queryRunner.query(BaseDBUtils.getConnection(), sql.toString(), params, new BeanHandler<Emp>(Emp.class));
		return emp;
	}

	@Override
	public long selectCountOfEmps(Map<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Emp> selectEmps(Map<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp selectEmpByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
