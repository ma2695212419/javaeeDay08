package cn.kgc.tangcco.tcbd1016.lihaozhe.charstream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Test;

public class ReaderTest {
	@Test
	public void test01() {
		Reader reader = null;
		try {
			reader = new FileReader("pom.xml");
			int b = -1;
			while ((b = reader.read()) != -1) {
				System.out.print((char)b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
