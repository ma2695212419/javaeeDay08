package cn.kgc.tangcco.tcbd1016.lihaozhe.bufferedstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

public class InputStreamAndOutputSteamTest {
	@Test
	public void test01() {
		InputStream in = null;
		InputStream bis = null;
		OutputStream out = null;
		OutputStream bos = null;
		
		try {
			in = new FileInputStream("C:/setup/jdk-8u221-windows-x64.exe");
			out = new FileOutputStream("C:/setup/jdk.exe");
			bis = new BufferedInputStream(in);
			bos = new BufferedOutputStream(out);
			System.out.println("正在复制，请稍后...");
			long startTime = System.currentTimeMillis();
			int b = -1;
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
			bos.flush();
			long endTime = System.currentTimeMillis();
			System.out.println("复制成功，耗时>>>" + (endTime - startTime) + "毫秒");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
