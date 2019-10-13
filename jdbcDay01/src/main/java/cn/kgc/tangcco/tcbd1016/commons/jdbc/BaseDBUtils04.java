package cn.kgc.tangcco.tcbd1016.commons.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import cn.kgc.tangcco.tcbd1016.commons.pojo.Emp;

public class BaseDBUtils04 {
	static InputStream is;
	static Properties properties;
	static {
		try {
			is = BaseDBUtils04.class.getClassLoader().getResourceAsStream("db.properties");
			properties = new Properties();
			properties.load(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

	public static void main(String[] args) {
		// 问：把大象装冰箱里，总共分几步
		// 答：分三步
		// 1、第一步：把冰箱门打开
		// 2、第二步：把大象装进去
		// 3、第三步：把冰箱门关上
		// 歧异：准备大象和冰箱
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		StringBuilder sql = new StringBuilder("SELECT * FROM `emp` where 1 = 1");
		sql.append(" and account = ? ");
		sql.append(" and password = ? ");
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// 注册驱动器
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			conn = DriverManager.getConnection(url, user, password);
			// 预编译SQL语句
			pst = conn.prepareStatement(sql.toString());
			// 执行SQL
			pst.setObject(1, "admin");
			pst.setObject(2, "123456");
			rs = pst.executeQuery();
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
