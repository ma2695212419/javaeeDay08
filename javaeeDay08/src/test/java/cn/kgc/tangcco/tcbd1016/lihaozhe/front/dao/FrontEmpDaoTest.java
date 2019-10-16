package cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.PageRang;
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
	@Test
	public void selectEmps() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pr", new PageRang(2, 5));
			List<Emp> list = frontEmpDao.selectEmps(map);
			if (list != null && list.size() > 0) {
				ListIterator<Emp> it = list.listIterator();
				while (it.hasNext()) {
					Emp emp =  it.next();
					System.out.println(emp);
					
				}
			} else {
				System.out.println("我是有底线的");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void selectEmpByUuid() {
		try {
			Emp emp = frontEmpDao.selectEmpByUuid("6349352891511be940b3435a9d932df8edc2c5b612517925");
			if (emp != null) {
				System.out.println(emp);
			} else {
				System.out.println("未找到查询结果");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void selectCountByAccount() {
			try {
				long i = frontEmpDao.selectCountByAccount("adminasd");
				System.out.println(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
