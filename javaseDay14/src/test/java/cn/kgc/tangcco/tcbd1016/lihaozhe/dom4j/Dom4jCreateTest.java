package cn.kgc.tangcco.tcbd1016.lihaozhe.dom4j;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Dom4jCreateTest {
	@Test
	public void test01() {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("books");

		Element book1 = root.addElement("book").addAttribute("id", "1").addAttribute("price", "50").addText("石榴树上结樱桃");
		Element book2 = root.addElement("book").addAttribute("id", "2").addAttribute("price", "35").addText("hello树先生");
		Element book3 = root.addElement("book").addAttribute("id", "3").addAttribute("price", "40").addText("浮城谜事");
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("src/main/resources/bs.xml");
			XMLWriter writer = new XMLWriter(fileWriter);
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("books");

		Element book1 = root.addElement("book").addAttribute("id", "1").addAttribute("price", "50").addText("石榴树上结樱桃");
		Element book2 = root.addElement("book").addAttribute("id", "2").addAttribute("price", "35").addText("hello树先生");
		Element book3 = root.addElement("book").addAttribute("id", "3").addAttribute("price", "40").addText("浮城谜事");
		FileWriter fileWriter;
		XMLWriter writer = null;
		try {
			fileWriter = new FileWriter("src/main/resources/bs.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			writer = new XMLWriter(fileWriter, format);
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test03() {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("books");
	
		Element book1 = root.addElement("book").addAttribute("id", "1").addAttribute("price", "50").addText("石榴树上结樱桃");
		Element book2 = root.addElement("book").addAttribute("id", "2").addAttribute("price", "35").addText("hello树先生");
		Element book3 = root.addElement("book").addAttribute("id", "3").addAttribute("price", "40").addText("浮城谜事");
		FileWriter fileWriter;
		XMLWriter writer = null;
		try {
			fileWriter = new FileWriter("src/main/resources/bs.xml");
			writer = new XMLWriter(fileWriter);
			OutputFormat format = OutputFormat.createCompactFormat();
			writer = new XMLWriter(fileWriter, format);
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
