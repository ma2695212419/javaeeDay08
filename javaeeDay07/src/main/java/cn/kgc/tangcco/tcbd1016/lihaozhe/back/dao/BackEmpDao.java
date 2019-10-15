package cn.kgc.tangcco.tcbd1016.lihaozhe.back.dao;

import java.sql.SQLException;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;


/**
 * @author 李昊哲
 * @version 1.0
 * 创建时间：	2019年7月20日 下午5:18:37 <br>
 * 类说明:	
 */
public interface BackEmpDao {
	/**
	 * 新增员工
	 * @param emp				新增的员工信息
	 * @return					新增状态	返回大于值0代表新增成功 否则新增失败
	 * @throws SQLException		SQL异常
	 */
	public abstract int insertEmp(Emp emp) throws SQLException;
	/**
	 * 删除员工
	 * @param uuid				员工唯一标识符	
	 * @return					删除状态	返回大于值0代表删除成功 否则删除失败
	 * @throws SQLException		SQL异常
	 */
	public abstract int deleteEmpByUuid(String uuid) throws SQLException;
	/**
	 * 更新员工信息
	 * @param emp				员工信息
	 * @return					员工信息更新	返回大于值0代表删除成功 否则删除失败
	 * @throws SQLException		SQL异常
	 */
	public abstract int updateEmp(Emp emp) throws SQLException;
}
