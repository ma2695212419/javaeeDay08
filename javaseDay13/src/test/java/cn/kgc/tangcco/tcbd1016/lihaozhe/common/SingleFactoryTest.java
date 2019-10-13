package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.EmpDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class SingleFactoryTest {
	@Test
	public void test01() {
		EmpDao empDao = (EmpDao) SingleFactory.newInstance("EmpDao");
		Emp emp = empDao.selectEmpByAccountAndPassword(null);
		if (emp != null) {
			System.out.println("操作者>>>" + emp.getNickname());
		} else {
			System.out.println("账号或者密码错误");
		}
	}
}
