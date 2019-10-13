package cn.kgc.tangcco.tcbd1016.lihaozhe.front.service;

import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年7月20日 上午11:33:37 <br>
 *          类说明:
 */
public interface FrontEmpService {
	/**
	 * 员工登录
	 * 
	 * @param emp 	员工信息主要信包含账号和密码
	 * @return 		员工登录状态
	 */
	public Map<String, Object> loginByAccountAndPassword(Emp emp);
	/**
	 * 查询所有员工
	 * 
	 * @param map	查询条件
	 * @return		员工信息
	 */
	public abstract Map<String, Object> queryEmps(Map<String, Object> map);
	/**
	 * 根据uuid查询权限
	 * @param uuid	查询条件
	 * @return		员工权限
	 */
	public Map<String, Object> queryEmpByUuid(String uuid);
}
