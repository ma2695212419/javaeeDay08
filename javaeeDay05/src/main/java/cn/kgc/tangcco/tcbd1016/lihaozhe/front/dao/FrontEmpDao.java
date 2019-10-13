package cn.kgc.tangcco.tcbd1016.lihaozhe.front.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年7月20日 上午11:33:37 <br>
 *          类说明:
 */
public interface FrontEmpDao {

	/**
	 * 员工登录
	 * 
	 * @param emp 员工信息主要信包含账号和密码
	 * @return 员工信息
	 * @throws SQLException SQL异常
	 */
	public abstract Emp selectEmpByAccountAndPassword(Emp emp) throws SQLException;
	/**
	 * 查询所有员工总纪录数
	 * 
	 * @param map 查询条件
	 * @return 记录数
	 * @throws SQLException SQL异常
	 */
	public abstract long selectCountOfEmps(Map<String, Object> map) throws SQLException;
	/**
	 * 查询所有员工
	 * 
	 * @param map 查询条件
	 * @return 员工信息
	 * @throws SQLException SQL异常
	 */
	public abstract List<Emp> selectEmps(Map<String, Object> map) throws SQLException;

	/**
	 * 根据uuid查询权限
	 * 
	 * @param uuid 查询条件
	 * @return 权限
	 */
	public abstract Emp selectEmpByUuid(String uuid);
}
