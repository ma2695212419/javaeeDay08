package cn.kgc.tangcco.tcbd1016.commons.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.commons.pojo.Emp;

public class BaseDBUtils08Test {
	@Test
	public void test01() {
		StringBuilder sql = new StringBuilder("UPDATE emp SET nickname = ? WHERE 1 = 1");
		sql.append(" AND uuid = ? ");
		Object[] parma = { "李昊哲", "1076f6aec30803e35de4ab0bacc09da7d54f861402c088" };
		Connection conn = null;
		PreparedStatement pst = null;
		int i = 0;
		try {
			conn = BaseDBUtils08.getConnection();
			BaseDBUtils08.startTransaction();
			pst = BaseDBUtils08.getPreparedStatement(conn, sql.toString());
			i = BaseDBUtils08.executeUpdate(pst, parma);
			Emp emp = null;
			if (i > 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				BaseDBUtils08.closeAll(pst, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test02() {
		StringBuilder sql = new StringBuilder("UPDATE emp SET nickname = ? WHERE 1 = 1");
		sql.append(" AND uuid = ? ");
		Object[] parma = { "李昊哲", "1076f6aec30803e35de4ab0bacc09da7d54f861402c088" };
		Connection conn = null;
		PreparedStatement pst = null;
		int i = 0;
		try {
			conn = BaseDBUtils08.getConnection();
			BaseDBUtils08.startTransaction();
			pst = BaseDBUtils08.getPreparedStatement(conn, sql.toString());
			i = BaseDBUtils08.executeUpdate(pst, parma);
			Emp emp = null;
			if (i > 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
			BaseDBUtils08.closeAndCommit(pst, null);
		} catch (SQLException e) {
			try {
				BaseDBUtils08.closeAndRollback(pst, null);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Test
	public void test03() {
		StringBuilder sql = new StringBuilder("UPDATE emp SET nickname = ? WHERE 1 = 1");
		sql.append(" AND uuid = ? ");
		Object[] parma = { "phoenix", "1076f6aec30803e35de4ab0bacc09da7d54f861402c088" };
		Connection conn = null;
		PreparedStatement pst = null;
		int i = 0;
		try {
			conn = BaseDBUtils08.getConnection();
			BaseDBUtils08.startTransaction();
			pst = BaseDBUtils08.getPreparedStatement(conn, sql.toString());
			i = BaseDBUtils08.executeUpdate(pst, parma);
			Emp emp = null;
			if (i > 0) {

				System.out.println("修改成功");
				System.out.println(1 / 0);
			} else {
				System.out.println("修改失败");
			}
			BaseDBUtils08.closeAndCommit(pst, null);
		} catch (Exception e) {
			try {
				BaseDBUtils08.closeAndRollback(pst, null);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
