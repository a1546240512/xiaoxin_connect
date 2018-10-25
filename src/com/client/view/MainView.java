package com.client.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView {
 void mainviewInit() {
		JFrame mainframe=new JFrame("hzx” œ‰");
		Font font =new Font("ÀŒÃÂ",Font.BOLD,18);
		ImageIcon image=new ImageIcon(".\\src\\com\\images\\mainView.jpg");
		JLabel jlcontent=new JLabel(image);
		jlcontent.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		JPanel jp=(JPanel)mainframe.getContentPane();
		jp.setLayout(null);
		jp.setOpaque(false);
		jp.getRootPane().add(jlcontent,new Integer(Integer.MIN_VALUE));
		
		
		Font titleFont=new Font("ÀŒÃÂ",Font.BOLD,30);
		JLabel jltitle=new JLabel("hzx” œ‰");
		jltitle.setFont(titleFont);
		jltitle.setBounds(100, 10, 140, 40);
		mainframe.add(jltitle);
		

		
		JButton jbGetEmail=new JButton("Ω” ’” º˛");
		jbGetEmail.setBounds(52, 75, 186, 40);
		mainframe.add(jbGetEmail);
		
		JButton jbSetEmail=new JButton("∑¢ÀÕ” º˛");
		jbSetEmail.setBounds(52, 125, 186, 40);
		mainframe.add(jbSetEmail);
		
		
		JButton jbNoReadEmail=new JButton("Œ¥∂¡” º˛");
		jbNoReadEmail.setBounds(52, 175, 186, 40);
		mainframe.add(jbNoReadEmail);
		
		
		JButton jbDustbin=new JButton("¿¨ª¯œ‰");
		jbDustbin.setBounds(52, 225, 186, 40);
		mainframe.add(jbDustbin);
		
		
		JButton jbWriteEmail=new JButton("–¥” º˛");
		jbWriteEmail.setBounds(52, 275, 186, 40);
		mainframe.add(jbWriteEmail);
		
		
		
		mainframe.setResizable(false);
		mainframe.setBounds(200, 200, image.getIconWidth(),image.getIconHeight());
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setVisible(true);
		
		
		jbWriteEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.setVisible(false);
				WriteEmailView wev=new WriteEmailView();
				wev.initView();
			}
		});
	}
 
    public static void main(String[] args) {
    	MainView mv=new MainView();
    	mv.mainviewInit();
 }
 
 
}
