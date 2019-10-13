package cn.kgc.tangcco.tcbd1016.lihaozhe.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Demo02 {
	@Test
	public void test01() {
		// key value
		Map map = new HashMap();
		map.put("lhz", 37);
		map.put("lqy", 25);
		// 获取所有的key
		// 遍历key遍历的同时根据key获取该key对应的value
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + " = " + map.get(key));
		}
	}

	@Test
	public void test02() {
		// key value
		Map map = new LinkedHashMap();
		map.put("lhz", 37);
		map.put("lqy", 25);
		// 获取所有的key
		// 遍历key遍历的同时根据key获取该key对应的value
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + " = " + map.get(key));
		}
	}
}
