package cn.kgc.tangcco.tcbd1016.lihaozhe.charstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

public class ConvertTest {
	@Test
	public void test01() {
		InputStream is = null;
		Reader in = null;
		Reader reader = null;
		OutputStream os =null;
		Writer out = null;
		Writer writer = null;
		try {
			is = new FileInputStream("pom.xml");
			os = new FileOutputStream("pom.txt");
			in = new InputStreamReader(is);
			out = new OutputStreamWriter(os);
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

	@Test
	public void test02() {
		InputStream is = null;
		Reader in = null;
		BufferedReader reader = null;
		OutputStream os =null;
		Writer out = null;
		Writer writer = null;
		try {
			is = new FileInputStream("pom.xml");
			os = new FileOutputStream("pom.txt");
			in = new InputStreamReader(is);
			out = new OutputStreamWriter(os);
			reader = new BufferedReader(in);
			writer = new BufferedWriter(out);
			String str = null;
			while ((str = reader.readLine()) != null) {
				writer.write(str + "\n");
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test03() {
		InputStream is = null;
		Reader in = null;
		BufferedReader reader = null;
		OutputStream os =null;
		Writer out = null;
		Writer writer = null;
		try {
			is = new FileInputStream("gbk.txt");
			os = new FileOutputStream("utf8.txt");
			in = new InputStreamReader(is, "gbk");
			// out = new OutputStreamWriter(os, "utf-8");
			out = new OutputStreamWriter(os);
			reader = new BufferedReader(in);
			writer = new BufferedWriter(out);
			String str = null;
			while ((str = reader.readLine()) != null) {
				writer.write(str + "\n");
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test04() {
		InputStream is = null;
		Reader in = null;
		BufferedReader reader = null;
		OutputStream os =null;
		Writer out = null;
		Writer writer = null;
		try {
			is = new FileInputStream("utf8.txt");
			os = new FileOutputStream("newgbk.txt");
			in = new InputStreamReader(is);
			out = new OutputStreamWriter(os,"gbk");
			reader = new BufferedReader(in);
			writer = new BufferedWriter(out);
			String str = null;
			while ((str = reader.readLine()) != null) {
				writer.write(str + "\n");
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
