package cn.kgc.tangcco.tcbd1016.lihaozhe.back.service;

import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;


/**
 * @author 李昊哲
 * @version 1.0
 * 创建时间：	2019年7月20日 下午5:12:30 <br>
 * 类说明:	
 */
public interface BackEmpService {
	/**
	 * 添加员工
	 * @param emp	员工信息
	 * @return		添加员工状态 
	 */
	public abstract Map<String,Object> saveEmp(Emp emp);
	/**
	 * 删除员工
	 * @param uuid	删除员工的条件
	 * @return		删除员工状态
	 */
	public abstract Map<String,Object> removeEmpByUuid(String uuid);
	/**
	 * 更新员工信息
	 * @param emp	员工信息
	 * @return		员工信息更新状态
	 */
	public abstract Map<String, Object> updateEmp(Emp emp);

}
