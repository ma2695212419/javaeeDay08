package cn.kgc.tangcco.tcbd1016.lihaozhe.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

public class InputStreamAndOutputSteamTest {
	@Test
	public void test01() {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("pom.xml");
			os = new FileOutputStream("xml.xml");
			System.out.println("正在复制，请稍后...");
			long startTime = System.currentTimeMillis();
			int b = -1;
			while ((b = is.read()) != -1) {
				os.write(b);
			}
			os.flush();
			long endTime = System.currentTimeMillis();
			System.out.println("复制成功，耗时>>>" + (endTime - startTime) + "毫秒");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test02() {
		InputStream is = null;
		OutputStream os = null;
		try {
			byte[] b = new byte[512];
			is = new FileInputStream("C:/setup/jdk-8u221-windows-x64.exe");
			os = new FileOutputStream("C:/setup/jdk.exe");
			System.out.println("正在复制，请稍后...");
			// int read = is.read(b);
			long startTime = System.currentTimeMillis();
			while (is.read(b) != -1) {
				os.write(b, 0, is.read());
			}
			os.flush();
			long endTime = System.currentTimeMillis();
			System.out.println("复制成功，耗时>>>" + (endTime - startTime) + "毫秒");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
