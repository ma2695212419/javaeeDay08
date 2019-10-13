package cn.kgc.tangcco.tcbd1016.lihaozhe.dao;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.impl.EmpDaoImpl;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class EmpDaoTest {
	EmpDao empDao = new EmpDaoImpl();
	@Test
	public void selectEmpByAccountAndPassword() {
		Emp emp = empDao.selectEmpByAccountAndPassword(null);
		if (emp != null) {
			System.out.println("操作者>>>" + emp.getNickname());
		}else {
			System.out.println("账号或者密码错误");
		}
				
	}
}
