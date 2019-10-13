package cn.kgc.tangcco.tcbd1016.lihaozhe.commos_lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;


/**
 * 
 * @author	李昊哲
 * @version	1.0	<br>
 *	创建时间:	2019年8月20日	下午5:19:17
 */
public class StringUtilsTest {
	@Test
	public void test01() {
		System.out.println(StringUtils.isEmpty(null));
		System.out.println(StringUtils.isEmpty(""));
		System.out.println(StringUtils.isEmpty(" "));
	}
}
