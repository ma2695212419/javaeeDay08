package cn.kgc.tangcco.tcbd1016.commons.uuid;

import org.junit.Test;

public class BaseUUIDTest {
	@Test
	public void test01() {
		for (int i = 0; i < 100; i++) {
			System.out.println(BaseUUID.generate());
		}
	}
}
