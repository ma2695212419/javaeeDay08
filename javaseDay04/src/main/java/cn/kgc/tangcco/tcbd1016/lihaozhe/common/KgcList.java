package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

import java.util.Arrays;


public class KgcList {
	private Object[] elementData;
	private int size;

	public KgcList() {
		this(10);
	}

	public KgcList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
		/**
		 * 初始化数组容量
		 */
		elementData = new Object[initialCapacity];
	}

	public int size() {
		return size;
	}

	public void add(Object object) {
		//  确保集合容量可以容纳该元素对象
		ensureCapacity(size + 1);
		// 向集合底层数组中存储对象并改变集合中元素对象的数量
		elementData[size++] = object;
	}
	/**
	 * 
	 * @param minCapacity
	 */
	public void ensureCapacity(int minCapacity) {
		if (size == elementData.length) {
			int oldCapacity = elementData.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			newCapacity = Math.max(minCapacity, newCapacity);
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}
	public void remove(int index) {
		// rangeCheck(index);
		int numMoved = elementData.length - 1 - index ;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
			elementData[--size] = null;
		}
	}
	public void set(int index,Object object) {
		rangeCheck(index);
		elementData[index] = object;
	}
	public void rangeCheck(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("集合index越限,越界值为>>>" + index);
		}
	}
}
