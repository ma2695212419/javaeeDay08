package cn.kgc.tangcco.tcbd1016.lihaozhe.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class LamdaTest {
	List<Integer> list = new ArrayList<Integer>();
	@Before
	public void init() {
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
	}

	@Test
	public void test01() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	@Test
	public void test02() {
		list.stream().forEach((lihaozhe)->{
			System.out.println(lihaozhe);
		});
	}
	@Test
	public void test03() {
		list.parallelStream().forEach((lihaozhe)->{
			System.out.println(lihaozhe);
		});
	}

	@Test
	public void test04() {
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 ==0) {
				continue;
			}
			System.out.println(list.get(i));
		}
	}
	@Test
	public void test05() {
		List<Integer> collect = list.stream().filter(i->i % 2 !=0).collect(Collectors.toList());
		collect.stream().forEach((lihaozhe)->{
			System.out.println(lihaozhe);
		});
	}
}
