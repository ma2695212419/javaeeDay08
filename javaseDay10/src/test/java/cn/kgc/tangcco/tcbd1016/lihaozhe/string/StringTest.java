package cn.kgc.tangcco.tcbd1016.lihaozhe.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.junit.Test;

public class StringTest {
	@Test
	public void test01(){
		String str01 = "教育改变生活";
		byte[] bytes = str01.getBytes();
		String str02 = new String(bytes);
		System.out.println(str02);
	}
	@Test
	public void test02(){
		System.out.println(Charset.defaultCharset());
		String str01 = "教育改变生活";
		Charset.forName("GBK");
		System.out.println(Charset.defaultCharset());
	}
	@Test
	public void test03(){
		String str01 = "教育改变生活";
		byte[] bytes = str01.getBytes(Charset.forName("GBK"));
		String str02 = new String(bytes);
		System.out.println(str02);
	}
	@Test
	public void test04(){
		String str01 = "教育改变生活";
		byte[] bytes = null;
		try {
			bytes = str01.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str02 = new String(bytes);
		System.out.println(str02);
	}
	@Test
	public void test05(){
		String str01 = "教育改变生活";
		byte[] bytes = null;
		try {
			bytes = str01.getBytes("GBK");
			String str02 = new String(bytes, "GBK");
			System.out.println(str02);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
