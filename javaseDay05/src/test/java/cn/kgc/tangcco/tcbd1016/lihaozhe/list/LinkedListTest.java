package cn.kgc.tangcco.tcbd1016.lihaozhe.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LinkedListTest {
	@Test
	public void test01() {
		List<Integer> list01 = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list01.add(i);
		}
		Iterator<Integer> it = list01.listIterator();
		while (it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
		}
		while (it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
		}
		System.out.println("第一次遍历迭代器结束");
		System.out.println("程序运行结束");
	}
	@Test
	public void test02() {
		List<Integer> list01 = new LinkedList<Integer>();
		int count = 0;
		for (int i = 0; i < 10; i++) {
			list01.add(i);
		}
		Iterator<Integer> it = list01.listIterator();
		while (it.hasNext()) {
			System.out.println(++count);
		}
		System.out.println("第一次遍历迭代器结束");
		System.out.println("程序运行结束");
	}
}
