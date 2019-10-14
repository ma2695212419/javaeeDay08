package cn.kgc.tangcco.tcbd1016.lihaozhe.front.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao.FrontDeptDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.front.service.FrontDeptService;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Dept;


/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年7月20日 下午12:39:47 <br>
 *          类说明:
 */
public class FrontDeptServiceImpl implements FrontDeptService {
	public final static ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
			"spring/ApplicationContext-dao.xml");
	public static FrontDeptDao frontDeptDao = null;
	static {
		try {
			frontDeptDao = (FrontDeptDao) ac.getBean(FrontDeptDao.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> queryDepts(Map<String, Object> map) {
		Map<String, Object> deptMap = new LinkedHashMap<String, Object>();
		deptMap.put("code", 0);
		deptMap.put("msg", "");
		try {
			List<Dept> list = frontDeptDao.selectDepts(null);
			if (list != null) {
				deptMap.put("count", list.size());
				deptMap.put("data", list);
			} else {
				deptMap.put("count", 0);
				deptMap.put("data", new ArrayList());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptMap;
	}

}
