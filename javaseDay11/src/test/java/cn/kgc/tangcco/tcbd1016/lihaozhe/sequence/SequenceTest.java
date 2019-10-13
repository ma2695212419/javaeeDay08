package cn.kgc.tangcco.tcbd1016.lihaozhe.sequence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import org.junit.Test;

public class SequenceTest {
	/**
	 * 利用集合将两个文件的内容存储在集合中，然后再将集合中的数据写入新文件，以此达到文件合并的目的
	 */
	@Test
	public void test01() {
		InputStream input = null;
		OutputStream output = null;
		try {
			List<InputStream> list = new ArrayList<InputStream>();
			input = new FileInputStream("aa.txt");
			list.add(input);
			input = new FileInputStream("bb.txt");
			list.add(input);
			output = new FileOutputStream("cc.txt", true);
			ListIterator<InputStream> it = list.listIterator();
			while (it.hasNext()) {
				input = it.next();
				int read = -1;
				while ((read = input.read()) != -1) {
					output.write(read);
				}
				output.write("\n".getBytes());
				output.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test02() {
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new SequenceInputStream(new FileInputStream("aa.txt"), new FileInputStream("bb.txt"));
			int read = -1;
			output = new FileOutputStream("dd.txt", true);
			while ((read = input.read()) != -1) {
				output.write(read);
			}
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test03() {
		InputStream input = null;
		OutputStream output = null;
		try {
			Vector<InputStream> vector = new Vector<InputStream>();
			vector.add(new FileInputStream("aa.txt"));
			vector.add(new FileInputStream("bb.txt"));
			vector.add(new FileInputStream("cc.txt"));
			vector.add(new FileInputStream("dd.txt"));
			Enumeration<InputStream> elements = vector.elements();
			input = new SequenceInputStream(elements);
			int read = -1;
			output = new FileOutputStream("ee.txt", true);
			while ((read = input.read()) != -1) {
				output.write(read);
			}
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
