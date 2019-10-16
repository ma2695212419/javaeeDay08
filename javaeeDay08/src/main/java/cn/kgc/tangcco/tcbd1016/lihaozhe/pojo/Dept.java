package cn.kgc.tangcco.tcbd1016.lihaozhe.pojo;
/**
 * @author 李昊哲
 * @version 1.0
 * 创建时间：	2019年7月8日 上午9:08:21 <br>
 * 类说明:	
 */

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dept {
	/**
	 * 部门编号
	 */
	private Integer id;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 该部门所有的员工
	 */
	private List<Emp> emps;

	public Dept(String name) {
		super();
		this.name = name;
	}

	public Dept(Integer id) {
		super();
		this.id = id;
	}
}
