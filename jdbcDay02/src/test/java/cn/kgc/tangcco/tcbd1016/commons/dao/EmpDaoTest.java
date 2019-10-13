package cn.kgc.tangcco.tcbd1016.commons.dao;

import java.sql.SQLException;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.commons.dao.impl.EmpDaoImpl;
import cn.kgc.tangcco.tcbd1016.commons.jdbc.BaseDBUtils10;
import cn.kgc.tangcco.tcbd1016.commons.pojo.Emp;

public class EmpDaoTest {
	EmpDao empDao = new EmpDaoImpl();

	@Test
	public void updateEmp() {
		try {
			BaseDBUtils10.startTransaction();
			int i = empDao.updateEmp(new Emp("1076f6aec30803e35de4ab0bacc09da7d54f861402c088", "phoenix"));
			BaseDBUtils10.closeAndCommit();
			if (i > 0) {
				System.out.println("修改成功");
			}else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			try {
				BaseDBUtils10.closeAndRollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
