package cn.kgc.tangcco.tcbd1016.lihaozhe.commos_lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月20日	下午5:23:49
 */
public class RandomStringUtilsTest {
	@Test
	public void test01() {
		System.out.println(RandomStringUtils.random(4, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
	}
}
