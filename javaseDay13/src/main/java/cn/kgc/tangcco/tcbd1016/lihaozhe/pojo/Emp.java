package cn.kgc.tangcco.tcbd1016.lihaozhe.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Emp {
	private int id;
	private String nickname,account,password;
	public Emp(String nickname, String account, String password) {
		this.nickname = nickname;
		this.account = account;
		this.password = password;
	}
	
}
