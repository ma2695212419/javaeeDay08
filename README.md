# TCBD1016

#### 介绍

课工场TCBD1016高级阶段课上代码

#### 课程架构
课程架构说明

#### JavaSE

```
java标识符及标识符命名规则
01. javaseDay01
	开发环境搭建
    maven项目
    junit
    javadoc
02. javaseDay02
	方法的重载
	面向对象复习之封装
		构造方法
		this关键字
	代码块、静态代码块
	面向对象复习之继承
		super关键字
		Object类	
	面向对象复习之多态
	抽象类	接口	 内部类
	lombok插件	
03. javaseDay03
	包装类
		包装类之Integer Character
	Arrays类
	System类
	String类
	Comparable接口
	StringBuilder类
04. javaseDay04
	数组复习
	独立编写
	copyOf(Object[] src, int newLength){}
	arrayCopy(Object[] src, int srcPos,Object[] dest, int destPos,int length){}
	使用arrayCopy方法实现copyOf方法 
	手写ArrayList并实现增、查
	单例模式
		恶汉单例模式
		懒汉单例模式
05. javaseDay05
	手写ArrayList并实现增、删、改、查
	ArrayList初体验并使用迭代器遍历集合
	LinkedList初体验、并阅读java8中LinkedList底层源码
	集合中泛型的作用
	在重载方法中使用集合作为参数的时候注意泛型的擦除
	Vector 线程安全的
	Comparable接口
	Set
		HashSet LinkedHashSet SortSet	TressSet 
06. javaseDay06
	Map 
		HashMap	 LinkedHashMap
		HashTable	线程安全的
	MVC编程模式
07. javaseDay07
	数据结构之枚举
	日期类之Date
	时间类之LocalDate LocalDateTime Time Instant 
	LocalDateTime工具类的封装
08. javaseDay08
	多线程初体验之Thread和Runnable
	线程类的常用方法
	synchronized
09. javaseDay09
	BIO
	文件类	字节流
10. javaseDay10
	BIO
	缓冲字节流 文件或目录的复制
11. javaseDay11
	SequenceInputStream
	NIO
	RandomAccessFile、Paths、Path、Files、commons-io
12. javaseDay12
	Files、commons-io、反射
	单例+工厂模式
13. javaseDay13
	项目流程 Optional 单例+工厂模式
14. javaseDay14
	xml dom4j初体验
	手写springIOC
15. javaseDay15
	Fastjson初体验
	json-lib、Jackson、Gson、Fastjson差异性简介
```

#### 关系型数据库之MySQL

```
01.	MySQL Day01
MySQL安装	MySQL DDL DML DCL
02.	MySQL Day02
DQL
03.	MySQL Day03
DQL
04.	MySQL Day04
视图 存储过程 触发器 事务
```

#### JDBC

```
01.	jdbc01 
	mysql5.x c3p0
02.	jdbc02 
	mysql8.x c3p0
	
JDBC API提供以下接口和类 -

    DriverManager：此类管理数据库驱动程序列表。 使用通信子协议将来自java应用程序的连接请求与适当的数据库驱动程序进行匹配。在JDBC下识别某个子协议的第一      个驱动程序将用于建立数据库连接。

    Driver：此接口处理与数据库服务器的通信。我们很少会直接与Driver对象进行交互。 但会使用DriverManager对象来管理这种类型的对象。 它还提取与使用Driver对象相关的信息。

    Connection：此接口具有用于联系数据库的所有方法。 连接(Connection)对象表示通信上下文，即，与数据库的所有通信仅通过连接对象。

    Statement：使用从此接口创建的对象将SQL语句提交到数据库。 除了执行存储过程之外，一些派生接口还接受参数。

    ResultSet：在使用Statement对象执行SQL查询后，这些对象保存从数据库检索的数据。 它作为一个迭代器并可移动ResultSet对象查询的数据。

    SQLException：此类处理数据库应用程序中发生的任何错误。


```

```
DiverManager.class里有个属性drivers，它实际上是一个vector（向量）。可在列表中加入很多驱动，当DriverManager去取连接的时候，若果drivers里有很多驱动，它会把drivers里面的各个驱动的url和创建连接时传进来的url逐一比较，遇到对应的url，则建立连接。 

注册驱动的三种方式： 

（一）DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
会造成DriverManager中产生两个一样的驱动，并会对具体的驱动类产生依赖。 
具体来说就是： 
1，加载的时候注册一次驱动（原因请看第三中注册方式），实例化的时候又注册一次。所以两次。 
2，由于实例化了com.mysql.jdbc.Driver.class，导致必须导入该类(就是要把这个类import进去)，从而具体驱动产生了依赖。不方便扩展代码。 

（二）System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver"); 

通过系统的属性设置注册驱动

如果要注册多个驱动，则System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver:com.oracle.jdbc.Driver"); 
虽然不会对具体的驱动类产生依赖；但注册不太方便，所以很少使用。 


（三）Class.forName("com.mysql.jdbc.Driver");

推荐这种方式，不会对具体的驱动类产生依赖（就是不用import package了）。 
其实这个只是把com.mysql.jdbc.Driver.class这个类装载进去，但是关键就在于，在 
这个类中，有个静态块，如下： 
static{ 
	try{ 
		java.sql.DriverManager.registerDriver(new Driver()); 
	}catch(SQLException e){ 
		throw new RuntimeException("can't register driver!"); 
	} 
} 
就是因为这个代码块，让类在加载的时候就把驱动注册进去了！
```
#### 连接池

