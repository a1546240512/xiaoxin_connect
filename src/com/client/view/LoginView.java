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

public class LoginView {
	public void loginInit(String id,String password,int i) {
		JFrame loginframe=new JFrame("hzx” œ‰");
		Font font =new Font("ÀŒÃÂ",Font.BOLD,18);
		ImageIcon image=new ImageIcon(".\\src\\com\\images\\loginview.jpg");
		JLabel jlcontent=new JLabel(image);
		jlcontent.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		JPanel jp=(JPanel)loginframe.getContentPane();
		jp.setLayout(null);
		jp.setOpaque(false);
		jp.getRootPane().add(jlcontent,new Integer(Integer.MIN_VALUE));
		
		
		Font titleFont=new Font("ÀŒÃÂ",Font.BOLD,30);
		JLabel jltitle=new JLabel("hzx” œ‰");
		jltitle.setFont(titleFont);
		jltitle.setBounds(360, 70, 140, 40);
		loginframe.add(jltitle);
		
		JLabel jlid=new JLabel("’À∫≈");
		jlid.setFont(font);
		jlid.setBounds(300, 200, 50, 30);
		loginframe.add(jlid);
		
		
		JLabel jlpassword=new JLabel("√‹¬Î");
		jlpassword.setFont(font);
		jlpassword.setBounds(300, 250, 50, 30);
		loginframe.add(jlpassword);
		
		JTextField jtid=new JTextField();
		jtid.setBounds(360, 200, 170, 30);
		loginframe.add(jtid);
		
		JTextField jtpassword=new JTextField();
		jtpassword.setBounds(360, 250, 170, 30);
		loginframe.add(jtpassword);
		
		JButton jblogin=new JButton("µ«¬º");
		jblogin.setBounds(300, 300, 60, 40);
		loginframe.add(jblogin);
		
		JButton jbregister=new JButton("◊¢≤·");
		jbregister.setBounds(470, 300, 60, 40);
		loginframe.add(jbregister);
		
		
		loginframe.setResizable(false);
		loginframe.setBounds(200, 200, image.getIconWidth(),image.getIconHeight());
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.setVisible(true);

		
		jbregister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				loginframe.setVisible(false);
				new RegisterView().initUI();
				
			}	
		});
		
		
		jblogin.addActionListener(new EmailCtrl(loginframe,jblogin,jtid,jtpassword,i));
		
		
	}
	public static void main(String[] args) {
		
		LoginView lv=new LoginView();
		lv.loginInit(null,null,3);

	}

}
