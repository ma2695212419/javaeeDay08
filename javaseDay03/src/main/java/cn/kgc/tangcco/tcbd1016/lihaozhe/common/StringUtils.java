package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

/**
 * 
 * @author 李昊哲
 * @version 1.0 <br>
 *          创建时间: 2019年8月20日 下午5:12:09
 */
public abstract class StringUtils {
	public static boolean isEmpty(String string) {
		return string == null || string.length() == 0;
	}
}
