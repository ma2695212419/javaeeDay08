package cn.kgc.tangcco.tcbd1016.lihaozhe.oop7;
/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月19日	下午5:21:34
 */
public class Outter03 {
	private Inner inner = new Inner();
	public Inner getInner() {
		return this.inner;
	}
	public class Inner {
		public  void excute() {
			System.out.println("教育改变生活");
		}
	}
	
	public Inner newInner() {
		return new Inner();
	}
}
