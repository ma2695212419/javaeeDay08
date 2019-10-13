package cn.kgc.tangcco.tcbd1016.lihaozhe.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {
	@Test
	public void test01() {
		byte a = 1;
		short b = 2;
		int c = 3;
		long d = 4;
		double db = 5.0;
		float f = 6.0f;
		char ch = 'c';
		boolean flag = true;
		List list = new ArrayList();
		// 利用该集合的对象调用add方法
		list.add("string");
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(db);
		list.add(f);
		list.add(ch);
		list.add(flag);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void test02() {
		byte a = 1;
		short b = 2;
		int c = 3;
		long d = 4;
		double db = 5.0;
		float f = 6.0f;
		char ch = 'c';
		boolean flag = true;
		// jdk8+ 利用构造方法
		List list = new ArrayList() {
			{
				add("string");
				add(a);
				add(b);
				add(c);
				add(d);
				add(db);
				add(f);
				add(ch);
				add(flag);
			}
		};

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void test03() {
		List list01 = new ArrayList();
		List list02 = new ArrayList();
		for (int i = 0; i < 5; i++) {
			list01.add(i);
		}
		for (int i = 5; i < 10; i++) {
			list02.add(i);
		}
		if (list01.addAll(list02)) {
			for (int i = 0; i < list01.size(); i++) {
				System.out.println(list01.get(i));
			}
		}
		System.out.println("程序运行结束");
	}

	@Test
	public void test04() {
		List list01 = new ArrayList();
		for (int i = 0; i < 10; i++) {
			list01.add(i);
		}
		for (int i = 0; i < list01.size(); i++) {
			System.out.println(list01.get(i));
		}
		System.out.println("程序运行结束");
	}
	@Test
	public void test05() {
		List list01 = new ArrayList();
		for (int i = 0; i < 10; i++) {
			list01.add(i);
		}
		for (Object object : list01) {
			System.out.println(object);
		}
		System.out.println("程序运行结束");
	}
	@Test
	public void test06() {
		// 泛型在此处限定了集合存储的数据类型
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		// list.add(1.0);
		System.out.println("程序运行结束");
	}
	@Test
	public void test07() {
		List<Integer> list01 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list01.add(i);
		}
		for (Integer integer : list01) {
			System.out.println(integer);
		}
		System.out.println("程序运行结束");
	}
	@Test
	public void test08() {
		List<Integer> list01 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list01.add(i);
		}
		Iterator<Integer> it = list01.listIterator();
		while (it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
		}
		System.out.println("程序运行结束");
	}
	@Test
	public void test09() {
		List<Integer> list01 = new ArrayList<Integer>();
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
}
