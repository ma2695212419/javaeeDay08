package cn.kgc.tangcco.tcbd1016.lihaozhe.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private int id;
	private String account;
	private String password;
	private String nickname;
	private static int count;

	public User(String account, String password) {
		this.account = account;
		this.password = password;
	}

	public User(String account, String password, String nickname) {
		id = ++count;
		this.account = account;
		this.password = password;
		this.nickname = nickname;
	}

}
