package cn.kgc.tangcco.tcbd1016.lihaozhe.dom4j;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jParseTest {
	@Test
	public void test01() {
		SAXReader reader = new SAXReader();
		InputStream in = Dom4jParseTest.class.getClassLoader().getResourceAsStream("book_shop.xml");
		Document document;
		try {
			document = reader.read(in);
			// System.out.println(document);
			Element root = document.getRootElement();
			// System.out.println(root.getName());
			Iterator<Element> it = root.elementIterator();
			Element element = null;
			while (it.hasNext()) {
				element = it.next();
				System.out.print("编号 >>> " + element.attributeValue("id") + "\t");
				System.out.print("书名 >>> " + element.getStringValue().trim() + "\t");
				System.out.print("单价 >>> " + element.attributeValue("price") + "\n");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		SAXReader reader = new SAXReader();
		InputStream in = Dom4jParseTest.class.getClassLoader().getResourceAsStream("book_shop.xml");
		Document document;
		try {
			document = reader.read(in);
			List<Node> nodes = document.selectNodes("//books/book");
			ListIterator<Node> it = nodes.listIterator();
			Node node = null;
			while (it.hasNext()) {
				node = it.next();
				System.out.print("编号 >>> " + node.valueOf("@id") + "\t");
				System.out.print("书名 >>> " + node.getText().trim() + "\t");
				System.out.print("单价 >>> " + node.valueOf("@price") + "\n");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
