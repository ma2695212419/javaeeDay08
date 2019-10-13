package cn.kgc.tangcco.tcbd1016.lihaozhe.path;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
 * @author 李昊哲
 * @version 1.0 创建时间： 2019年6月28日 上午11:41:37
 */
public class PathTest {
	@Test
	public void test01() {
		// 创建Path对象
		// Path path = Paths.get(URI uri);
		// File file = new File(string)；
		/**
		 * 定义一个绝对目录 一个绝对目录就是包含了根目录然后接下来几层子目录最后是文件名或是最后一层的目录。 get()方法也支持把路径分割成一块一块的。
		 */
		Path path1 = Paths.get("/media/kgc/b7a840d2-e548-4290-ae81-3345edad8d18/tangcco/opt/eclipse/eclipse");
		Path path2 = Paths.get("/media/kgc/b7a840d2-e548-4290-ae81-3345edad8d18/tangcco/opt/eclipse", "eclipse");
		Path path3 = Paths.get("/media/kgc", "b7a840d2-e548-4290-ae81-3345edad8d18", "tangcco/opt/eclipse", "eclipse");

		/**
		 * 定义一个相对于根路径的相对路径 相对路径是全路径的一部分，相对路径通常用在创建web 页面中。 相对路径要比绝对路径用的更加广泛。
		 * 在当前路径下保存一个相对路径通常要加上文件分隔符。
		 */
		Path path4 = Paths.get("src/main/resources/database.properties");
		Path path5 = Paths.get("src/main/resources", "database.properties");
		Path path6 = Paths.get("src", "main", "resources", "database.properties");
		/**
		 * 定义一个相对于工作目录的相对路径,不用使用文件分隔符作为开始
		 */
		Path path7 = Paths.get("src/main/resources/database.properties");
		Path path8 = Paths.get("src/main/resources", "database.properties");

		/**
		 * 定义一个从URI获取的路径 在一些情况下，你需要从URI中创建一个路径， 你可以使用URI.create() 方法根据指定的字符串从URI中创建路径。
		 */
		URI create = URI.create("file:///media/kgc/b7a840d2-e548-4290-ae81-3345edad8d18/tangcco/opt/eclipse/eclipse");
		Path path9 = Paths.get(create);
		/**
		 * 用FileSystems.getDefault().getPath(String first, String... more) 方法来定义一个Path类。
		 */
		Path path10 = FileSystems.getDefault().getPath("src/main/resources", "database.properties");
		Path path13 = FileSystems.getDefault().getPath("src/main/./resources", "database.properties").normalize();

		/**
		 * 获取系统的主目录的路径
		 */
		Path path14 = Paths.get(System.getProperty("user.home"));
		System.out.println("14 = " + path14);
		/**
		 * 获取路径的信息 当你定义完Path对象后，接下来会有一系列的方法用来访问文件的信息。
		 */

		// 首先定义一个Path实例：
		Path path15 = Paths.get("src", "main", "resources", "database.properties");
//		// 获取文件或目录的名字：
//		// output: database.properties
		System.out.println("The file/directory indicated by path: " + path15.getFileName());
		// 获取根目录
		// output: /
		System.out.println("Root of this path: " + path1.getRoot());
		// 获取路径的父目录

		// output: src/main/resources
		System.out.println("Parent: " + path15.getParent());
		// 获取路径名的元素

		// 你可以使用 getNameCount()方法获取路径层级的个数，
		// 然后再使用getName()循环遍历每个元素的名字。
		// output: 4
		System.out.println("Number of name elements in path: " + path15.getNameCount());
		// output: rafaelnadal tournaments 2009 BNP.txt
		for (int i = 0; i < path15.getNameCount(); i++) {
			System.out.println("Name element " + i + " is: " + path15.getName(i));
		}
		// 获取子路径

		// output: rafaelnadal\tournaments\2009
		System.out.println("Subpath (0,3): " + path1.subpath(0, 3));

		Path absolute = Paths.get("/media/kgc/b7a840d2-e548-4290-ae81-3345edad8d18/tangcco/opt/eclipse", "eclipse");
		absolute = Paths.get("first", "more");
		System.out.println(absolute);
		Path relative = Paths.get("src", "main", "resources", "database.properties");
	}

	@Test
	public void test02() {
		// Path的转换

		// 将一个Path对象转换成字符串，URI，绝对路径，相对路径以及File对象。

		// 先定义一个Path实例：
		Path path = Paths.get("src/main/resources", "database.properties");

		// 转化成一个字符串
		// output: src/main/resources/database.properties
		String path_to_string = path.toString();
		System.out.println("Path to String: " + path_to_string);

		// 转换成一个URI
		// output:
		// file:///media/kgc/b7a840d2-e548-4290-ae81-3345edad8d18/tangcco/code/eclipse-workspace/javaseDay12/src/main/resources/database.properties
		URI path_to_uri = path.toUri();
		System.out.println("Path to URI: " + path_to_uri);
		// 由相对路径转换成绝对路径
		// output:
		// /media/kgc/b7a840d2-e548-4290-ae81-3345edad8d18/tangcco/code/eclipse-workspace/javaseDay12/src/main/resources/database.properties
		Path path_to_absolute_path = path.toAbsolutePath();
		System.out.println("Path to absolute path: " + path_to_absolute_path.toString());

		// 转换成现有文件的实际路径
		// 复制代码
		// output:
		// /media/kgc/b7a840d2-e548-4290-ae81-3345edad8d18/tangcco/code/eclipse-workspace/javaseDay12/src/main/resources/database.properties
		try {
			Path real_path = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
			System.out.println("Path to real path: " + real_path);
		} catch (NoSuchFileException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}

		// 复制代码
		// 转换成File对象
		File path_to_file = path.toFile();
		Path file_to_path = path_to_file.toPath();
		// Path to file name: database.properties
		System.out.println("Path to file name: " + path_to_file.getName());
		// File to path: src/main/resources/database.properties
		System.out.println("File to path: " + file_to_path.toString());
	}

