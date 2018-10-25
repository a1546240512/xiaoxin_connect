package com.server.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.bean.User;

public class UserDaoImpl implements UserDao{
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public boolean queryUserRegister(User user) {
			try {
				ois=new ObjectInputStream(new FileInputStream(".\\src\\com\\server\\data\\"+user.getID()+".bat"));
				if(ois.readObject().equals(user)) {
					return false;	
				}else {
					return true;
				}
			} catch (IOException e) {
				try {
					oos=new ObjectOutputStream(new FileOutputStream(".\\src\\com\\server\\data\\"+user.getID()+".bat"));
					return true;
				} catch (IOException e1) {
					e1.printStackTrace();
					return true;
				}
			} catch (ClassNotFoundException e) {
				return true;
			}
		
	}
	

	public boolean queryUserLogin(User user) throws ClassNotFoundException {
		try {
			ois=new ObjectInputStream(new FileInputStream(".\\src\\com\\server\\data\\"+user.getID()+".bat"));
			
			if(ois.readObject().equals(user)) {
				return true;	
			}else {
				return false;
			}
		
		} catch (IOException e) {
				return false;
			
		}
	
}
	
	
}
