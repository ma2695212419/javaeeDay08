package cn.kgc.tangcco.tcbd1016.lihaozhe.cleasloader;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Person;

public class ClassLoaderTest {
	@Test
	public void test01(){
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader);
		System.out.println(systemClassLoader.getParent());
		System.out.println(systemClassLoader.getParent().getParent());
	}
	@Test
	public void test02() {
		Class<Person> clazz = Person.class;
		System.out.println(clazz);
	}
	@Test
	public void test03() {
		Person person = new Person("李鸿章");
		System.out.println(person.getClass());
	}
	@Test
	public void test04() throws ClassNotFoundException {
		Class<Person> clazz = (Class<Person>) Class.forName("cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Person");
		// System.out.println(clazz);
	}
}
