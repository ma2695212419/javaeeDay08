package cn.kgc.tangcco.tcbd1016.lihaozhe.reflect01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Person;

public class ReflectTest02 {
	@Test
	public void test01() {
		Class<Person> clazz = Person.class;
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}
	}
	@Test
	public void test02() {
		Class<Person> clazz = Person.class;
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}
	}
	@Test
	public void test03() {
		Class<Person> clazz = Person.class;
		try {
			Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor();
			declaredConstructor.setAccessible(true);
			Person person = declaredConstructor.newInstance();
			Field declaredField = clazz.getDeclaredField("name");
			declaredField.setAccessible(true);
			declaredField.set(person, "李鸿章");
			System.out.println(declaredField.get(person));
		} catch (NoSuchFieldException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
