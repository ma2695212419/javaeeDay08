package cn.kgc.tangcco.tcbd1016.lihaozhe.oop6;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月19日 下午5:07:39
 */
public interface C extends A, B {
	public abstract void c();

	static void d() {
		System.out.println("我是接口C使用static修饰的方法d()");
	}

	default void e() {
		System.out.println("我是接口C使用default修饰的方法e()");
	}
}
