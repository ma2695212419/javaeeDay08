package cn.kgc.tangcco.tcbd1016.lihaozhe.commonsio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.junit.Test;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月29日 上午9:19:43
 */
public class CommonsioTest {
	@Test
	public void test01() {
		// 获取文件的扩展名。
		String str = FilenameUtils.getExtension("aa/bb/aa.txt");
		System.out.println(str);
	}

	@Test
	public void test02() {
		// 获取文件的文件名。
		String str = FilenameUtils.getName("aa/bb/aa.txt");
		System.out.println(str);
		str = FilenameUtils.getName("aa/bb");
		System.out.println(str);
	}

	@Test
	public void test03() {
		// 判断filename是不是以extension为后缀。
		boolean b = FilenameUtils.isExtension("aa/bb/aa.txt", "txt");
		// true
		System.out.println(b);
		b = FilenameUtils.isExtension("aa/bb/aa.txt", "xt");
		// false
		System.out.println(b);
	}

	@Test
	public void test04() {
		// 计算文件大小。
		long size = FileUtils.sizeOf(new File("aa/bb/aa.txt"));
		System.out.println(size);
		long sizeOfDirectory = FileUtils.sizeOfDirectory(new File("aa"));
		System.out.println(sizeOfDirectory);
	}

	@Test
	public void test05() {
		File f = new File("aa");
		// 查看文件。
		// 过滤文件
		// EmptyFileFilter.NOT_EMPTY过滤器
		Collection<File> files = FileUtils.listFiles(f, EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("******************");
		// 操作文件
		// DirectoryFileFilter.INSTANCE 下级文件
		files = FileUtils.listFiles(f, EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		/**
		 * 查看后缀名为java的文件
		 */
		System.out.println("**********************************");
		files = FileUtils.listFiles(f, new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		/**
		 * 可以同时查看class和java的文件 FileFilterUtils 判断条件
		 */
		System.out.println("**********************************");
		files = FileUtils.listFiles(f, FileFilterUtils.or(new SuffixFileFilter("java"), new SuffixFileFilter("class")),
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}

	@Test
	public void test06() throws IOException {
		// 读取文件
		File file = new File("pom.txt");
		String str = FileUtils.readFileToString(file);
		System.out.println(str);
		byte[] b = FileUtils.readFileToByteArray(file);
		System.out.println(b.length);
		// 逐行读取
		List<String> list = FileUtils.readLines(file);
		Iterator<String> iterator = list.listIterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		System.out.println("****************************");
		LineIterator it = FileUtils.lineIterator(file);
		while (it.hasNext()) {
			String string = (String) it.next();
			System.out.println(string);
		}
	}

	@Test
	public void test07() throws IOException {
		// 写出文件
		File file = new File("b.txt");
		FileUtils.write(file, "bbbbbbbbbbb");
		FileUtils.writeStringToFile(new File("b.txt"), "ccccccc", true);
		FileUtils.writeByteArrayToFile(file, "aaaaaaaaaa".getBytes(), true);
		// 写出列表
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		// FileUtils.writeLines(new File("c.txt"), list, "...", true);
		// 第三个位置为连接符
		FileUtils.writeLines(new File("c.txt"), list, "...", true);
	}
	@Test
	public void test08() throws IOException {
		FileUtils.copyFile(new File("pom.txt"), new File("pom.pom"));
		//拷贝文件到目录
		FileUtils.copyFileToDirectory(new File("b.txt"), new File("aa/cc"));
		//拷贝目录到目录,成为该目录的子目录
		FileUtils.copyDirectoryToDirectory(new File("aa/bb"), new File("aa/cc"));
		//拷贝目录，将目录中的文件拷贝出来
		FileUtils.copyDirectory(new File("aa/bb"), new File("aa/dd"));
	}
}
