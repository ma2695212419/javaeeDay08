package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

import org.junit.Test;

/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月20日	下午5:15:34
 */
public class StringUtilTest {
	@Test
	public void test01() {
		System.out.println(StringUtils.isEmpty(null));
		System.out.println(StringUtils.isEmpty(""));
		System.out.println(StringUtils.isEmpty(" "));
	}
}
