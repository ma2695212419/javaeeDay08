package cn.kgc.tangcco.tcbd1016.lihaozhe.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Clinet {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.56.254",10001);
			InputStream input = socket.getInputStream();
			int b = -1;
			while ((b = input.read()) != -1) {
				System.out.print((char)b);
			}
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
