package cn.kgc.tangcco.tcbd1016.commons.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDBUtils01 {
	public static void main(String[] args) {
		// 问：把大象装冰箱里，总共分几步
		// 答：分三步
		// 1、第一步：把冰箱门打开
		// 2、第二步：把大象装进去
		// 3、第三步：把冰箱门关上
		// 歧异：准备大象和冰箱
		String url = "jdbc:mysql://192.168.43.66:3306/mysqlday03?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimeZone=GMT";
		String user = "root";
		String password = "123456";
		String sql = "SELECT * FROM `emp`";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// 注册驱动器
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			conn = DriverManager.getConnection(url, user, password);
			// 预编译SQL语句
			pst = conn.prepareStatement(sql);
			// 执行SQL
			rs = pst.executeQuery();

			while (rs.next()) {
				System.out.println("昵称 >>> " + rs.getString("nickname"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
