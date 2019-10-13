package cn.kgc.tangcco.tcbd1016.lihaozhe.charstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

public class ReaderAndWriterTest {
	@Test
	public void test01() {
		Reader reader = null;
		Writer writer = null;
		try {
			reader = new FileReader("pom.xml");
			writer = new FileWriter("pom.txt");
			int b = -1;
			while ((b = reader.read()) != -1) {
				writer.write(b);
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		Reader in = null;
		Reader reader = null;
		Writer out = null;
		Writer writer = null;
		try {
			in = new FileReader("pom.xml");
			out = new FileWriter("pom.txt");
			reader = new BufferedReader(in);
			writer = new BufferedWriter(out);
			int b = -1;
			while ((b = reader.read()) != -1) {
				writer.write(b);
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
