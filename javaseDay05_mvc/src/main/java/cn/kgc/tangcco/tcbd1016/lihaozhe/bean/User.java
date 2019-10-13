package cn.kgc.tangcco.tcbd1016.lihaozhe.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private String account;
	private String password;
	private String nickname;

	public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public User(String account, String password, String nickname) {
		super();
		this.account = account;
		this.password = password;
		this.nickname = nickname;
	}

}
