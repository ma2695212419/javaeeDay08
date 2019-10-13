package cn.kgc.tangcco.tcbd1016.lihaozhe.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class InputSteamTest {
	@Test
	public void test01() {
		// 1. 找到目标文件
		File file = new File("pom.txt");
		// 2. 建立数据的输入通道。
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			// 3. 读取文件中的数据。
			int read = is.read();
			System.out.println(read);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 4. 关闭 资源.
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test02() {
		// 1. 找到目标文件
		File file = new File("pom.txt");
		// 2. 建立数据的输入通道。
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			// 3. 读取文件中的数据。
			int read = is.read();
			System.out.println((char)read);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 4. 关闭 资源.
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test03() {
		// 1. 找到目标文件
		File file = new File("pom.xml");
		// 2. 建立数据的输入通道。
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			// 3. 读取文件中的数据。
			int read = -1;
			while ((read = is.read()) != -1) {
				System.out.print((char)read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 4. 关闭 资源.
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test04() {
		// 1. 找到目标文件
		File file = new File("pom.xml");
		// 2. 建立数据的输入通道。
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			// 3. 读取文件中的数据。
			int read = -1;
			while ((read = is.read()) != -1) {
				System.out.print((char)read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
