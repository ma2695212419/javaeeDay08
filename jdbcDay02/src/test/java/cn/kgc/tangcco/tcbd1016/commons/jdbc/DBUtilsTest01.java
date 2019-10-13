package cn.kgc.tangcco.tcbd1016.commons.jdbc;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.commons.pojo.Emp;

public class DBUtilsTest01 {

	@Test
	public void test01() {
		String sql = "SELECT * FROM `emp`";
		try {
			QueryRunner queryRunner = new QueryRunner(BaseDBUtils09.getDataSource());
			List<Emp> empList = queryRunner.query(sql, new BeanListHandler<Emp>(Emp.class));
			Iterator<Emp> it = empList.listIterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		StringBuilder sql = new StringBuilder("SELECT * FROM `emp` where 1 = 1");
		sql.append(" and account = ? ");
		sql.append(" and password = ? ");
		Object[] param = { "admin", "123456" };
		try {
			QueryRunner queryRunner = new QueryRunner(BaseDBUtils09.getDataSource());
			Emp emp = queryRunner.query(sql.toString(), param, new BeanHandler<Emp>(Emp.class));
			if (emp != null) {
				System.out.println(emp);
			} else {
				System.out.println("账号或者密码错误");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test03() {
		StringBuilder sql = new StringBuilder("UPDATE emp SET nickname = ? WHERE 1 = 1");
		sql.append(" AND uuid = ? ");
		Object[] param = { "李昊哲", "1076f6aec30803e35de4ab0bacc09da7d54f861402c088" };
		try {
			QueryRunner queryRunner = new QueryRunner(BaseDBUtils09.getDataSource());
			int i = queryRunner.update(sql.toString(), param);
			if (i > 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test04() {
		StringBuilder sql = new StringBuilder("UPDATE emp SET nickname = ? WHERE 1 = 1");
		sql.append(" AND uuid = ? ");
		Object[] param = { "phoenix", "1076f6aec30803e35de4ab0bacc09da7d54f861402c088" };
		try {
			QueryRunner queryRunner = new QueryRunner();
			int i = queryRunner.update(BaseDBUtils09.getConnection(),sql.toString(), param);
			if (i > 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
			// DbUtils.commitAndClose(BaseDBUtils09.getConnection());
			BaseDBUtils09.closeAll(null, null);
		} catch (SQLException e) {
			// DbUtils.rollbackAndClose(BaseDBUtils09.getConnection());
			try {
				BaseDBUtils09.closeAndRollback(null, null);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
