package cn.kgc.tangcco.tcbd1016.lihaozhe.service.impl;

import java.util.HashMap;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.common.SingleFactory;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.EmpDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.EmpService;

public class EmpServiceImpl implements EmpService {
	// EmpDao empDao = new EmpDaoImpl();
	EmpDao empDao = (EmpDao) SingleFactory.newInstance(EmpDao.class.getSimpleName());

	@Override
	public Map<String, Object> empLoginByAccountAndPassword(Emp emp) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		Emp newEmp = empDao.selectEmpByAccountAndPassword(emp);
		if (newEmp != null) {
			map.put("status", "success");
			map.put("emp", newEmp);
		}
		return map;
	}

}
