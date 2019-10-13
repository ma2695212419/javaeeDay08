package cn.kgc.tangcco.tcbd1016.lihaozhe.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
	private Integer id;
	/**
	 * 员工姓名
	 */
	@NonNull
	private String nickname;
	/**
	 * 系统账号
	 */
	@NonNull
	private String account;
	/**
	 * 系统密码
	 */
	@NonNull
	private String password;
	/**
	 * 员工生日
	 */
	@NonNull
	private Date birthday;
	/**
	 * 性别
	 */
	@NonNull
	private Integer gender;
	/**
	 * 员工权限
	 */
	@NonNull
	private Integer powernum;
	/**
	 * 系统唯一标识符
	 */
	@NonNull
	private String uuid;
	/**
	 * 部门对象
	 */
	@NonNull
	private Dept dept;

	public Emp(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public Emp(String nickname, String uuid, Integer powernum) {
		super();
		this.nickname = nickname;
		this.uuid = uuid;
		this.powernum = powernum;
	}
}
