package cn.kgc.tangcco.tcbd1016.lihaozhe.front.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao.FrontEmpDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.front.service.FrontEmpService;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class FrontEmpServiceImpl implements FrontEmpService {
	private static FrontEmpDao frontEmpDao;
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"spring/ApplicationContext-dao.xml");
	static {
		try {
			frontEmpDao = (FrontEmpDao) context.getBean(FrontEmpDao.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> loginByAccountAndPassword(Emp emp) {
		// 存储登录信息
		Map<String, Object> map = new HashMap<String, Object>();
		// 登录状态默认为failed
		map.put("status", "failed");
		try {
			// 调用dao层方法返回查询结果
			emp = frontEmpDao.selectEmpByAccountAndPassword(emp);
			if (emp != null) {
				// 如果查询结果不为null则更改登录状态为success
				map.put("status", "success");
				// 如果查询结果不为null则更改登录状态为success后将登录者信息存储在map中
				map.put("emp", emp);
			}
			// 将连接归还给数据源
			BaseDBUtils.closeAll();
			return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> queryEmps(Map<String, Object> map) {
		// 存储查询结果
		Map<String, Object> empMap = new LinkedHashMap<String, Object>();
		empMap.put("code", 0);
		empMap.put("msg", "");
		// 总记录数
		empMap.put("count", 0);
		try {
			// 查询结果
			empMap.put("data", frontEmpDao.selectEmps(map));
			// 将连接归还给数据源
			BaseDBUtils.closeAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empMap;
	}

	@Override
	public Map<String, Object> queryEmpByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
