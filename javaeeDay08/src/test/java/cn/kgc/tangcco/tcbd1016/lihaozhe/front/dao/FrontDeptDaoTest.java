package cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Dept;

public class FrontDeptDaoTest {
	private static FrontDeptDao frontDeptDao;
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext-dao.xml");
	static {
		try {
			frontDeptDao = (FrontDeptDao) context.getBean(FrontDeptDao.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void selectDepts() {
		try {
			List<Dept> list = frontDeptDao.selectDepts(null);
			for (Dept dept : list) {
				System.out.println(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
