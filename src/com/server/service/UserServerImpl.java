package com.server.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.bean.Message;
import com.bean.User;
import com.server.dao.UserDao;
import com.server.dao.UserDaoImpl;

public class UserServerImpl extends Thread implements UserServer{
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public UserServerImpl(Socket socket) {
		this.socket = socket;
	}

	
	public void run() {
		Message message;
		try {
			boolean bo;
			ois=new ObjectInputStream(socket.getInputStream());
			oos=new ObjectOutputStream(socket.getOutputStream());
			message=(Message)ois.readObject();
			System.out.println(message.getOprAction());
			UserDaoImpl ud=new UserDaoImpl();
			if(message.getOprAction().equals("REGISTER")) {
				bo=ud.queryUserRegister(message.getUser());
				if(bo==false) {
					User user=null;
					oos.writeObject(user);
					oos.flush();	
				}else {
					User user=new User();
					user.setID("1");
					oos.writeObject(user);
					oos.flush();
				}
			}else if(message.getOprAction().equals("LOGIN")) {
				
				bo=ud.queryUserLogin(message.getUser());
				if(bo==false) {
					bo=false;
					oos.writeObject(bo);
					oos.flush();	
				}else {
					bo=true;
					oos.writeObject(bo);
					oos.flush();	
				}
				
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
