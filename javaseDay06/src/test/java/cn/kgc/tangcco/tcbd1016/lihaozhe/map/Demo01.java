package cn.kgc.tangcco.tcbd1016.lihaozhe.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class Demo01 {
	@Test
	public void test01() {
		// key value
		Map map = new HashMap();
		map.put("lhz", 37);
		map.put("lqy", 25);
		System.out.println(map.size());
		System.out.println(map.get("lhz"));
		System.out.println(map.get("lqy"));
		System.out.println("+++++++++++++++++++++");
	}
	@Test
	public void test02() {
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
	public void test03() {
		// key value
		Map map = new HashMap();
		map.put("lhz", 37);
		map.put("lqy", 25);
		map.put("lhz", 18);
		System.out.println(map.size());
		System.out.println(map.get("lhz"));
		System.out.println(map.get("lqy"));
		System.out.println("+++++++++++++++++++++");
	}
	@Test
	public void test04() {
		// key value
		Map map = new HashMap();
		map.put("lhz", 37);
		map.put("lqy", 25);
		map.remove("lhz");
		System.out.println(map.size());
		System.out.println(map.get("lhz"));
		System.out.println(map.get("lqy"));
		System.out.println("+++++++++++++++++++++");
	}
	@Test
	public void test05() {
		// key value
		Map map = new HashMap();
		map.put("lhz", 37);
		map.put("lqy", 25);
		System.out.println(map.containsKey("lhz"));
		map.remove("lhz");
		System.out.println(map.containsKey("lhz"));
		System.out.println(map.size());
		System.out.println(map.get("lhz"));
		System.out.println(map.get("lqy"));
		System.out.println("+++++++++++++++++++++");
	}
	@Test
	public void test06() {
		// key value
		Map map = new HashMap();
		map.put("lhz", 37);
		map.put("lqy", 25);
		// 获取所有的key
		// 遍历key遍历的同时根据key获取该key对应的value
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> it = entrySet.iterator();
		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
