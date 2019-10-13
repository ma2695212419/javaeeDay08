package cn.kgc.tangcco.tcbd1016.lihaozhe.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

public class OutputStreamTest {
	@Test
	public void test01() {
		String message = "abcd";
		try {
			OutputStream os = new FileOutputStream("pom.pom");
			os.write(message.getBytes());
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		try {
			InputStream is = new FileInputStream("pom.xml");
			OutputStream os = new FileOutputStream("xml.xml");
			int read = is.read();
			while (read != -1) {
				os.write(read);
				read = is.read();
			}
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test03() {
		try {
			InputStream is = new FileInputStream("pom.xml");
			OutputStream os = new FileOutputStream("xml.xml");
			int read = -1;
			while ((read = is.read()) != -1) {
				os.write(read);
			}
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test04() {
		String message = "abcd";
		byte[] bytes = message.getBytes();
		try {
			OutputStream os = new FileOutputStream("pom.pom");
			os.write(bytes, 1, 2);
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test05() {
		String message = "abcd";
		byte[] bytes = message.getBytes();
		try {
			OutputStream os = new FileOutputStream(new File("pom.pom"), true);
			os.write(bytes, 1, 2);
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
