package cn.kgc.tangcco.tcbd1016.lihaozhe.system;

import cn.kgc.tangcco.tcbd1016.lihaozhe.action.UserAction;

public class SystemStart {
	public static void main(String[] args) {
		UserAction userAction = new UserAction();
		userAction.login();
	}
}
