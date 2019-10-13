package cn.kgc.tangcco.tcbd1016.lihaozhe.charstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.junit.Test;

public class WriterTest {
	@Test
	public void test01() {
		String message = "教育改变生活";
		Writer writer = null;
		try {
			writer = new FileWriter("message.txt");
			writer.write(message);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
