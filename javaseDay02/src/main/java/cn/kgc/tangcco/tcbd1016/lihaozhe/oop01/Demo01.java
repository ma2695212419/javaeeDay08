package cn.kgc.tangcco.tcbd1016.lihaozhe.oop01;

public class Demo01 {
	/**
	 * 在同一个类中方法参数不同的同名方法，这种表现形式我们称之为方法的重载<br>
	 * 方法名与类名相同，没有返回值但是不需要使用void修饰的方法我们称之为构造方法<br>
	 * 没有参数的构造方法我们称之为无参构造方法<br>
	 * 构造方法用于对象初始化<br>
	 * 当代码中没有有参构造方法的同时也没有无参构造方法，在类实例化过程中jvm会帮助类增加一个无参构造方法<br>
	 * 注意：当类中存在有参构造方法的时候，在实例化过程中jvm不会会帮助类增加一个无参构造方法,<br>
	 * 所以在类中存在有参构造方法的情况下需要手写一个无参构造方法<br>
	 * 为了避免bug无论类中是否存在有参构造方法都手写一个无参构造方法<br>
	 * 无参构造方法和有参构造方法是方法重载的表现形式之一
	 */
	public Demo01() {
		System.out.println("我是Demo的无参构造方法");
	}

	public Demo01(String message) {
		System.out.println("我是Demo的有参构造方法");
	}

	public void eat() {
		System.out.println("我是个吃货");
	}

	public void eat(String food) {
		System.out.println("我爱吃" + food);
	}
}
