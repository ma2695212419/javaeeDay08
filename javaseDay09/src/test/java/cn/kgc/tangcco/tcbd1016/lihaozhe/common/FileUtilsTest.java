package cn.kgc.tangcco.tcbd1016.lihaozhe.common;

import java.io.File;

import org.junit.Test;

public class FileUtilsTest {
	@Test
	public void show() {
		FileUtils.show(new File("2019"));
	}
	@Test
	public void delete() {
		FileUtils.delete(new File("2019"));
	}
}
