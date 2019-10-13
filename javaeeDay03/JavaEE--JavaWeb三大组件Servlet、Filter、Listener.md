# [JavaEE--JavaWeb三大组件Servlet、Filter、Listener](https://www.cnblogs.com/tag6254/p/9407156.html)



　　Servlet、Filter、Listener是JavaEE Web服务规定的服务器动态组件，由开发者编写由Web容器创建，并保证单例以及线程安全性，其中加载顺序为Linstener -> Fliter -> Servlet，与它们在web.xml中配置的顺序没有关系，<xx-mapping>的配置顺序会影响到url在某一类组件的过滤顺序。

## 一、**Servlet** 

　　Servlet是用来处理客户端请求的动态资源，也就是当我们在浏览器中键入一个地址回车跳转后，请求就会被发送到对应的Servlet上进行处理。它是一个POJO类，在web容器的管理下实现对web请求的处理与分发。 

**1.Servlet的任务**

①接收请求数据：我们都知道客户端请求会被封装成HttpServletRequest对象，里面包含了请求头、参数等各种信息。

②处理请求：通常我们会在service、doPost或者doGet方法进行接收参数，并且调用业务层（service）的方法来处理请求。

③完成响应：处理完请求后，我们一般会转发（forward）或者重定向（redirect）到某个页面，转发是HttpServletRequest中的方法，重定向是HttpServletResponse中的方法，两者是有很大区别的。

**2.Servlet的特性**

　　Servlet可以在第一次接收请求(访问该Servlet的映射名)时被创建，也可以在服务器启动时就被创建，这需要在web.xml的<servlet>标签中添加一条配置信息 <load-on-startup>5</load-on-startup>，当值为0或者大于0时，表示容器在应用启动时就加载这个servlet，当是一个负数时或者没有指定时，则指示容器在该servlet被请求时才加载。

　　对于Servlet来说它既是一个java类也是CGI(通用网关接口)，面向浏览器时它属于CGI，专长于处理浏览器请求数据，完全由服务器掌控，在服务器内部只允许一个对外的Servlet实例，并且服务器会通过手段来保证面向外界的Servlet是单例的！但不保证线程安全！Servlet面向JVM内部类似于普通java类，可以被多次实例化！服务器不保证此类情况的Servlet单实例。

**3.Servlet的生命周期方法**

- void init(ServletConfig)

　　servlet的初始化方法，只在创建servlet实例时候调用一次，Servlet是单例的，整个服务器就只创建一个同类型Servlet

- void service(ServletRequest,ServletResponse)

　　servlet的处理请求方法，在servle被请求时，会被马上调用，每处理一次请求，就会被调用一次。ServletRequest类为请求类，ServletResponse类为响应类

- void destory()

　　servlet销毁之前执行的方法，只执行一次，用于释放servlet占有的资源，通常Servlet是没什么可要释放的，所以该方法一般都是空的

**4.Servlet的其他重要方法**

- ServletConfig getServletConfig()

　　获取servlet的配置信息的方法，所谓的配置信息就是WEB-INF目录下的web.xml中的servlet标签里面的信息

- String getServletInfo()

　　获取servlet的信息方法

### **5.Servlet的配置**

```xml
  <context-param>
  	<param-name>db</param-name>
  	<param-value>mysql</param-value>
  </context-param>
  
  <servlet>
  	<servlet-name>ConfigInfo</servlet-name>
  	<servlet-class>cn.kgc.tangcco.tcbd1013.lihaozhe.config.ConfigInfo</servlet-class>
  	<init-param>
  		<param-name>slogan</param-name>
  		<param-value>love and peace</param-value>
  	</init-param>
  	  </servlet>
  <servlet-mapping>
  	<servlet-name>ConfigInfo</servlet-name>
  	<url-pattern>/configInfo.action</url-pattern>
  </servlet-mapping>
  <servlet>
  	<servlet-name>Startup01</servlet-name>
  	<servlet-class>cn.kgc.tangcco.tcbd1013.lihaozhe.startup.Startup01</servlet-class>
	<!-- 只能写在最后一行 -->
	<load-on-startup>10</load-on-startup>
  	  </servlet>
  <servlet-mapping>
  	<servlet-name>Startup01</servlet-name>
  	<url-pattern>/startup01.action</url-pattern>
  </servlet-mapping>
  <servlet>
  	<servlet-name>Startup02</servlet-name>
  	<servlet-class>cn.kgc.tangcco.tcbd1013.lihaozhe.startup.Startup02</servlet-class>
	<!-- 只能写在最后一行 -->
	<load-on-startup>10</load-on-startup>
  	  </servlet>
  <servlet-mapping>
  	<servlet-name>Startup02</servlet-name>
  	<url-pattern>/startup02.action</url-pattern>
  </servlet-mapping>
  <servlet>
  	<servlet-name>Startup03</servlet-name>
  	<servlet-class>cn.kgc.tangcco.tcbd1013.lihaozhe.startup.Startup03</servlet-class>
	<!-- 只能写在最后一行 -->
	<load-on-startup>9</load-on-startup>
  	  </servlet>
  <servlet-mapping>
  	<servlet-name>Startup03</servlet-name>
  	<url-pattern>/startup03.action</url-pattern>
  </servlet-mapping>
```

