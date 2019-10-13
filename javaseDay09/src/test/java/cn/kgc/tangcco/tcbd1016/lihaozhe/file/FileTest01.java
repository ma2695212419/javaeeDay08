package cn.kgc.tangcco.tcbd1016.lihaozhe.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileTest01 {
	@Test
	public void test01() {
		// 相对路径
		File file = new File("pom.xml");
		// exists()方法判断文件是否存在
		System.out.println(file.exists());
	}

	@Test
	public void test02() {
		// 相对路径
		File file = new File("pom.txt");
		// exists()方法判断文件是否存在
		if (file.exists()) {
			System.out.println("文件已经存在，不能重复创建");
		} else {
			try {
				// createNewFile()创建空文件
				file.createNewFile();
				System.out.println(file.getName() + "文件创建成功");
			} catch (IOException e) {
				System.out.println(file.getName() + "文件创建失败，为什么呢");
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test03() {
		// 相对路径
		File file = new File("pom.txt");
		try {
			// createNewFile()创建空文件
			if (file.createNewFile()) {
				System.out.println(file.getName() + "文件创建成功");
			}
		} catch (IOException e) {
			System.out.println(file.getName() + "文件创建失败，为什么呢");
			e.printStackTrace();
		}
		System.out.println("程序运行结束");
	}

	@Test
	public void test04() {
		// 相对路径
		File file = new File("2019");
		if (file.exists()) {
			System.out.println("文件已存在，不能重复创建");
		} else {
			if (file.mkdir()) {
				System.out.println("创建成功");
			} else {
				System.out.println("创建失败");
			}
		}
		System.out.println("程序运行结束");
	}

	@Test
	public void test05() {
		// 相对路径
		File file = new File("2019");
		if (file.mkdir()) {
			System.out.println("创建成功");
		} else {
			System.out.println("创建失败");
		}
		System.out.println("程序运行结束");
	}

	@Test
	public void test06() {
		// 相对路径
		File file = new File("2019/08");
		if (file.mkdir()) {
			System.out.println("创建成功");
		} else {
			System.out.println("创建失败");
		}
		System.out.println("程序运行结束");
	}

	@Test
	public void test07() {
		// 相对路径
		File file = new File("2020/08");
		if (file.mkdir()) {
			System.out.println("创建成功");
		} else {
			System.out.println("创建失败");
		}
		System.out.println("程序运行结束");
	}

	@Test
	public void test08() {
		// 相对路径
		File file = new File("2021/08");
		if (file.mkdirs()) {
			System.out.println("创建成功");
		} else {
			System.out.println("创建失败");
		}
		System.out.println("程序运行结束");
	}

	@Test
	public void test09() {
		// 相对路径
		File file = new File("2022", "08");
		if (file.mkdirs()) {
			System.out.println("创建成功");
		} else {
			System.out.println("创建失败");
		}
		System.out.println("程序运行结束");
	}

	@Test
	public void test10() {
		// 相对路径
		File file = new File("2023" + File.separator + "08");
		if (file.mkdirs()) {
			System.out.println("创建成功");
			System.out.println(file.getName());
		} else {
			System.out.println("创建失败");
		}
		System.out.println("程序运行结束");
	}

	@Test
	public void test11() {
		// 相对路径
		File file = new File("2023" + File.separator + "08");
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println("程序运行结束");
	}
	@Test
	public void test12() {
		// 相对路径
		File file01 = new File("src");
		File file02 = new File("pom.xml");
		if (file01.exists() && file02.exists()) {
			// isDirectory判断是否是目录
			// isFile判断是否是文件
			// true
			System.out.println(file01.isDirectory());
			// false
			System.out.println(file02.isDirectory());
			// false
			System.out.println(file01.isFile());
			// true
			System.out.println(file02.isFile());
		}
		System.out.println("程序运行结束");
	}

	@Test
	public void test13() {
		// 相对路径
		File file = new File("2023/08");
		if (file.delete()) {
			System.out.println("删除成功");
		}
		System.out.println("程序运行结束");
	}
	@Test
	public void test14() {
		// 相对路径
		File file = new File("2022");
		// 删除文件和目录，ps:但是只能删除空目录
		if (file.delete()) {
			System.out.println("删除成功");
		}
		System.out.println("程序运行结束");
	}
	@Test
	public void test15() {
		// 相对路径
		File file = new File("pom.txt");
		// 只能删除空
		if (file.delete()) {
			System.out.println("删除成功");
		}
		System.out.println("程序运行结束");
	}
	@Test
	public void test16() {
		// 相对路径
		File file = new File("pom.txt");
		// 只能删除空
		if (file.renameTo(new File("pom.pom"))) {
			System.out.println(file.getName() + "修改成功");
		}
		System.out.println("程序运行结束");
	}
	@Test
	public void test17() {
		// 相对路径
		File file = new File("pom.pom");
		if (file.renameTo(new File("2022/08/pom.txt"))) {
			System.out.println(file.getName() + "修改成功");
		}
		System.out.println("程序运行结束");
	}
	@Test
	public void test18() {
		// 相对路径
		File file = new File("pom.txt");
		// 只能删除空
		if (file.renameTo(new File("2222/08/pom.txt"))) {
			System.out.println(file.getName() + "修改成功");
		}
		System.out.println("程序运行结束");
	}
	@Test
	public void test19() {
		// 相对路径
		File file = new File("2019");
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			System.out.println(file2.getAbsolutePath());
		}
	}
	@Test
	public void test20() {
		// 相对路径
		File file = new File("2019");
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			if (file2.isDirectory()) {
				System.out.println("目录>>>" + file2.getAbsolutePath());
			}else if (file2.isFile()) {
				System.out.println("文件>>>" + file2.getAbsolutePath());
			}
		}
	}
	@Test
	public void test21() {
		// 相对路径
		File file = new File("2019");
		if (file.delete()) {
			System.out.println("删除成功");
		}
		System.out.println("程序结束");
	}
}
