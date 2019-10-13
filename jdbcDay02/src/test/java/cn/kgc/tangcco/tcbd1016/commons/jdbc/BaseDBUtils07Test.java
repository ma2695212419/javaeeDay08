package cn.kgc.tangcco.tcbd1016.commons.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.commons.pojo.Emp;

public class BaseDBUtils07Test {
	@Test
	public void test01() {
		StringBuilder sql = new StringBuilder("UPDATE emp SET nickname = ? WHERE 1 = 1");
		sql.append(" AND uuid = ? ");
		Object[] parma = {"phoenix","1076f6aec30803e35de4ab0bacc09da7d54f861402c088"};
		Connection conn = null;
		PreparedStatement pst = null;
		int i = 0;
		try {
			conn = BaseDBUtils07.getConnection();
			pst = BaseDBUtils07.getPreparedStatement(conn, sql.toString());
			i = BaseDBUtils07.executeUpdate(pst, parma);
			Emp emp = null;
			if (i > 0) {
				System.out.println("修改成功");
			}else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				BaseDBUtils07.closeAll(pst, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