	@Test
	public void test03() {
		// 合并两个路径
		// 合并两个路径的技术允许你先定义一个固定的根目录然后再附上局部的路径，
		// 在NIO.2 中，使用resolve() 方法来实现这一功能。

		// 复制代码
		// define the fixed path
		Path base = Paths.get("src/main/resources");

		// resolve database.properties file
		Path path_1 = base.resolve("database.properties");
		// output: src/main/resources/database.properties
		System.out.println(path_1.toString());

		// 复制代码
		// 还有一个方法用于兄弟路径，叫resolveSibling()，它会根据给定的路径去替换当前的路径。

		// 复制代码
		// define the fixed path
		Path base1 = Paths.get("src");

		// resolve sibling database.properties file
		Path path = base1.resolveSibling("aa.txt");
		// output: aa.txt
		System.out.println(path.toString());
	}

	@Test
	public void test04() {
		// 在两个位置中构造一个路径

		// 当你需要构造从一个位置到另一个位置的路径的时候，你可以使用relativize()方法。直接上代码。

		Path path01 = Paths.get("aa.txt");
		Path path02 = Paths.get("bb.txt");
		// 在这种情况下，可以假设这两个txt文件在同一层目录下，这就意味着你你可以从一个文件导航到另一个文件根据目录的层级。

		// 复制代码
		// output: ../bbtxt
		Path path01_to_path02 = path01.relativize(path02);
		System.out.println(path01_to_path02);

		// output: ..//aa.txt
		Path path02_to_path01 = path02.relativize(path01);
		// System.out.println(path02_to_path01);
		// 复制代码
		// 另一种情况是两个文件不在同一层的目录中，考虑下面的这个情况：

		Path path011 = Paths.get("src/main/resources/database.properties");
		Path path021 = Paths.get("aa.txt");
		// 这两个路径都有一个共同的根元素：/， 从path01 导航到
		// path02，你需要向上两个目录层级然后再向下一个层级(..\..\2011)。从path02导航到path01，你需要向上一个层级然后向下两个层级，relativize()方法就是这样做的。

		// 复制代码
		// output: ..\..\2011
		Path path011_to_path021 = path011.relativize(path021);
		System.out.println(path011_to_path021);

		// output: ..\2009\BNP.txt
		Path path021_to_path011 = path02.relativize(path011);
		System.out.println(path021_to_path011);
		// 复制代码
		// 注意，如果只有一个path包含根元素，那么相对路径是不能构造的，必保证两个path包含根元素。即使这样，相对路径的构造是依赖于系统的。
	}

	@Test
	public void test05() {
		// 比较两个路径

		// 两个路径是否相等可以通过不同的方式和目的去测试。你可以使用 Path.equals()方法，这个方法并不直接访问文件系统，所以没有强制要求文件必须存在，

		// 也不会检查两个文件是否是同一个文件。在有的系统中，路径的比较会忽略大小写，有的则是大小写敏感的。下面的代码中表示的是同一个文件，但是并不相等。

		// 复制代码
		Path path01 = Paths.get("src/main/resources/database.properties");
		Path path02 = Paths.get("database.properties");

		if (path01.equals(path02)) {
			System.out.println("The paths are equal!");
		} else {
			System.out.println("The paths are not equal!"); // true
		}
		// 复制代码
		// 有时候你想检查两个路径是否是同一个目录和文件，你可以很容易地使用java.nio.File.Files.isSameFile()方法，要注意，要保证路径是真实存在。

		// 复制代码
		try {
			boolean check = Files.isSameFile(path01, path02);
			if (check) {
				System.out.println("The paths locate the same file!"); // true
			} else {
				System.out.println("The paths does not locate the same file!");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// 复制代码
		// 因为Path实现了Comparable接口，所以你可以使用 compareTo()方法对路径进行比较，根据字典顺序进行比较。

		// output: 24
		int compare = path01.compareTo(path02);
		System.out.println(compare);
		// 还可以进行局部路径的比较。

		boolean sw = path01.startsWith("src");
		boolean ew = path01.endsWith("database.properties");
		// boolean ew = path01.endsWith("properties");
		// output: true
		System.out.println(sw);
		// output: true
		System.out.println(ew);
	}

	@Test
	public void test06() {
		// 遍历路径元素的名称

		// 因为Path实现了Iterable接口，所以你可以得到一个对象然后新型循环遍历一个路径的信息。请看下面的代码。

		Path path = Paths.get("src", "main/java", "database.properties");

		for (Path name : path) {
			System.out.println(name);
		}
	}
}
