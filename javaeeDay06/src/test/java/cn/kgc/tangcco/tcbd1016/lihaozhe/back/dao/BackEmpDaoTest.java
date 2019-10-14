package cn.kgc.tangcco.tcbd1016.lihaozhe.back.dao;

import java.sql.SQLException;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;

public class BackEmpDaoTest {
	private static BackEmpDao backEmpDao;
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext-dao.xml");
	static {
		try {
			backEmpDao = (BackEmpDao) context.getBean(BackEmpDao.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void deleteEmpByUuid() {
		try {
			int i = backEmpDao.deleteEmpByUuid("6349352891511be940b3435a9d932df8edc2c5b612517925");
			if (i > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
