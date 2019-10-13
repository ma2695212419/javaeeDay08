package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SingleFactory {
	static Properties properties = new Properties();
	static {
		InputStream input = SingleFactory.class.getClassLoader().getResourceAsStream("ApplicationContext.properties");
		try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Object instance;
	private static Map<String, Object> map = new ConcurrentHashMap<String, Object>();
	private SingleFactory() {
		
	}
	public static Object newInstance(String key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}else {
			String className = (String) properties.get(key);
			try {
				Class<?> clazz = Class.forName(className);
				Constructor<?> constructor = clazz.getDeclaredConstructor();
				Object newInstance = constructor.newInstance();
				map.put(key, newInstance);
				return newInstance;
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
