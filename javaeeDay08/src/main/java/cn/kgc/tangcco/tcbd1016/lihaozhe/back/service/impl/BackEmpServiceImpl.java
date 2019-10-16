package cn.kgc.tangcco.tcbd1016.lihaozhe.back.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.back.dao.BackEmpDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.back.service.BackEmpService;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class BackEmpServiceImpl implements BackEmpService {
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

	@Override
	public Map<String, Object> saveEmp(Emp emp) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		try {
			BaseDBUtils.startTransaction();
			int status = backEmpDao.insertEmp(emp);
			if (status > 0) {
				BaseDBUtils.commitAndClose();
				map.put("status", "success");
			}
		} catch (SQLException e) {
			try {
				BaseDBUtils.RollbackAndclose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> removeEmpByUuid(String uuid) {
		// 存储删除成功或者失败的状态
		Map<String, Object> map = new HashMap<String, Object>();
		// 默认值是failed
		map.put("status", "failed");
		try {
			// 开启事务
			BaseDBUtils.startTransaction();
			// 调用dao层接口中的方法
			int i = backEmpDao.deleteEmpByUuid(uuid);
			if (i > 0) {
				// 删除成功修改状态为success
				map.put("status", "success");
			}
			// 提交事务并将连接归还给数据源
			BaseDBUtils.commitAndClose();
		} catch (SQLException e) {
			try {
				// 事务回滚并将连接归还给数据源
				BaseDBUtils.RollbackAndclose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> updateEmp(Emp emp) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		try {
			BaseDBUtils.startTransaction();
			int status = backEmpDao.insertEmp(emp);
			if (status > 0) {
				BaseDBUtils.commitAndClose();
				map.put("status", "success");
			}
		} catch (SQLException e) {
			try {
				BaseDBUtils.RollbackAndclose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return map;
	}

}
