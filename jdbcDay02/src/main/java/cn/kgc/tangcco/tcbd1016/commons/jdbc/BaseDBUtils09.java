package cn.kgc.tangcco.tcbd1016.commons.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseDBUtils09 {
	
	private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();
	private static DataSource ds = new ComboPooledDataSource();
	
	public static DataSource getDataSource(){
		return ds;
	}
	public static Connection getConnection() throws SQLException {
		if (t.get() == null) {
			t.set(ds.getConnection());
		}
		return t.get();
	}
	public static void startTransaction() throws SQLException {
		getConnection().setAutoCommit(false);
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
	
	public static void closeAndCommit(PreparedStatement pst, ResultSet rs) throws SQLException {
		Connection conn = getConnection();
		conn.commit();
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
	public static void closeAndRollback(PreparedStatement pst, ResultSet rs) throws SQLException {
		Connection conn = getConnection();
		conn.rollback();
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
