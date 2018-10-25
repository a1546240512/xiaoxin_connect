package com.client.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.bean.Message;
import com.bean.User;
import com.client.model.EmailModel;
import com.client.view.LoginView;

public class EmailCtrl implements ActionListener{
	//ע�ᴫ��Ĳ���
	private JFrame registerframe;
	private JButton jbregister;
	private JTextField jtId;
	private JTextField jtpassword1;
	private JTextField jtpassword2;
	
	
	public EmailCtrl(JFrame registerframe,JButton jbregister, JTextField jtId, JTextField jtpassword1, JTextField jtpassword2) {
		this.registerframe=registerframe;
		this.jbregister = jbregister;
		this.jtId = jtId;
		this.jtpassword1 = jtpassword1;
		this.jtpassword2 = jtpassword2;
	}
	//��¼����Ĳ���
	private JFrame loginframe;
	private JButton jblogin;
	private JTextField jtIdLogin;
	private JTextField jtPasswordLogin;
	private int i;
	

	public EmailCtrl(JFrame loginframe,JButton jblogin,JTextField jtIdLogin, JTextField jtPasswordLogin,int i) {
		this.loginframe = loginframe;
		this.jblogin=jblogin;
		this.jtIdLogin = jtIdLogin;
		this.jtPasswordLogin = jtPasswordLogin;
		this.i=i;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbregister) {
			String Id=jtId.getText();
			String password1=jtpassword1.getText();
			String password2=jtpassword2.getText();
			if(!(password1.equals(password2))) {
				jtpassword1.setText(null);
				jtpassword2.setText(null);
				JOptionPane.showMessageDialog(null, "��������벻һ�£�����д���롣");
				return;
			}
			
			User user=new User();
			user.setID(Id);
			user.setPassword(password1);
			
			Message message=new Message();
			message.setUser(user);
			message.setOprAction("REGISTER");
			EmailModel em;
			try {
				em = new EmailModel(message);
				User ifExistUser=em.userExist();
				if(ifExistUser==null) {
					jtId.setText(null);
					jtpassword1.setText(null);
					jtpassword2.setText(null);
					JOptionPane.showMessageDialog(null, "�û��Ѿ����ڣ�����дע�ᡣ");
					return;
				
				}else {
					JOptionPane.showMessageDialog(null, "ע��ɹ�");
					registerframe.setVisible(false);
					LoginView lv=new LoginView();
					lv.loginInit(user.getID(),user.getPassword(),3);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource()==jblogin) {
			
			String id=jtIdLogin.getText();
			String password=jtPasswordLogin.getText();
			
			User user=new User();
			user.setID(id);
			user.setPassword(password);
			
			Message message=new Message();
			message.setUser(user);
			message.setOprAction("LOGIN");
			EmailModel em;
			
			try {
				boolean bl;
				em=new EmailModel(message);
				bl=em.login();
				if(bl==true) {
					JOptionPane.showMessageDialog(null, "��¼�ɹ�");
					loginframe.setVisible(false);
				}else {
					i--;
					if(i==0) {
						loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						loginframe.setVisible(false);
						JOptionPane.showMessageDialog(null, "������3�λ��ᣬ�˳�ϵͳ");
					}else {
						JOptionPane.showMessageDialog(null, "�˺Ż���������㻹��"+i+"�λ���");
						loginframe.setVisible(false);
						LoginView lv=new LoginView();
						lv.loginInit(null, null, i);
					}
					
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	
	
	
	
	}
	
}
