package cn.kgc.tangcco.tcbd1016.commons.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.commons.dao.EmpDao;
import cn.kgc.tangcco.tcbd1016.commons.dao.impl.EmpDaoImpl;
import cn.kgc.tangcco.tcbd1016.commons.jdbc.BaseDBUtils10;
import cn.kgc.tangcco.tcbd1016.commons.pojo.Emp;
import cn.kgc.tangcco.tcbd1016.commons.service.EmpService;

public class EmpServiceImpl implements EmpService {
	EmpDao empDao = new EmpDaoImpl();
	@Override
	public Map<String, Object> updateEmp(Emp emp) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		try {
			BaseDBUtils10.startTransaction();
			int i = empDao.updateEmp(emp);
			BaseDBUtils10.closeAndCommit();
			if (i > 0) {
				map.put("status", "success");
			}
		} catch (SQLException e) {
			try {
				BaseDBUtils10.closeAndRollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return map;
	}

}