## **二、Fliter**

　　Filter与Servlet在很多的方面极其相似，但是也有不同，例如Filter和Servlet一样都又三个生命周期方法，同时他们在web.xml中的配置文件也是差不多的、 但是Servlet主要负责处理请求，而Filter主要负责拦截请求，和放行。Filter实际上是一个接口，定义了一套规则，等待具体的类来实现该接口，而具体的拦截操作还需要web容器来实现。

### **1.Filter四种拦截方式**

①REQUEST：直接访问目标资源时执行过滤器。包括：在地址栏中直接访问、表单提交、超链接、重定向，只要在地址栏中可以看到目标资源的路径，就是REQUEST；

②FORWARD：转发访问执行过滤器。包括RequestDispatcher#forward()方法、<jsp:forward>标签都是转发访问；

③INCLUDE：包含访问执行过滤器。包括RequestDispatcher#include()方法、<jsp:include>标签都是包含访问；

④ERROR：当目标资源在web.xml中配置为<error-page>中时，并且真的出现了异常，转发到目标资源时，会执行过滤器。

### **2.url-mapping的写法**

　　匹配规则有三种：

- 精确匹配 —— 如/foo.htm，只会匹配foo.htm这个URL
- 路径匹配 —— 如/foo/*，会匹配以foo为前缀的URL
- 后缀匹配 —— 如*.htm，会匹配所有以.htm为后缀的URL
- <url-pattern>的其他写法，如/foo/ ，/.htm ，/foo 都是不对的。

### **3.执行filter的顺序**

　　 如果有多个过滤器都匹配该请求，顺序决定于web.xml filter-mapping的顺序，在前面的先执行，后面的后执行

## **三、Listener**

　　Listener就是监听器，我们在JavaSE开发或者Android开发时，经常会给按钮加监听器，当点击这个按钮就会触发监听事件，调用onClick方法，本质是方法回调。在JavaWeb的Listener也是这么个原理，但是它监听的内容不同，它可以监听Application、Session、Request对象，当这些对象发生变化就会调用对应的监听方法。Listener与Filter一样同样是一个接口，定义了监听的规则，等待实现类实现该接口，而具体的监听事务完全由web容器实现。

### **1.ServletContext（监听Application）**

①生命周期监听：ServletContextListener，它有两个方法，一个在出生时调用，一个在死亡时调用；

- void contextInitialized(ServletContextEvent sce)：创建Servletcontext时
- void contextDestroyed(ServletContextEvent sce)：销毁Servletcontext时

②属性监听：ServletContextAttributeListener，它有三个方法，一个在添加属性时调用，一个在替换属性时调用，最后一个是在移除属性时调用。

- void attributeAdded(ServletContextAttributeEvent event)：添加属性时；
- void attributeReplaced(ServletContextAttributeEvent event)：替换属性时；
- void attributeRemoved(ServletContextAttributeEvent event)：移除属性时；

### **2.HttpSession（监听Session）**

①生命周期监听：HttpSessionListener，它有两个方法，一个在出生时调用，一个在死亡时调用；

- void sessionCreated(HttpSessionEvent se)：创建session时
- void sessionDestroyed(HttpSessionEvent se)：销毁session时

②属性监听：HttpSessioniAttributeListener，它有三个方法，一个在添加属性时调用，一个在替换属性时调用，最后一个是在移除属性时调用。

- void attributeAdded(HttpSessionBindingEvent event)：添加属性时；
- void attributeReplaced(HttpSessionBindingEvent event)：替换属性时
- void attributeRemoved(HttpSessionBindingEvent event)：移除属性时

### **3.ServletRequest（监听Request）**

①生命周期监听：ServletRequestListener，它有两个方法，一个在出生时调用，一个在死亡时调用；

- void requestInitialized(ServletRequestEvent sre)：创建request时
- void requestDestroyed(ServletRequestEvent sre)：销毁request时

②属性监听：ServletRequestAttributeListener，它有三个方法，一个在添加属性时调用，一个在替换属性时调用，最后一个是在移除属性时调用。

- void attributeAdded(ServletRequestAttributeEvent srae)：添加属性时
- void attributeReplaced(ServletRequestAttributeEvent srae)：替换属性时
- void attributeRemoved(ServletRequestAttributeEvent srae)：移除属性时

### **4.感知Session监听**

①HttpSessionBindingListener监听

- 在需要监听的实体类实现HttpSessionBindingListener接口
- 重写valueBound()方法，这方法是在当该实体类被放到Session中时，触发该方法
- 重写valueUnbound()方法，这方法是在当该实体类从Session中被移除时，触发该方法

②HttpSessionActivationListener监听

- 在需要监听的实体类实现HttpSessionActivationListener接口
- 重写sessionWillPassivate()方法，这方法是在当该实体类被序列化时，触发该方法
- 重写sessionDidActivate()方法，这方法是在当该实体类被反序列化时，触发该方法

### 5.application与web三大组件加载以及初始化的关系

　　在一个web应用程序中假定实现了所有的配置，服务器启动时首先要加载的是web.xml文件，从中确定整个web应用的基本配置。整个web.xml加载过程以及服务器对象创建过程如下：

1. 启动一个WEB项目的时候,容器(如:Tomcat)会去读它的配置文件web.xml.读两个节点: <listener></listener> 和 <context-param></context-param>(具体先读哪个，尚不可知)。

2. 紧接着,容器创建一个ServletContext(application),这个WEB项目所有部分都将共享这个上下文，它标识一个web应用，首先在堆中分配空间，但尚未初始化。

3. 容器将<context-param></context-param>转化为键值对,并交给ServletContext。

4. 容器创建<listener></listener>中的类实例，并绑定需要监听的事件，对于application、session的创建来说，监听的是他们的init方法，类似于类的构造器方法，它为整个对象进行属性初始化。

5. 容器创建过滤器实例开启对url进行过滤。

6. 容器创建Servlet实例。**二、Fliter**

   　　Filter与Servlet在很多的方面极其相似，但是也有不同，例如Filter和Servlet一样都又三个生命周期方法，同时他们在web.xml中的配置文件也是差不多的、 但是Servlet主要负责处理请求，而Filter主要负责拦截请求，和放行。Filter实际上是一个接口，定义了一套规则，等待具体的类来实现该接口，而具体的拦截操作还需要web容器来实现。

   ### **1.Filter四种拦截方式**

   ①REQUEST：直接访问目标资源时执行过滤器。包括：在地址栏中直接访问、表单提交、超链接、重定向，只要在地址栏中可以看到目标资源的路径，就是REQUEST；

   ②FORWARD：转发访问执行过滤器。包括RequestDispatcher#forward()方法、<jsp:forward>标签都是转发访问；

   ③INCLUDE：包含访问执行过滤器。包括RequestDispatcher#include()方法、<jsp:include>标签都是包含访问；

   ④ERROR：当目标资源在web.xml中配置为<error-page>中时，并且真的出现了异常，转发到目标资源时，会执行过滤器。

   ### **2.url-mapping的写法**

   　　匹配规则有三种：

   - 精确匹配 —— 如/foo.htm，只会匹配foo.htm这个URL
   - 路径匹配 —— 如/foo/*，会匹配以foo为前缀的URL
   - 后缀匹配 —— 如*.htm，会匹配所有以.htm为后缀的URL
   - <url-pattern>的其他写法，如/foo/ ，/.htm ，/foo 都是不对的。

   ### **3.执行filter的顺序**

   　　 如果有多个过滤器都匹配该请求，顺序决定于web.xml filter-mapping的顺序，在前面的先执行，后面的后执行

   ## **三、Listener**

   　　Listener就是监听器，我们在JavaSE开发或者Android开发时，经常会给按钮加监听器，当点击这个按钮就会触发监听事件，调用onClick方法，本质是方法回调。在JavaWeb的Listener也是这么个原理，但是它监听的内容不同，它可以监听Application、Session、Request对象，当这些对象发生变化就会调用对应的监听方法。Listener与Filter一样同样是一个接口，定义了监听的规则，等待实现类实现该接口，而具体的监听事务完全由web容器实现。

   ### **1.ServletContext（监听Application）**

   ①生命周期监听：ServletContextListener，它有两个方法，一个在出生时调用，一个在死亡时调用；

   - void contextInitialized(ServletContextEvent sce)：创建Servletcontext时
   - void contextDestroyed(ServletContextEvent sce)：销毁Servletcontext时

   ②属性监听：ServletContextAttributeListener，它有三个方法，一个在添加属性时调用，一个在替换属性时调用，最后一个是在移除属性时调用。

   - void attributeAdded(ServletContextAttributeEvent event)：添加属性时；
   - void attributeReplaced(ServletContextAttributeEvent event)：替换属性时；
   - void attributeRemoved(ServletContextAttributeEvent event)：移除属性时；

   ### **2.HttpSession（监听Session）**

   ①生命周期监听：HttpSessionListener，它有两个方法，一个在出生时调用，一个在死亡时调用；

   - void sessionCreated(HttpSessionEvent se)：创建session时
   - void sessionDestroyed(HttpSessionEvent se)：销毁session时

   ②属性监听：HttpSessioniAttributeListener，它有三个方法，一个在添加属性时调用，一个在替换属性时调用，最后一个是在移除属性时调用。

   - void attributeAdded(HttpSessionBindingEvent event)：添加属性时；
   - void attributeReplaced(HttpSessionBindingEvent event)：替换属性时
   - void attributeRemoved(HttpSessionBindingEvent event)：移除属性时

   ### **3.ServletRequest（监听Request）**

   ①生命周期监听：ServletRequestListener，它有两个方法，一个在出生时调用，一个在死亡时调用；

   - void requestInitialized(ServletRequestEvent sre)：创建request时
   - void requestDestroyed(ServletRequestEvent sre)：销毁request时

   ②属性监听：ServletRequestAttributeListener，它有三个方法，一个在添加属性时调用，一个在替换属性时调用，最后一个是在移除属性时调用。

   - void attributeAdded(ServletRequestAttributeEvent srae)：添加属性时
   - void attributeReplaced(ServletRequestAttributeEvent srae)：替换属性时
   - void attributeRemoved(ServletRequestAttributeEvent srae)：移除属性时

   ### **4.感知Session监听**

   ①HttpSessionBindingListener监听

   - 在需要监听的实体类实现HttpSessionBindingListener接口
   - 重写valueBound()方法，这方法是在当该实体类被放到Session中时，触发该方法
   - 重写valueUnbound()方法，这方法是在当该实体类从Session中被移除时，触发该方法

   ②HttpSessionActivationListener监听

   - 在需要监听的实体类实现HttpSessionActivationListener接口
   - 重写sessionWillPassivate()方法，这方法是在当该实体类被序列化时，触发该方法
   - 重写sessionDidActivate()方法，这方法是在当该实体类被反序列化时，触发该方法

   ### 5.application与web三大组件加载以及初始化的关系

   　　在一个web应用程序中假定实现了所有的配置，服务器启动时首先要加载的是web.xml文件，从中确定整个web应用的基本配置。整个web.xml加载过程以及服务器对象创建过程如下：

   1. 启动一个WEB项目的时候,容器(如:Tomcat)会去读它的配置文件web.xml.读两个节点: <listener></listener> 和 <context-param></context-param>(具体先读哪个，尚不可知)。
   2. 紧接着,容器创建一个ServletContext(application),这个WEB项目所有部分都将共享这个上下文，它标识一个web应用，首先在堆中分配空间，但尚未初始化。
   3. 容器将<context-param></context-param>转化为键值对,并交给ServletContext。
   4. 容器创建<listener></listener>中的类实例，并绑定需要监听的事件，对于application、session的创建来说，监听的是他们的init方法，类似于类的构造器方法，它为整个对象进行属性初始化。
   5. 容器创建过滤器实例开启对url进行过滤。
   6. 容器创建Servlet实例。