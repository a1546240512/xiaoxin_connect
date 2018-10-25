package com.client.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WriteEmailView {
	
	public void initView() {
		JFrame writeEmailframe=new JFrame("hzx����");
		Font font =new Font("����",Font.BOLD,18);
		ImageIcon image=new ImageIcon(".\\src\\com\\images\\otherView.jpg");
		JLabel jlcontent=new JLabel(image);
		jlcontent.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		JPanel jp=(JPanel)writeEmailframe.getContentPane();
		jp.setLayout(null);
		jp.setOpaque(false);
		jp.getRootPane().add(jlcontent,new Integer(Integer.MIN_VALUE));
		
		
		Font titleFont=new Font("����",Font.BOLD,30);
		JLabel jltitle=new JLabel("hzx����");
		jltitle.setFont(titleFont);
		jltitle.setBounds(280, 10, 140, 40);
		writeEmailframe.add(jltitle);
		
		
		JTextArea jta=new JTextArea(3,20);
		jta.setBounds(20, 50, 620, 300);
		jta.setLineWrap(true);  // ������ݹ������Զ�����  
	    JScrollPane jsp=new JScrollPane(jta);
	    writeEmailframe.add(jta);
        
		
		JButton jblogin=new JButton("����");
		jblogin.setBounds(200, 355, 60, 40);
		writeEmailframe.add(jblogin);
		
		JButton jbregister=new JButton("����");
		jbregister.setBounds(470, 355, 60, 40);
		writeEmailframe.add(jbregister);
		
		
		writeEmailframe.setResizable(false);
		writeEmailframe.setBounds(200, 200, image.getIconWidth(),image.getIconHeight());
		writeEmailframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		writeEmailframe.setVisible(true);

		
		jbregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeEmailframe.setVisible(false);
				MainView mv=new MainView();
				mv.mainviewInit();
			}
		});
		
		
	}
	
}
