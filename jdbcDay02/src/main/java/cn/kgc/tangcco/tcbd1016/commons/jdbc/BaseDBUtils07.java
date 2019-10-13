package cn.kgc.tangcco.tcbd1016.commons.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDBUtils07 {
	static InputStream is;
	static Properties properties;
	static {
		try {
			// 注册驱动器
			Class.forName("com.mysql.jdbc.Driver");
			is = BaseDBUtils07.class.getClassLoader().getResourceAsStream("db.properties");
			properties = new Properties();
			properties.load(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();

	public static Connection getConnection() throws SQLException {
		if (t.get() == null) {
			t.set(DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("password")));
		}
		return t.get();
	}

	public static PreparedStatement getPreparedStatement(Connection conn, String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

	public static ResultSet executeQuery(PreparedStatement pst, Object... parma) throws SQLException {
		if (parma != null && parma.length > 0) {
			for (int i = 0; i < parma.length; i++) {
				pst.setObject(i + 1, parma[i]);
			}
		}
		return pst.executeQuery();
	}

	public static int executeUpdate(PreparedStatement pst, Object... parma) throws SQLException {
		if (parma != null && parma.length > 0) {
			for (int i = 0; i < parma.length; i++) {
				pst.setObject(i + 1, parma[i]);
			}
		}
		return pst.executeUpdate();
	}

	public static void closeAll(PreparedStatement pst, ResultSet rs) throws SQLException {
		Connection conn = getConnection();
		if (rs != null) {
			rs.close();
		}
		if (pst != null) {
			pst.close();
		}
		if (conn != null) {
			conn.close();
		}
		t.remove();
	}
}
