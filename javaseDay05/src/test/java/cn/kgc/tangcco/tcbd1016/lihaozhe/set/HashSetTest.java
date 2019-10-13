package cn.kgc.tangcco.tcbd1016.lihaozhe.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class HashSetTest {
	@Test
	public void test01() {
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(2);
		list.add(11);
		set.add(11);
		set.add(2);
		set.add(11);
		System.out.println(list.size());
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("+++++++++++++++++++");
		System.out.println(set.size());
		for (Integer integer : set) {
			System.out.println(integer);
		}
		// HashSet 无序(存储的顺序与录入的顺序无关)不可重复
		// List 有序(录入的顺序)可重复
	}
	@Test
	public void test02() {
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(11);
		set.add(2);
		set.add(11);
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
}
