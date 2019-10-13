package cn.kgc.tangcco.tcbd1016.lihaozhe.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(10001);
			System.out.println("服务器启动成功...");
			while (true) {
				Socket accept = serverSocket.accept();
				OutputStream out = accept.getOutputStream();
				out.write(("guest>>>" + accept.getRemoteSocketAddress().toString()).getBytes());
				out.flush();
				System.out.println("guest>>>" + accept.getRemoteSocketAddress().toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
