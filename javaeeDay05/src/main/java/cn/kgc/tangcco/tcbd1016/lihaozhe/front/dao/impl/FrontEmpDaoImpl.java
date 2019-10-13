package cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.PageRang;
import cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao.FrontEmpDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Dept;
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
		Object[] params = { emp.getAccount(), emp.getPassword() };
		return queryRunner.query(BaseDBUtils.getConnection(), sql.toString(), params, new BeanHandler<Emp>(Emp.class));
	}

	@Override
	public long selectCountOfEmps(Map<String, Object> map) throws SQLException {
		return 0;
	}

	@Override
	public List<Emp> selectEmps(Map<String, Object> map) throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT e.`nickname`, e.`birthday`,e.`gender`,e.`powernum`,e.`uuid`, d.`name` FROM emp as e INNER JOIN dept as d WHERE 1 = 1");
		sql.append(" AND e.did = d.id ");
		// 存储参数
		List list = new ArrayList();
		// 存储查询结果
		List<Emp> empList = new ArrayList<Emp>();
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		if (map != null && map.size() > 0) {
			// 动态	SQL
		}
		pst = BaseDBUtils.getPreparedStatement(conn, sql.toString(), (PageRang)map.get("pr"));
		rs = BaseDBUtils.executeQuery(pst, list.toArray());
		if (rs != null) {
			while (rs.next()) {
				empList.add(new Emp(rs.getString("nickname"), rs.getDate("birthday"), rs.getInt("gender"), rs.getInt("powernum"), rs.getString("uuid"), new Dept(rs.getString("name"))));
			}
		}
		// 返回有查询参数的的结果
		return empList;
	}

	@Override
	public Emp selectEmpByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
