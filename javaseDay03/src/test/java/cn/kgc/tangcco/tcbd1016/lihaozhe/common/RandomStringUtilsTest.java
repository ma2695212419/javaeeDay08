package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

import org.junit.Test;

public class RandomStringUtilsTest {
	@Test
	public void random() {
		String random;
		for (int i = 0; i < 1000; i++) {
			random = RandomStringUtils.random(6);
			System.out.println(random);
		}
	}
}
