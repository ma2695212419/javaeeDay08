package cn.kgc.tangcco.tcbd1016.lihaozhe.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.junit.Test;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月29日 上午8:28:54
 */
public class FilesTest {
	@Test
	public void test01() {
		try {
			Path createFile = Files.createFile(Paths.get("aa.txt"));
			System.out.println(createFile.getFileName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		try {
			Path createDirectories = Files.createDirectories(Paths.get("aa/bb"));
			System.out.println(createDirectories.getFileName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test03() {
		try {
			Path move = Files.move(Paths.get("aa.txt"), Paths.get("aa/bb/aa.txt"));
			System.out.println(move.getFileName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test04() {
		try {
			Files.delete(Paths.get("aa/bb/aa.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test05() {
		try {
			Files.copy(Paths.get("pom.xml"), Paths.get("pom.txt"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test06() {
		try {
			Files.copy(Paths.get("aa/bb"), Paths.get("aa/cc"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test07() {
		// 将文件以字符串的形式读出
		byte[] bytes;
		try {
			bytes = Files.readAllBytes(Paths.get("pom.xml"));
			String content = new String(bytes);
			System.out.println(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test08() {
		// 将文件当作行序列读入
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get("pom.xml"));
			System.out.println(lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test09() {
		// 写出一个字符串到文件中
		try {
			Files.write(Paths.get("aa/bb/aa.txt"), "我爱你中国".getBytes("utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test10() {
		test09();
		// 向指定文件中追加内容 注:这里加上APPEND表示追加字符串
		try {
			Files.write(Paths.get("aa/bb/aa.txt"), "\n亲爱的母亲".getBytes("utf-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
