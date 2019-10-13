package cn.kgc.tangcco.tcbd1016.lihaozhe.lamda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class PreFunctionalInterface {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 一个参数 一个返回 方法为apply
		UnaryOperator<Integer> unaryOperator = (n) -> {
			return n * -1;
		};
		System.out.println(unaryOperator.apply(10));
		// 两个参数 一个返回 方法为apply
		BinaryOperator<Integer> binaryOperator = (a , b) -> {
			return a + b;
		};
		System.out.println(binaryOperator.apply(10, 20));
		// 一个参数 无返回 方法为accept
		// 可以用在数据库数据保存
		Consumer<Integer> consumer = (a) -> {
			System.out.println(a + "被保存在数据库中了");
		};
		consumer.accept(10);
		 
		// 无参数 一个返回 方法为get
		Supplier<Integer> supplier = () ->{
			return 100;
		};
		System.out.println(supplier.get());
		// 传入参数 一个返回 方法为apply
		// 可以用于类型转换或者数据库操作
		Function<String, Integer> function = (str) -> {
			return new Integer(Integer.parseInt(str));
		};
		System.out.println(function.apply("200"));
		// 断言 返回布尔值 方法为test
		Predicate<Integer> predicate = (i) -> {
			if(i >= 60) {
				return true;
			}else {
				return false;
			}
		};
		System.out.println(predicate.test(59));
	}
}
