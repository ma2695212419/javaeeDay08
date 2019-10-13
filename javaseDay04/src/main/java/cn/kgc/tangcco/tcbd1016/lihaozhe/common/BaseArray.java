package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

public abstract class BaseArray {
	/**
	 * 数组的拷贝
	 * @param original	原数组
	 * @param newLength	新数组长度
	 * @return			新数组
	 */
	public static Object[] copy(Object[] original, int newLength) {
		Object[] newObjects = new Object[newLength];
		if (original.length > newLength) {
			// 新数组长度小于原数组 按照新数组的长度遍历原数组并将原数中元素的赋值给新数组
			for (int i = 0; i < newLength; i++) {
				newObjects[i] = original[i];
			}
		} else {
			// 新数组长度不小于原数组 按照原数组的长度遍历原数组并将原数中元素的赋值给新数组
			for (int i = 0; i < original.length; i++) {
				newObjects[i] = original[i];
			}
		}
		return newObjects;
	}
	public static void print(Object[] original) {
		System.out.print("[");
		for (int i = 0; i < original.length; i++) {
			System.out.print(original[i]);
			if (i != original.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
	/**
	 * 数组的拷贝
	 * @param original	原数组
	 * @param newLength	新数组长度
	 * @return			新数组
	 */
	public static Object[] copyOf(Object[] original, int newLength) {
		Object[] newObjects = new Object[newLength];
		if (original.length > newLength) {
			// 新数组长度小于原数组 按照新数组的长度遍历原数组并将原数中元素的赋值给新数组
			BaseSystem.arraycopy(original, 0, newObjects, 0, newLength);
		} else {
			// 新数组长度不小于原数组 按照原数组的长度遍历原数组并将原数中元素的赋值给新数组
			BaseSystem.arraycopy(original, 0, newObjects, 0, original.length);
			
		}
		return newObjects;
	}
}
