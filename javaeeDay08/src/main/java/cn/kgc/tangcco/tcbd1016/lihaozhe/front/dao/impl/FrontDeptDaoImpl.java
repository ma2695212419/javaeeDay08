package cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.kgc.tangcco.tcbd1016.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao.FrontDeptDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Dept;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年7月20日 下午2:49:16 <br>
 *          类说明:
 */
public class FrontDeptDaoImpl implements FrontDeptDao {
	private QueryRunner queryRunner = new QueryRunner();

	@Override
	public List<Dept> selectDepts(Map<String, Object> map) throws SQLException {
		StringBuilder sql = new StringBuilder("select * from `dept`");
		sql.append(" where 1 = 1 ");
		List list = new ArrayList();
		Object[] params = list.toArray();
		List<Dept> deptList = null;
		System.out.println(sql.toString());
		if (params.length > 0) {
			deptList = (List<Dept>) queryRunner.query(BaseDBUtils.getConnection(), sql.toString(), params,
					new BeanListHandler(Dept.class));
		} else {
			deptList = (List<Dept>) queryRunner.query(BaseDBUtils.getConnection(), sql.toString(),
					new BeanListHandler(Dept.class));
		}
		return deptList;
	}

}
