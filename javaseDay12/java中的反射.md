---
typora-root-url: java中的反射
typora-copy-images-to: java中的反射
---

# java中的反射

------

主要介绍以下几方面内容

- 理解 Class 类
- 理解 Java 的类加载机制
- 学会使用 ClassLoader 进行类加载
- 理解反射的机制
- 掌握 Constructor、Method、Field 类的用法
- 理解并掌握代理模式
  - JDK代理
    - 静态代理
    - 动态代理
  - cglib代理

1. 理解Class类

   –对象照镜子后可以得到的信息：某个类的数据成员名、方法和构造器、某个类到底实现了哪些接口。对于每个类		而言，JRE 都为其保留一个不变的 Class 类型的对象。一个 Class 对象包含了特定某个类的有关信息。
   –Class 对象只能由系统建立对象
   –一个类在 JVM 中只会有一个Class实例
   –每个类的实例都会记得自己是由哪个 Class 实例所生成

   ![1557208439043](/1557208439043.png)

   1.1	Class是什么？Class这个类封装了什么信息？

   - Class是一个类，封装了当前对象所对应的类的信息
   -  一个类中有属性，方法，构造器等，比如说有一个Person类，一个Boy类，一个Girl类，这些都是不同的类，现在需要一个类，用来描述类，这就是Class，它应该有类名，属性，方法，构造器等。Class是用来描述类的类
   - Class类对象是一个类照镜子的结果，对象可以看到自己有哪些属性，方法，构造器，实现了哪些接口等等

   1.2	对于每个类而言，JRE 都为其保留一个不变的 C.lass 类型的对象。 Class 对象包含了特定某个类的有关信息。 

   1.3	Class 对象只能由系统建立对象，一个类（而不是一个对象）在 JVM 中只会有一个Class实例

   1.4	对象为什么需要照镜子呢？

      - 有可能这个对象是别人传过来的
      - 有可能没有对象，只有一个全类名 
      - 通过反射，可以得到这个类里面的信息

2. 获取Class对象的三种方式
   1.1通过类名获取      类名.class    

   1.2.通过对象获取      对象名.getClass()

   1.3.通过全类名获取    Class.forName(全类名)

3. Class类的常用方法

     | 方法名                            | 功能说明                                                     |
     | --------------------------------- | ------------------------------------------------------------ |
     | static Class forName(String name) | 返回指定类名 name 的 Class 对象                              |
     | Object newInstance()              | 调用缺省构造函数，返回该Class对象的一个实例                  |
     | Object newInstance(Object []args) | 调用当前格式构造函数，返回该Class对象的一个实例              |
     | getName()                         | 返回此Class对象所表示的实体（类、接口、数组类、基本类型或void）名称 |
     | Class getSuperClass()             | 返回当前Class对象的父类的Class对象                           |
     | Class [] getInterfaces()          | 获取当前Class对象的接口                                      |
     | ClassLoader getClassLoader()      | 返回该类的类加载器                                           |
     | Class getSuperclass()             | 返回表示此Class所表示的实体的超类的Class                     |

4. ClassLoader

     类装载器是用来把类(class)装载进 JVM 的。JVM 规范定义了两种类型的类装载器：启动类装载器(bootstrap)和用户自定义装载器(user-defined class loader)。 JVM在运行时会产生3个类加载器组成的初始化加载器层次结构 ，如下图所示：

     ![181711178455.jpg](/181711178455.jpg)

     

5. 