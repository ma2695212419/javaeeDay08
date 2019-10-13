package cn.kgc.tangcco.tcbd1016.lihaozhe.reflect01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Person;

public class ReflectTest03 {
	@Test
	public void test01() {
		Class<Person> clazz = Person.class;
		Constructor<Person> declaredConstructor;
		try {
			declaredConstructor = clazz.getDeclaredConstructor();
			declaredConstructor.setAccessible(true);
			Person person = declaredConstructor.newInstance();
			Method declaredMethod = clazz.getDeclaredMethod("sum", int.class,int.class);
			declaredMethod.setAccessible(true);
			int sum = (int) declaredMethod.invoke(person, 10, 20);
			System.out.println(sum);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test02() {
		Class<Person> clazz = Person.class;
		Constructor<Person> declaredConstructor;
		try {
			declaredConstructor = clazz.getDeclaredConstructor(String.class);
			declaredConstructor.setAccessible(true);
			Person person = declaredConstructor.newInstance("李鸿章");
			System.out.println(person.getName());
			Method declaredMethod = clazz.getDeclaredMethod("setName", String.class);
			declaredMethod.setAccessible(true);
			declaredMethod.invoke(person, "李昊哲");
			Method declaredMethod2 = clazz.getDeclaredMethod("getName");
			declaredMethod2.setAccessible(true);
			String name = (String) declaredMethod2.invoke(person);
			System.out.println(name);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
