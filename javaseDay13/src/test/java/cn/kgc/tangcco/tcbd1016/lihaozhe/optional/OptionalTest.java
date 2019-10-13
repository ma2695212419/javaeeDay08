package cn.kgc.tangcco.tcbd1016.lihaozhe.optional;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {
	@Test
	public void test01() {
		Optional<String> ofNullable = Optional.ofNullable("abc");
		String orElse = ofNullable.orElse("haha");
		System.out.println(orElse);
	}
	@Test
	public void test02() {
		Optional<String> ofNullable = Optional.ofNullable(null);
		String orElse = ofNullable.orElse("haha");
		System.out.println(orElse);
	}
}
