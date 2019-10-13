package cn.kgc.tangcco.tcbd1016.lihaozhe.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.entity.Person;

public class TreeSetTest {
	@Test
	public void test01() {
		Set<Person> set = new TreeSet<Person>();
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				set.add(new Person("user" + i, 15 + i, 2));
				continue;
			}
			set.add(new Person("user" + i, 15 + i, 1));
		}
		Iterator<Person> it = set.iterator();
		while (it.hasNext()) {
			Person person = it.next();
			System.out.println(person.toString());
		}
	}
}
