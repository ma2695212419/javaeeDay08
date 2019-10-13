package cn.kgc.tangcco.tcbd1016.lihaozhe.spring;

import org.dom4j.Document;
import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.common.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.EmpDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class ClassPathXmlApplicationContextTest {
	@Test
	public void test01() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml");
		try {
			EmpDao dao01 = (EmpDao) classPathXmlApplicationContext.getBean(EmpDao.class.getSimpleName());
			EmpDao dao02 = (EmpDao) classPathXmlApplicationContext.getBean(EmpDao.class.getSimpleName());
			System.out.println(dao01 == dao02);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml", false);
		try {
			EmpDao dao01 = (EmpDao) classPathXmlApplicationContext.getBean(EmpDao.class.getSimpleName());
			EmpDao dao02 = (EmpDao) classPathXmlApplicationContext.getBean(EmpDao.class.getSimpleName());
			System.out.println(dao01 == dao02);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test03() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml", true);
		try {
			EmpDao dao01 = (EmpDao) classPathXmlApplicationContext.getBean(EmpDao.class.getSimpleName());
			EmpDao dao02 = (EmpDao) classPathXmlApplicationContext.getBean(EmpDao.class.getSimpleName());
			System.out.println(dao01 == dao02);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test04() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"ApplicationContext-service.xml");
		try {
			EmpDao dao = (EmpDao) classPathXmlApplicationContext.getBean(EmpDao.class.getSimpleName());
			Emp emp = dao.selectEmpsByAccountAndPassword(null);
			if (emp != null) {
				System.out.println(emp.getNickname());
			} else {
				System.out.println("账号或者密码错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
