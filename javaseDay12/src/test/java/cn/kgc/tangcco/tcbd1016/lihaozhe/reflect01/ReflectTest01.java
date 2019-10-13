package cn.kgc.tangcco.tcbd1016.lihaozhe.reflect01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Person;

public class ReflectTest01 {
	@Test
	public void test01() {
		Person person = new Person("李鸿章");
		System.out.println(person.getName());
	}

	@Test
	public void test02() throws InstantiationException, IllegalAccessException {
		Class<Person> clazz = Person.class;
		Person person = clazz.newInstance();
		person.setName("李昊哲");
		System.out.println(person.getName());
	}

	@Test
	public void test03() {
		Class<Person> clazz = Person.class;
		Constructor<Person> constructor;
		try {
			// 获取构造器
			constructor = clazz.getDeclaredConstructor();
			// 允许访问private修饰方法
			constructor.setAccessible(true);
			// 利用构造器将该类实例化
			Person person = constructor.newInstance();
			person.setName("李昊哲");
			System.out.println(person.getName());
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test04() {
		Class<Person> clazz = Person.class;
		Constructor<?>[] constructors;
		try {
			// 获取构造器
			constructors = clazz.getDeclaredConstructors();
			System.out.println(constructors.length);
		} catch (SecurityException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test05() {
		Class<Person> clazz = Person.class;
		try {
			Method method = clazz.getMethod("haha");
			method.invoke(clazz);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test06() {
		Method method;
		try {
			Class<Person> clazz = (Class<Person>) Class.forName("cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Person");
			method = clazz.getMethod("haha");
			method.invoke(clazz);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test07() {
		Person person;
		try {
			Class<Person> clazz = (Class<Person>) Class.forName("cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Person");
			Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor();
			declaredConstructor.setAccessible(true);
			person = declaredConstructor.newInstance();
			Method method = clazz.getMethod("hehe");
			method.invoke(person);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| ClassNotFoundException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
