package cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Dept;


/**
 * @author 李昊哲
 * @version 1.0
 * 创建时间：	2019年7月20日 上午11:33:37 <br>
 * 类说明:	
 */
public interface FrontDeptDao {
	/**
	 * 查询部门信息
	 * @param map				查询条件
	 * @return					部门信息
	 * @throws SQLException		SQL异常
	 */
	public abstract List<Dept> selectDepts(Map<String,Object> map) throws SQLException;
}