```
DBCP 		开源免费	由Apache负责维护
c3p0		商用收费	几乎所有的持久层框架都支持
druid		附加监控	由阿里巴巴开发目前最好的国产数据库连接池
HikariCP	自称世界上最快的连接池 springboot默认使用
```
#### H5C3

```html

htmlDay01

sublime
visual studio code
hbuilder (eclipse+插件)

什么是 Viewport?
viewport 是用户网页的可视区域。

viewport 翻译为中文可以叫做"视区"。

手机浏览器是把页面放在一个虚拟的"窗口"（viewport）中，通常这个虚拟的"窗口"（viewport）比屏幕宽，这样就不用把每个网页挤到很小的窗口中（这样会破坏没有针对手机浏览器优化的网页的布局），用户可以通过平移和缩放来看网页的不同部分。

设置 Viewport
一个常用的针对移动网页优化过的页面的 viewport meta 标签大致如下：

<meta name="viewport" content="width=device-width, initial-scale=1.0">
width：控制 viewport 的大小，可以指定的一个值，如 600，或者特殊的值，如 device-width 为设备的宽度（单位为缩放为 100% 时的 CSS 的像素）。
height：和 width 相对应，指定高度。
initial-scale：初始缩放比例，也即是当页面第一次 load 的时候缩放比例。
maximum-scale：允许用户缩放到的最大比例。
minimum-scale：允许用户缩放到的最小比例。
user-scalable：用户是否可以手动缩放。

CSS 盒子模型(Box Model)
所有HTML元素可以看作盒子，在CSS中，"box model"这一术语是用来设计和布局时使用。

CSS盒模型本质上是一个盒子，封装周围的HTML元素，它包括：边距，边框，填充，和实际内容。

盒模型允许我们在其它元素和周围元素边框之间的空间放置元素。

CSS box-model
不同部分的说明：

Margin(外边距) - 清除边框外的区域，外边距是透明的。
Border(边框) - 围绕在内边距和内容外的边框。
Padding(内边距) - 清除内容周围的区域，内边距是透明的。
Content(内容) - 盒子的内容，显示文本和图像。

```

#### javaScript

```
01.	jsDay01 
	ecmaScrtpt5.1 json bom dom 
02.	jsDay02  
	ecmaScrtpt6.x
```

#### jQuery

```
jQueryDay01
	javascirpt之对象
	JSON.parse()、JSON.stringify()
	sessionStorage、localstorage、cookie
	使用jQuery.cookie.js和localstorage分别实现记住密码一分钟
jQueryDay02
	原生AJAX
	jQuery实现AJAX
```

#### javaEE

```
01. javaeeDay01
	开发环境搭建
    maven项目
    dynamic web project
    maven project
    jetty-maven-plugin
    tomcat7-maven-plugin
	maven热部署到远程tomcat服务器
	简单页面传值，实现登录功能
02. javaseDay02
	http协议
	Servlet生命周期
	ServletConfig
	ServletContext
	AJAX+JSON+Servlet+JDBC实现完整登录跳转页面并在前端页面传值
03. javaseDay03
	请求转发与网页重定向
	Context
	Session与Cookie
	Filter与Listener
04. javaseDay04
	BaseServlet封装
	JSP	JSTL
	一对多案列实现登录、注销功能
05. javaseDay05
	一对多案列使用EL表达式实现页面显示员工信息列表
06. javeeDay06
	一对多案列使用EL表达式实现删除员工、增加员工、显示单用户详细信息
07. javeeDay07
	使用token技术防止表单重复提交
	一对多案列使用EL表达式实现修改员工信息	
08. javeeDay08
	分页的实现	
09. javeeDay09
	按条件查询	
10.javeeDay10
	AJAX实现表单的异步验证
11.javeeDay11
	前后端分离思想
	前端使用JSONP处理AJAX跨域
	后端使用CORS处理AJAX跨域
	编写BaseServlet处理AJAX跨域并规避跨域产生的两次请求
12.javeeDay12
	Base64加密解密与图片处理
	使用Servlet3.x实现传统文件上传与下载
	使用FileUpload实现文件上传
13.javeeDay13
	使用FileUpload+FTP实现文件的上传
	使用nginx实现项目如何引入FTP上的图片文件
14.javeeDay14
	短信验证
15.javeeDay15
	支付宝扫码支付
16.javeeDay16
	百度echarts
14.javeeDay14
	百度地图
15.javeeDay15
	百度人工智能开发平台
16.javeeDay16
	百度人脸识别之页面摄像头获取图片
17.javeeDay17
	绑定百度人脸库
	
```


