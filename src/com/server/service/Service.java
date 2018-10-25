package com.server.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
	public static void main(String[] args) throws IOException {
		
			ServerSocket ssocket=new ServerSocket(8888);
		
		while(true) {
			Socket socket=ssocket.accept();
			UserServerImpl us=new UserServerImpl(socket);
			us.start();
		}
	}
}
