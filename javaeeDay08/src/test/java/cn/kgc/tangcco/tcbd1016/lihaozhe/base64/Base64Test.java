package cn.kgc.tangcco.tcbd1016.lihaozhe.base64;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.junit.Test;

public class Base64Test {
	@Test
	public void test01() {
		// 获取Encoder对象
		Encoder encoder = Base64.getEncoder();
		// 获取加密后的字符串
		String encodeToString = encoder.encodeToString("admin".getBytes());
		System.out.println(encodeToString);
		// 获取Decoder对象
		Decoder decoder = Base64.getDecoder();
		// 解密
		byte[] decode = decoder.decode(encodeToString);
		System.out.println(new String(decode));
	}
}
