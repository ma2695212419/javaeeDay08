package cn.kgc.tangcco.tcbd1016.lihaozhe.json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;

public class FastJsonTest {
	@Test
	public void beanToJson() {
		Emp emp = new Emp("李昊哲", 37, 1);
		System.out.println(emp);
		String jsonString = JSON.toJSONString(emp);
		System.out.println(jsonString);
	}
	@Test
	public void jsonToBean() {
		String jsonString = "{\"age\":37,\"gender\":1,\"name\":\"李昊哲\"}";
		Emp emp = JSON.parseObject(jsonString, Emp.class);
		System.out.println(emp);
	}
	
	@Test
	public void listToJson() {
		List<Emp> list = new ArrayList<Emp>() {{
			for (int i = 0; i < 5; i++) {
				if (i % 2 == 0) {
					add(new Emp("user" + i,  18 + i, 2));
				}else {
					add(new Emp("user" + i,  18 + i, 1));
				}
			}
		}};
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
	}
	@Test
	public void jsonToList() {
		String jsonString = "[{\"age\":18,\"gender\":2,\"name\":\"user0\"},{\"age\":19,\"gender\":1,\"name\":\"user1\"},{\"age\":20,\"gender\":2,\"name\":\"user2\"},{\"age\":21,\"gender\":1,\"name\":\"user3\"},{\"age\":22,\"gender\":2,\"name\":\"user4\"}]";
		List<Emp> list = JSON.parseArray(jsonString,Emp.class);
		System.out.println(list.toString());
	}
	@Test
	public void mapToJson() {
		List<Emp> list = new ArrayList<Emp>() {{
			for (int i = 0; i < 5; i++) {
				if (i % 2 == 0) {
					add(new Emp("user" + i,  18 + i, 2));
				}else {
					add(new Emp("user" + i,  18 + i, 1));
				}
			}
		}};
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 100);
		map.put("data", list);
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);
	}
	@Test
	public void jsonToMap() {
		String jsonString = "{\"code\":0,\"msg\":\"\",\"count\":100,\"data\":[{\"age\":18,\"gender\":2,\"name\":\"user0\"},{\"age\":19,\"gender\":1,\"name\":\"user1\"},{\"age\":20,\"gender\":2,\"name\":\"user2\"},{\"age\":21,\"gender\":1,\"name\":\"user3\"},{\"age\":22,\"gender\":2,\"name\":\"user4\"}]}";
		Map<String,Object> map = JSON.parseObject(jsonString, Map.class);
		System.out.println(map.toString());
	}
}
