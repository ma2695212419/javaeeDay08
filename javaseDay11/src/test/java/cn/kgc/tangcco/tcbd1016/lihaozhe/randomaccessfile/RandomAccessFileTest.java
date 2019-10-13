package cn.kgc.tangcco.tcbd1016.lihaozhe.randomaccessfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class RandomAccessFileTest {
	@Test
	public void read() {
		// 通过设置字符集的编码，并将ByteBuffer转为CharBuffer来避免中文乱码
		Charset charset = Charset.forName("utf-8");
		// 自动使用设置好的字符集解码
		CharsetDecoder decoder = charset.newDecoder();
		// r：以只读方式打开指定文件。如果试图对该RandomAccessFile指定的文件执行写入方法则会抛出IOException
		/*
		 * rw：以读取、写入方式打开指定文件。如果该文件不存在，则尝试创建文件
		 * rws：以读取、写入方式打开指定文件。相对于rw模式，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备，
		 * 默认情形下(rw模式下),是使用buffer的,只有cache满的或者使用RandomAccessFile.close()关闭流的 时候儿才真正的写到文件
		 */
		// rwd：与rws类似，只是仅对文件的内容同步更新到磁盘，而不修改文件的元数据
		// 文件内容访问类
		try {
			RandomAccessFile file = new RandomAccessFile("io.txt", "rw");
			// 创建文件通道
			FileChannel fileChannel = file.getChannel();
			// 创建缓冲区
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			CharBuffer charBuffer = CharBuffer.allocate(1024);
			// 记录通道内容
			int read = fileChannel.read(byteBuffer);
			while (read != -1) {
				System.out.println("read>>>" + read);
				// 限定读取位置
				byteBuffer.flip();
				// 判断缓冲区中是否还存在数据
				while (byteBuffer.hasRemaining()) {
					// 编码，解码
					decoder.decode(byteBuffer);
					charBuffer.flip();
				}
				byteBuffer.clear();
				charBuffer.clear();
				read = fileChannel.read(byteBuffer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void write01() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("nio.txt"), true);
			FileChannel channel = fos.getChannel();
			// 以utf-8编码集写入
			ByteBuffer src = Charset.forName("utf-8").encode("都结束了,都结束了");
			System.out.println("初始化容量和limit>>>" + src.capacity() + "," + src.limit());
			int length = 0;
			while ((length = channel.write(src)) != 0) {
				/**
				 * 注意，这里不需要clear，将缓冲中的数据写入到通道中后，第二次接着上一次的顺序往下读
				 */
				System.out.println("写入长度" + length);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void write02() {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("raf.txt", "rw");
			String str = "我爱你中国";
			raf.seek(0);
			raf.write(str.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 非直接缓冲区 文件的复制
	 * 
	 * @throws IOException
	 */
	public void copy01() throws IOException {
		// 记录时间
		long startTime = System.currentTimeMillis();
		// 获取文件
		FileInputStream fileInputStream = new FileInputStream(new File("pom.xml"));
		FileOutputStream fileOutputStream = new FileOutputStream("pom2.xml");
		// 获取通道
		FileChannel inChannel = fileInputStream.getChannel();
		FileChannel outChannel = fileOutputStream.getChannel();
		// 分配缓冲区大小
		ByteBuffer buf = ByteBuffer.allocate(1024);
		while (inChannel.read(buf) != -1) {
			buf.flip();// 切换读取数据的模式
			outChannel.write(buf);
			buf.clear();
		}
		outChannel.close();
		inChannel.close();
		fileInputStream.close();
		fileOutputStream.close();
		long end = System.currentTimeMillis();
		System.out.println("nioCopyTest1耗费时间:" + (end - startTime));
	}
	/**
	 * 使用直接缓冲区完成文件的复制(内存映射文件)
	 * 
	 * @throws IOException
	 */

	@Test
	public void copy02() {
		long startTime = System.currentTimeMillis(); // READ 静态属性 以读取方式打开文件
		FileChannel inChannel;
		try {
			inChannel = FileChannel.open(Paths.get("pom.xml"), StandardOpenOption.READ);
			// WRITE 以写入方式打开文件 CREATE_NEW 如果文件不存在创建
			FileChannel outChannel = FileChannel.open(Paths.get("pom3.xml"), StandardOpenOption.WRITE,
					StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);
			// 镜像Buffer（由于是内存镜像，因此处理速度非常快） 内存映射文件(什么模式 从哪里开始 到哪里结束)
			// 映射的规矩：
			// i.
			// 使用InputStream获得的Channel可以映射，使用map时只能指定为READ_ONLY模式，不能指定为READ_WRITE和PRIVATE，否则会抛出运行时异常！
			// ii. 使用OutputStream得到的Channel不可以映射！！并且OutputStream的Channel也只能write不能read！
			// iii. 只有RandomAccessFile获取的Channel才能开启任意的这三种模式！
			MappedByteBuffer inMappBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
			MappedByteBuffer outMappeBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
			// 直接在缓冲区进行数据的读写操作
			byte[] dst = new byte[inMappBuf.limit()];
			inMappBuf.get(dst);
			outMappeBuf.put(dst);

			inChannel.close();
			outChannel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("nioCopyTest2耗费时间:" + (end - startTime));
	}

	@Test
	public void copy03() {
		long startTime = System.currentTimeMillis();
		FileChannel inChannel;
		try {
			inChannel = FileChannel.open(Paths.get("pom.xml"), StandardOpenOption.READ);
			FileChannel outChannel = FileChannel.open(Paths.get("pom4.xml"), StandardOpenOption.WRITE,
					StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);
			outChannel.transferFrom(inChannel, 0, inChannel.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("copy03耗费时间:" + (end - startTime));
	}
}
