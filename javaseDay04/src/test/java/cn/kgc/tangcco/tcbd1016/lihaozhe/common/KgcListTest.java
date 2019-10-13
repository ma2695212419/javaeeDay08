package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

import org.junit.Test;

public class KgcListTest {
	@Test
	public void test01() {
		KgcList kgcList = new KgcList();
		for (int i = 0; i < 20; i++) {
			kgcList.add(i);
		}
		System.out.println(kgcList.size());
	}
	@Test
	public void test02() {
		KgcList kgcList = new KgcList();
		for (int i = 0; i < 20; i++) {
			kgcList.add(i);
		}
		System.out.println(kgcList.get(15));
	}
	@Test
	public void test03() {
		KgcList kgcList = new KgcList();
		for (int i = 0; i < 20; i++) {
			kgcList.add(i);
		}
		for (int i = 0; i < kgcList.size(); i++) {
			System.out.println(kgcList.get(i));
		}
	}
	@Test
	public void test04() {
		KgcList kgcList = new KgcList();
		for (int i = 0; i < 20; i++) {
			kgcList.add(i);
		}
		System.out.println("删除数据前的容量>>>" + kgcList.size());
		kgcList.remove(19);
		System.out.println("删除数据后的容量>>>" + kgcList.size());
		for (int i = 0; i < kgcList.size(); i++) {
			System.out.println(kgcList.get(i));
		}
	}
	@Test
	public void test05() {
		KgcList kgcList = new KgcList();
		for (int i = 0; i < 20; i++) {
			kgcList.add(i);
		}
		kgcList.set(10, "我爱你中国");
		for (int i = 0; i < kgcList.size(); i++) {
			System.out.println(kgcList.get(i));
		}
	}
}
