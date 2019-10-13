package cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class BaseDBUtils {

	private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();
	private static DataSource ds = new ComboPooledDataSource();

	public static DataSource getDataSource() {
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

	// 分页查询
	public static ResultSet executeQueryPageRang(PreparedStatement pst, PageRang pageRang, Object... params)
			throws SQLException {
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i + 1, params[i]);
			}
		}
		int pageIndex = ((pageRang.getPageNumber() - 1) * pageRang.getPageSize());
		pst.setMaxRows(pageIndex + pageRang.getPageSize());
		ResultSet rs = pst.executeQuery();
		rs.relative(pageIndex);
		return rs;
	}

	// 分页查询
	public static ResultSet executeQueryPageRang(PreparedStatement pst, String sql, PageRang pageRang, Object... params)
			throws SQLException {
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i + 1, params[i]);
			}
		}
		int pageIndex = ((pageRang.getPageNumber() - 1) * pageRang.getPageSize());
		sql += "limit " + pageIndex + "," + pageRang.getPageSize();
		ResultSet rs = pst.executeQuery(sql);
		return rs;
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

	public static void closeAndCommit() throws SQLException {
		DbUtils.commitAndClose(getConnection());
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

	public static void closeAndRollback() throws SQLException {
		DbUtils.rollbackAndClose(getConnection());
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
