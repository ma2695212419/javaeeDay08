package cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao;

import java.sql.SQLException;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.md5.MD5Code;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class FrontEmpDaoTest {
	private static FrontEmpDao frontEmpDao;
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext-dao.xml");
	static {
		try {
			frontEmpDao = (FrontEmpDao) context.getBean(FrontEmpDao.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
 	public void selectEmpByAccountAndPassword() {
		try {
			Emp emp = frontEmpDao.selectEmpByAccountAndPassword(new Emp("admin", new MD5Code().getMD5ofStr("123456")));
			if (emp != null) {
				System.out.println(emp.getNickname());
			} else {
				System.out.println("账号或者密码错误");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
