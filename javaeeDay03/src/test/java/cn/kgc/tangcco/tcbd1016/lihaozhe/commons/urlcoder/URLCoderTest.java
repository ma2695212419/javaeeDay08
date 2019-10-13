package cn.kgc.tangcco.tcbd1016.lihaozhe.commons.urlcoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

public class URLCoderTest {
	@Test
	public void test01() throws UnsupportedEncodingException {
		String encode = URLEncoder.encode("李昊哲", "utf-8");
		System.out.println(encode);
		String decode = URLDecoder.decode(encode, "utf-8");
		System.out.println(decode);
	}
}
