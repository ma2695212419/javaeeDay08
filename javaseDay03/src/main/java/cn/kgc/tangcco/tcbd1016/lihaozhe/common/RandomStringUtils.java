package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

public abstract class RandomStringUtils {
	/**
	 * 传入一个整数，随机生成整数位数的验证码，验证码内容为0 - 9 之间的整数字符和26个小写的英文字母和大写的英文字母
	 * @param count	生成验证码的位数
	 * @return		随机生成的验证码
	 */
	public static String random(int count) {
		// 验证码能够使用到的所有字符的字符串
		String code = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// 用于存储新生成的验证码
		StringBuilder sb = new StringBuilder();
		// 根据传入参数控制验证码的位数
		for (int i = 0; i < count; i++) {
			// 生成随机整数的范围 为 验证码字符串模板的最大index
			double random = Math.random();
			// index 值为 0 至 62之间的整数
			int index =  (int) Math.floor(random * 62);
			// 根据index获取验证码字符串模板对应的字符
			sb.append(code.charAt(index));
		}
		// 返回生成的验证码
		return sb.toString();
	}
}
