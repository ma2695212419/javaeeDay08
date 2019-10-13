package cn.kgc.tangcco.tcbd1016.lihaozhe.dao;

import org.junit.Test;

public class EmpDaoTest {
	@Test
	public void test01() {
		EmpDao empDao = (a , b) -> {
			return a + b;
		};
		System.out.println(empDao.math(10, 20) );
	}
	@Test
	public void test02() {
		EmpDao empDao = (a , b) -> {
			return a - b;
		};
		System.out.println(empDao.math(40, 20) );
	}
	@Test
	public void test03() {
		EmpDao empDao = (a , b) -> {
			return a * b;
		};
		System.out.println(empDao.math(10, 20) );
	}
	@Test
	public void test04() {
		EmpDao empDao = (a , b) -> {
			return a / b;
		};
		System.out.println(empDao.math(40, 20) );
	}
}
