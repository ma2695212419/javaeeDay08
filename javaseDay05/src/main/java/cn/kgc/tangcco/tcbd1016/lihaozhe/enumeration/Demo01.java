package cn.kgc.tangcco.tcbd1016.lihaozhe.enumeration;
/**
 * 
 * @author	张仙利
 * @version	1.0	<br>
 *	创建时间:	2019年8月23日	下午2:21:07
 */
public class Demo01 {
	public static void main(String[] args) {
		int day = 100;
		System.out.print("今天是星期");
		switch (day % 7) {
		case 0:
			System.out.println("日");
			break;
		case 1:
			System.out.println("一");
			break;
		case 2:
			System.out.println("二");
			break;
		case 3:
			System.out.println("三");
			break;
		case 4:
			System.out.println("四");
			break;
		case 5:
			System.out.println("五");
			break;
		case 6:
			System.out.println("六");
			break;

		default:
			System.out.println("程序异常");
			break;
		}
	}
}	

