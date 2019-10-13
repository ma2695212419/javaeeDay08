package cn.kgc.tangcco.tcbd1016.lihaozhe.oop03;

class Super {
	public void f() {
		System.out.println("Super.f()");
	}
}

class Sub extends Super {
	public void f() {
		System.out.println("Sub.f()");
	}
}

class Goo {
	public void g(Super obj) {
		System.out.println("g(Super)..");
		obj.f();
	}

	public void g(Sub obj) {
		System.out.println("g(Sub)..");
		obj.f();
	}
}

public class Test {
	public static void main(String[] args) {
		// 重载看类型	重写看对象
		Super s = new Sub();
		Goo goo = new Goo();
		goo.g(s);
	}
}