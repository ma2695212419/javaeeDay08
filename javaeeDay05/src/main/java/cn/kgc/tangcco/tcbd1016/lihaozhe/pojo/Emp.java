package cn.kgc.tangcco.tcbd1016.lihaozhe.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年7月8日 上午9:04:43 <br>
 *          类说明:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	/**
	 * 员工编号
	 */
	private int id;
	/**
	 * 员工姓名
	 */
	private String nickname;
	/**
	 * 系统账号
	 */
	private String account;
	/**
	 * 系统密码
	 */
	private String password;
	/**
	 * 员工生日
	 */
	private Date birthday;
	/**
	 * 性别
	 */
	private int gender;
	/**
	 * 员工权限
	 */
	private int powernum;
	/**
	 * 系统唯一标识符
	 */
	private String uuid;
	/**
	 * 部门对象
	 */
	private Dept dept;

	public Emp(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public Emp(String nickname, Date birthday, int gender, int powernum, String uuid, Dept dept) {
		super();
		this.nickname = nickname;
		this.birthday = birthday;
		this.gender = gender;
		this.powernum = powernum;
		this.uuid = uuid;
		this.dept = dept;
	}

	
}
