# **Path**

------

#### 	路径隶属于文件系统，实际上它是存储和组织媒体文件的格式，通常在一块或多块硬盘设备上，以便于非常容易地检索。文件系统可以通过  `java.nio.file.FileSystems 这个final 类来访问，通常我们用来获取它的实例然后做我们想做的事情。FileSystems 包含下面两个非常重要的方法，还有 newFileSystem() 方法，用来构建一个新的文件系统实例。`

> - ####  getDefault(): 这个静态方法会返回一个默认的FileSystem 给 JVM——通常是操作系统默认的文件系统。
>
> - #### getFileSystem(URI uri): 这个静态方法根据提供的可以匹配 URI 模式的一系列可用的文件系统提供者中返回一个文件系统。Path类可以操作任何类型的文件系统并可以使用任何存储的地方（java.nio.file.FileStore这个类会呈现潜在的存储）。通常情况下，Path类指向默认的操作系统的文件，但是在 NIO.2 中 彻底模块化了—— 可以是内存中数据，在互联网上，在虚拟文件系统的FileSystem 类的实现，这些都可以都可以完美的被NIO.2接受，NIO.2 提供了所有文件系统的功能，我们需要执行在文件，目录或是一个link 链接文件上。

### 　　Path类实际上是java.io.File类的升级版本，但是File类有一些特定的操作，所以File类不要被认为是过时的类，也不要把他当作一个障碍。此外，在JDK1.7以上，这两个类都是可以继续使用，这就意味着可以混合使用这两个类来获取最佳的 API 操作。 JDK1.7以上提供了非常简单的API 方便这两者的互相转换。

在以前IO操作都是这样写的。

```Java
import java.io.File;
…
File file = new File("index.html");
```

　但在JDK1.7 以上，我们可以这样写：

```Java
import java.nio.file.Path;
import java.nio.file.Paths;
…
Path path = Paths.get("index.html");
```

​	一个 Path 类 是一个路径在文件系统中的程序表示。Path基本上就是一个文件路径的字符串，实际的引用的资源可以不存在。

​	一旦你确定了文件系统和文件或是目录的存储的地方，你就可以创建一个Path实例。绝对路径，相对路径，使用“.”定义的当前路径以及“..” 定义的父级路径，路径中包含一个文件或是目录名字，这些都可以用Path类来搞定。最简单办法是使用Paths帮助类来调用get() 方法。下面的例子演示了使用同一路径定义path的几种不同的方法。

定义一个绝对目录

　　一个绝对目录就是包含了根目录然后接下来几层子目录最后是文件名或是最后一层的目录。你可以使用下面代码来定义一个绝对目录Path类。

```Java
Path path = Paths.get("C:/rafaelnadal/tournaments/2009/BNP.txt");
```

　　get()方法也支持把路径分割成一块一块的。NIO会重新组织路径。

```Java
Path path = Paths.get("C:/rafaelnadal/tournaments/2009", "BNP.txt");
Path path = Paths.get("C:", "rafaelnadal/tournaments/2009", "BNP.txt");
Path path = Paths.get("C:", "rafaelnadal", "tournaments", "2009", "BNP.txt");
```

　　定义一个相对于根路径的相对路径

　　相对路径是全路径的一部分，相对路径通常用在创建web 页面中。相对路径要比绝对路径用的更加广泛。在当前路径下保存一个相对路径通常要加上文件分隔符。例如，如果当前路径是C盘，则绝对路径应该是：`C:\rafaelnadal\tournaments\2009\BNP.txt`:

```Java
Path path = Paths.get("/rafaelnadal/tournaments/2009/BNP.txt");
Path path = Paths.get("/rafaelnadal","tournaments/2009/BNP.txt");
```

 　　定义一个相对于工作目录的相对路径

　　当你定义一个相对于当前工作目录的路径，这个路径就不用使用文件分隔符作为开始。例如向前目录是相对于根目录C盘下的/ATP目录，则根据下面的代码返回绝对路径是：`C:\ATP\rafaelnadal\tournaments\2009\BNP.txt`:

```Java
Path path = Paths.get("rafaelnadal/tournaments/2009/BNP.txt");
Path path = Paths.get("rafaelnadal","tournaments/2009/BNP.txt"); 
```

　　定义一个从URI获取的路径

　　在一些情况下，你需要从URI中创建一个路径，你可以使用URI.create() 方法根据指定的字符串从URI中创建路径。

```Java
import java.net.URI;
 …
 Path path = Paths.get(URI.create("file:///rafaelnadal/tournaments/2009/BNP.txt"));
 Path path = Paths.get(URI.create("file:///C:/rafaelnadal/tournaments/2009/BNP.txt")); 
```

