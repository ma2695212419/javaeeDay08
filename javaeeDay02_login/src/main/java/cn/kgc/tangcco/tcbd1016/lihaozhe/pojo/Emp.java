package cn.kgc.tangcco.tcbd1016.lihaozhe.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	private String uuid;
	private String account;
	private String password;
	private String nickname;
	private int gender;
	private Date birthday;

	public Emp(String nickname) {
		this.nickname = nickname;
	}
	public Emp(String account, String password) {
		this.account = account;
		this.password = password;
	}

}
