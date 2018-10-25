package com.client.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.bean.Message;
import com.bean.User;

public class EmailModel {
	
	private Message message;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	
	public EmailModel(Message message) throws UnknownHostException, IOException {
		this.message = message;
		socket=new Socket("127.0.0.1",8888);
	}


	public User userExist() throws IOException, ClassNotFoundException{
		User user=null;
		oos=new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(message);
		oos.flush();
		
		ois=new ObjectInputStream(socket.getInputStream());
		user=(User)ois.readObject();
		
		return user;
	}
	
	public boolean login() throws IOException, ClassNotFoundException {
		boolean bl=false;
		
		oos=new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(message);
		oos.flush();
		
		ois=new ObjectInputStream(socket.getInputStream());
		bl=(boolean)ois.readObject();
		
		return bl;
	}
	

}