　　你也可以使用FileSystems.getDefault().getPath() 方法来定义一个Path类。

```Java
import java.nio.file.FileSystems;
 …
 Path path = FileSystems.getDefault().getPath("/rafaelnadal/tournaments/2009", "BNP.txt");
 Path path = FileSystems.getDefault().getPath("/rafaelnadal/tournaments/2009/BNP.txt");
 Path path = FileSystems.getDefault().getPath("rafaelnadal/tournaments/2009", "BNP.txt");
 Path path = FileSystems.getDefault().
                         getPath("/rafaelnadal/tournaments/./2009","BNP.txt").normalize();
```

　　获取系统的主目录的路径

　　当你想获取主目录的路径时，可以使用下面的代码：

```Java
Path path = Paths.get(System.getProperty("user.home"), "downloads", "game.exe");
```

​	返回的路径是`C:\Users\{your user name}\downloads\game.exe，在Linux系统中，则返回/home/{your user name}/downloads/game.exe。`

　　----------------------------------------------------------------------------------------------------------------------------

　　获取路径的信息

　　当你定义完Path对象后，接下来会有一系列的方法用来访问文件的信息。首先定义一个Path实例：

```Java
Path path = Paths.get("C:", "rafaelnadal/tournaments/2009", "BNP.txt");
```

　　获取文件或目录的名字：

```Java
//output: BNP.txt
 System.out.println("The file/directory indicated by path: " + path.getFileName()); 
```

　　获取根目录

```Java
//output: C:\
 System.out.println("Root of this path: " + path.getRoot()); 
```

　　获取路径的父目录

```
//output: C:\rafaelnadal\tournaments\2009
 System.out.println("Parent: " + path.getParent());
```

　　获取路径名的元素

　　你可以使用 `getNameCount()方法获取路径层级的个数，然后再使用getName()循环遍历每个元素的名字。`

```Java
//output: 4
 System.out.println("Number of name elements in path: " + path.getNameCount());
 
//output: rafaelnadal  tournaments  2009  BNP.txt
 for (int i = 0; i < path.getNameCount(); i++) {
   System.out.println("Name element " + i + " is: " + path.getName(i));
 }
```

　　获取子路径

```Java
//output: rafaelnadal\tournaments\2009
 System.out.println("Subpath (0,3): " + path.subpath(0, 3)); 
```

　　--------------------------------------------------------------------------------------------------------------------------

　　Path的转换

　　在这节中，将会介绍怎样由一个Path对象转换成字符串，URI，绝对路径，相对路径以及File对象。

　　先定义一个Path实例：

```Java
Path path = Paths.get("/rafaelnadal/tournaments/2009", "BNP.txt");
```

　　转化成一个字符串

```Java
//output: \rafaelnadal\tournaments\2009\BNP.txt
 String path_to_string = path.toString();
 System.out.println("Path to String: " + path_to_string);
```

　　转换成一个URI

```Java
//output: file:///C:/rafaelnadal/tournaments/2009/BNP.txt
 URI path_to_uri = path.toUri();
 System.out.println("Path to URI: " + path_to_uri); 
```

　　由相对路径转换成绝对路径

```Java
//output: C:\rafaelnadal\tournaments\2009\BNP.txt
 Path path_to_absolute_path = path.toAbsolutePath();
 System.out.println("Path to absolute path: " + path_to_absolute_path.toString()); 
```

　　转换成真实路径

```Java
import java.io.IOException;
 …
 //output: C:\rafaelnadal\tournaments\2009\BNP.txt
 try {
     Path real_path = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
     System.out.println("Path to real path: " + real_path);
 } catch (NoSuchFileException e) {
     System.err.println(e);
 } catch (IOException e) {
     System.err.println(e);
 }
```

　　转换成File对象

```Java
//output: BNP.txt
 File path_to_file = path.toFile();
 
//output: \rafaelnadal\tournaments\2009\BNP.txt
 Path file_to_path = path_to_file.toPath();
 System.out.println("Path to file name: " + path_to_file.getName());
 System.out.println("File to path: " + file_to_path.toString()); 
```

　　--------------------------------------------------------------------------------------------------------------------------

　　合并两个路径

　　合并两个路径的技术允许你先定义一个固定的根目录然后再附上局部的路径，在NIO.2 中，使用resolve() 方法来实现这一功能。

```Java
//define the fixed path
 Path base = Paths.get("C:/rafaelnadal/tournaments/2009");
 
//resolve BNP.txt file
 Path path_1 = base.resolve("BNP.txt");
 //output: C:\rafaelnadal\tournaments\2009\BNP.txt
 System.out.println(path_1.toString());
 
//resolve AEGON.txt file
 Path path_2 = base.resolve("AEGON.txt");
 //output: C:\rafaelnadal\tournaments\2009\AEGON.txt
 System.out.println(path_2.toString());
```

