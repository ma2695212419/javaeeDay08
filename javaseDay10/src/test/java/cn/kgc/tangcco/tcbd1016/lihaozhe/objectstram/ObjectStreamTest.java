package cn.kgc.tangcco.tcbd1016.lihaozhe.objectstram;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/*
对象的输入输出流 : 对象的输入输出流 主要的作用是用于写对象的信息与读取对象的信息。 对象信息一旦写到文件上那么对象的信息就可以做到持久化了

对象的输出流： ObjectOutputStream .

对象的输入流: ObjectInputStream 


ObjectOutputStream的使用步骤：
	1. 

对象输入输出流要注意的细节：
	1. 如果对象需要被写出到文件上，那么对象所属的类必须要实现Serializable接口。 Serializable接口没有任何的方法，是一个标识接口而已。
	2. 对象的反序列化创建对象的时候并不会调用到构造方法的、
	3. serialVersionUID 是用于记录class文件的版本信息的，serialVersionUID这个数字是通过一个类的类名、成员、包名、工程名算出的一个数字。
	4. 使用ObjectInputStream反序列化的时候，ObjeectInputStream会先读取文件中的serialVersionUID，然后与本地的class文件的serialVersionUID
	进行对比，如果这两个id不一致，那么反序列化就失败了。
	5. 如果序列化与反序列化的时候可能会修改类的成员，那么最好一开始就给这个类指定一个serialVersionUID，如果一类已经指定的serialVersionUID，然后
	在序列化与反序列化的时候，jvm都不会再自己算这个 class的serialVersionUID了。
	6. 如果一个对象某个数据不想被序列化到硬盘上，可以使用关键字transient修饰。
	7. 如果一个类维护了另外一个类的引用，那么另外一个类也需要实现Serializable接口。
	
*/
public class ObjectStreamTest {
	// 定义方法把对象的信息写到硬盘上------>对象的序列化。
	@Test
	public void writeObj() throws IOException {
		// 把对象的信息持久化存储。
		Address address = new Address("吉林省", "辽源市");
		Person person = new Person("李昊哲", 37, 1, address);
		// 找到目标文件
		File file = new File("obj.txt");
		// 建立数据输出流对象
		FileOutputStream out = new FileOutputStream(file);
		// 建立对象的输出流对象
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		// 把对象写出
		objectOutputStream.writeObject(person);
		// 关闭资源
		objectOutputStream.close();
		System.out.println("文件写入成功");
	}

	@Test
	public void readObj() throws IOException, ClassNotFoundException {
		File file = new File("obj.txt");
		FileInputStream in = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(in);
		Person person = (Person) objectInputStream.readObject();
		System.out.println("姓名>>>" + person.getName());
		System.out.println("年龄>>>" + person.getAge());
		System.out.println("性别>>>" + person.getGender());
		System.out.println("省>>>" + person.getAddress().getProvince());
		System.out.println("市>>>" + person.getAddress().getCity());
	}
}
