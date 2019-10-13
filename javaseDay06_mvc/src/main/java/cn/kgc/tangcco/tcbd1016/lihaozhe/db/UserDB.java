package cn.kgc.tangcco.tcbd1016.lihaozhe.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.bean.User;
import lombok.Data;
@Data
public class UserDB {
	private List<User> userList;
	private static UserDB instance;
	private static Map<String, UserDB> map = new HashMap<String, UserDB>();
	private UserDB() {
		// 实例化对象的时候
		userList = new ArrayList<User>() {{
			for (int i = 0; i < 100; i++) {
				add(new User("user" + i, "123456", "user" + i));
			}
		}};
	}
	public static UserDB newInstance() {
		if (map.containsKey("userdb")) {
			return map.get("userdb");
		} else {
			instance = new UserDB(); 
			map.put("userdb", instance);
			return instance;
		}
	}
}