　　还有一个方法用于兄弟路径，叫`resolveSibling()，它会根据给定的路径去替换当前的路径。`

```Java
//define the fixed path
 Path base = Paths.get("C:/rafaelnadal/tournaments/2009/BNP.txt");
 
//resolve sibling AEGON.txt file
 Path path = base.resolveSibling("AEGON.txt");
 //output: C:\rafaelnadal\tournaments\2009\AEGON.txt
 System.out.println(path.toString());
```

　　--------------------------------------------------------------------------------------------------------------------------------

　　在两个位置中构造一个路径

　　当你需要构造从一个位置到另一个位置的路径的时候，你可以使用`relativize()方法。直接上代码。`

```Java
Path path01 = Paths.get("BNP.txt");
Path path02 = Paths.get("AEGON.txt"); 
```

　　在这种情况下，可以假设这两个txt文件在同一层目录下，这就意味着你你可以从一个文件导航到另一个文件根据目录的层级。

```Java
//output:  ..\AEGON.txt
 Path path01_to_path02 = path01.relativize(path02);
 System.out.println(path01_to_path02);
 
//output:  ..\BNP.txt
 Path path02_to_path01 = path02.relativize(path01);
 System.out.println(path02_to_path01);
```

　　另一种情况是两个文件不在同一层的目录中，考虑下面的这个情况：

```Java
Path path01 = Paths.get("/tournaments/2009/BNP.txt");
Path path02 = Paths.get("/tournaments/2011");
```

　　这两个路径都有一个共同的根元素：`/tournaments， 从path01 导航到 path02，你需要向上两个目录层级然后再向下一个层级(..\..\2011)。从path02导航到path01，你需要向上一个层级然后向下两个层级，relativize()方法就是这样做的。`

```Java
//output:  ..\..\2011
 Path path01_to_path02 = path01.relativize(path02);
 System.out.println(path01_to_path02);
 
//output:  ..\2009\BNP.txt
 Path path02_to_path01 = path02.relativize(path01);
 System.out.println(path02_to_path01);
```

　　注意，如果只有一个path包含根元素，那么相对路径是不能构造的，必保证两个path包含根元素。即使这样，相对路径的构造是依赖于系统的。

　　-----------------------------------------------------------------------------------------------------------------------------------

　　比较两个路径

　　两个路径是否相等可以通过不同的方式和目的去测试。你可以使用 `Path.equals()方法，这个方法并不直接访问文件系统，所以没有强制要求文件必须存在，`

也不会检查两个文件是否是同一个文件。在有的系统中，路径的比较会忽略大小写，有的则是大小写敏感的。下面的代码中表示的是同一个文件，但是并不相等。

```Java
Path path01 = Paths.get("/rafaelnadal/tournaments/2009/BNP.txt");
Path path02 = Paths.get("C:/rafaelnadal/tournaments/2009/BNP.txt");
 
if(path01.equals(path02)){
     System.out.println("The paths are equal!");
 } else {
     System.out.println("The paths are not equal!"); //true
 }
```

　　有时候你想检查两个路径是否是同一个目录和文件，你可以很容易地使用`java.nio.File.Files.isSameFile()方法，要注意，要保证路径是真实存在。`

```Java
try {
     boolean check = Files.isSameFile(path01, path02);
     if(check){
         System.out.println("The paths locate the same file!"); //true
     } else {
         System.out.println("The paths does not locate the same file!");
     }
 } catch (IOException e) {
     System.out.println(e.getMessage());
 }
```

 　　因为Path实现了`Comparable接口，所以你可以使用 compareTo()方法对路径进行比较，根据字典顺序进行比较。`

```Java
//output: 24
 int compare = path01.compareTo(path02);
 System.out.println(compare); 
```

　　还可以进行局部路径的比较。

```Java
boolean sw = path01.startsWith("/rafaelnadal/tournaments");
boolean ew = path01.endsWith("BNP.txt");
System.out.println(sw);  //output:  true
System.out.println(ew);  //output:  true 
```

　　------------------------------------------------------------------------------------------------------------------------------

　　遍历路径元素的名称

　　因为Path实现了`Iterable接口，所以你可以得到一个对象然后新型循环遍历一个路径的信息。请看下面的代码。`

```Java
Path path = Paths.get("C:", "rafaelnadal/tournaments/2009", "BNP.txt");
 
for (Path name : path) {
     System.out.println(name);
 }
```

　　输出结构如下所示：

　　`rafaelnadal　　tournaments　　2009　　BNP.txt`