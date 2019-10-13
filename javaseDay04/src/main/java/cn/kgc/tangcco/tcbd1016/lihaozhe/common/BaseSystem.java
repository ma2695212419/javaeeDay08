package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

public abstract class BaseSystem {
	/**
	 * 数组的拷贝
	 * @param src		原数组
	 * @param srcPos	原数组的拷贝的开始位置
	 * @param dest		目标数组
	 * @param destPos	目标数组的存储的开始位置
	 * @param length	拷贝的长度
	 */
	public static void arraycopy(Object[] src, int srcPos, Object[] dest, int destPos, int length) {
		// 声明一个数组存储原数组中欲被拷贝的元素的值
		Object[] bak = new Object[length];
		for (int i = 0; i < length; i++) {
			bak[i] = src[i + srcPos];
		}
		// 将备份数组中元素的值存储到新数组中对应的位置上
		for (int j = 0; j < length; j++) {
			dest[j + destPos] = bak[j];
		}
		
	}
}
