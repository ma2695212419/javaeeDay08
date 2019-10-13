package cn.kgc.tangcco.tcbd1016.commons.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.commons.pojo.Emp;

public class BaseDBUtils05Test {
	@Test
	public void test01() {
		StringBuilder sql = new StringBuilder("SELECT * FROM `emp` where 1 = 1");
		sql.append(" and account = ? ");
		sql.append(" and password = ? ");
		Object[] parma = {"admin","123456"};
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = BaseDBUtils05.getConnection();
			pst = BaseDBUtils05.getPreparedStatement(conn, sql.toString());
			rs = BaseDBUtils05.executeQuery(pst, parma);
			Emp emp = null;
			if (rs.next()) {
				emp = new Emp(rs.getString("uuid"), rs.getString("account"), rs.getString("password"),
						rs.getString("nickname"), rs.getInt("gender"), rs.getDate("birthday"));
			}
			if (emp != null) {
				System.out.println(emp);
			}else {
				System.out.println("账号或者密码错误");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				BaseDBUtils05.closeAll(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
