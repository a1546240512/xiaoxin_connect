package com.client.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.client.ctrl.EmailCtrl;
import com.util.GetrandomUtil;

public class RegisterView {
	public void initUI() {
			
		    JFrame registerframe=new JFrame();
			Font font =new Font("ËÎÌå",Font.BOLD,18);
			ImageIcon image=new ImageIcon(".\\\\src\\\\com\\\\images\\\\loginview.jpg");
			JLabel jlcontent=new JLabel(image);
			jlcontent.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
			JPanel jp=(JPanel)registerframe.getContentPane();
			jp.setLayout(null);
			jp.setOpaque(false);
			jp.getRootPane().add(jlcontent,new Integer(Integer.MIN_VALUE));
			
			
			Font titleFont=new Font("ËÎÌå",Font.BOLD,30);
			JLabel jltitle=new JLabel("×¢²á½çÃæ");
			jltitle.setFont(titleFont);
			jltitle.setBounds(360, 70, 140, 40);
			registerframe.add(jltitle);
			
			
			JLabel jlid=new JLabel("ÕËºÅ");
			jlid.setFont(font);
			jlid.setBounds(300, 200, 50, 30);
			registerframe.add(jlid);
			
			
			JLabel jlpassword=new JLabel("ÃÜÂë");
			jlpassword.setFont(font);
			jlpassword.setBounds(300, 250, 50, 30);
			registerframe.add(jlpassword);
			
			JLabel jlpassword2=new JLabel("È·ÈÏÃÜÂë");
			jlpassword2.setFont(font);
			jlpassword2.setBounds(262, 300, 80, 30);
			registerframe.add(jlpassword2);
			
			JTextField jtid=new JTextField();
			jtid.setBounds(360, 200, 170, 30);
			registerframe.add(jtid);
			
			JTextField jtpassword=new JTextField();
			jtpassword.setBounds(360, 250, 170, 30);
			registerframe.add(jtpassword);
			
			JTextField jtpassword2=new JTextField();
			jtpassword2.setBounds(360, 300, 170, 30);
			registerframe.add(jtpassword2);
			
			JButton jbrandom=new JButton("Ëæ»ú");
			jbrandom.setBounds(550, 200, 60, 40);
			registerframe.add(jbrandom);
			
			JButton jbregister=new JButton("×¢²á");
			jbregister.setBounds(300, 360, 60, 40);
			registerframe.add(jbregister);
			
			JButton jbreturn=new JButton("·µ»Ø");
			jbreturn.setBounds(470, 360, 60, 40);
			registerframe.add(jbreturn);
			
			
			registerframe.setResizable(false);
			registerframe.setBounds(200, 200, image.getIconWidth(),image.getIconHeight());
			registerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			registerframe.setVisible(true);
			
			
			jbrandom.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					jtid.setText(new GetrandomUtil().getrandom());
				}	
			});
			
			
			jbreturn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					registerframe.setVisible(false);
					LoginView lv=new LoginView();
					lv.loginInit(null,null,3);
				}	
			});
			
			jbregister.addActionListener(new EmailCtrl(registerframe,jbregister,jtid,jtpassword,jtpassword2));
		
	}
}
