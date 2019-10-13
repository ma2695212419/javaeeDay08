package cn.kgc.tangcco.tcbd1016.lihaozhe.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.EmpDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class EmpDaoImpl implements EmpDao {
	QueryRunner qrds = new QueryRunner(BaseDBUtils.getDataSource());
	QueryRunner qr = new QueryRunner();

	@Override
	public Emp selectEmpByAccountAndPassword(Emp emp) throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT * FROM `emp` where 1 = 1");
		sql.append(" and account = ?");
		sql.append(" and password = ?");
		Object[] params = { emp.getAccount(), emp.getPassword() };
		emp = qrds.query( sql.toString(), params, new BeanHandler<Emp>(Emp.class));
		return emp;
	}

}
