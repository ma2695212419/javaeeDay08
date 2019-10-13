package cn.kgc.tangcco.tcbd1016.lihaozhe.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.EmpDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.impl.EmpDaoImpl;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.EmpService;


public class EmpServiceImpl implements EmpService {
	EmpDao empDao = new EmpDaoImpl();
	@Override
	public Map<String, Object> loginByAccountAndPassword(Emp emp) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		try {
			emp = empDao.selectEmpByAccountAndPassword(emp);
			if (emp != null) {
				map.put("status", "success");
				map.put("emp", emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

}
