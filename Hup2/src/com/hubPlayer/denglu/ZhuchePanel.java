package com.hubPlayer.denglu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ZhuchePanel extends JFrame{
	private final int InitialWidth =  470;
	private final int InitialHeight = 360;   
	private final Point InitialPoint;
	
	private JLabel k;
	private JPanel zhuPanel;
	 JLabel zh,mm,mm1,phone;
	 JTextField id,phone1;
	 JPasswordField pw1,pw2;
	 JPanel p1,p2,p3,p4,p5;
	 JButton zc,fh;
	 public ZhuchePanel() {
		setTitle("注册");
		setSize(InitialWidth, InitialHeight);
		this.setIconImage(new ImageIcon("icon/logo.jpg").getImage());

		Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕中心
		InitialPoint = new Point((dime.width - InitialWidth) / 2,
				(dime.height - InitialHeight) / 2);
		setLocation(InitialPoint);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);//让frame窗口失去边框和标题栏的修饰
		//setOpacity((float)0.90);
		setVisible(true);
		setResizable(false);

	
		buildPanel();
	}

	private void buildPanel() {
		// TODO Auto-generated method stub
		k = new JLabel(new ImageIcon("D:/vagu music/images/vv.jpg"));
		zhuPanel = new JPanel();
		
		k.setPreferredSize(new Dimension(470, 150));
		zhuPanel.setPreferredSize(new Dimension(470, 80));
		
		zhuPanel.setLayout( new GridLayout(5,1));
		zhuPanel.setOpaque(true);
		zhuPanel.setBackground(Color.white);
		
		p1 = new JPanel();
		p1.setBackground(Color.white);
		p2 = new JPanel();
		p2.setBackground(Color.white);
		p3 = new JPanel();
		p3.setBackground(Color.white);
		p4 = new JPanel();
		p4.setBackground(Color.white);
		p5 = new JPanel();
		p5.setBackground(Color.white);
		
		zh = new JLabel("账号");
		phone = new JLabel("电话");
		mm = new JLabel("密码");
		mm1 = new JLabel("确认密码");
		
		id = new JTextField(13);
		phone1 = new JTextField(13);
		pw1 = new JPasswordField(13);
		pw2 = new JPasswordField(13);
		zc = new JButton("注册");
		zc.setBackground(Color.PINK);
		fh = new JButton("返回");
		fh.setBackground(Color.PINK);
		
		p1.add(zh);
		p1.add(id);
		
		p5.add(phone);
		p5.add(phone1);
		
		p2.add(mm);
		p2.add(pw1);
		
		p3.add(mm1);
		p3.add(pw2);
		
		p4.add(zc);
		p4.add(fh);

		zhuPanel.add(p1);
		zhuPanel.add(p5);
		zhuPanel.add(p2);
		zhuPanel.add(p3);
		zhuPanel.add(p4);
		
		zc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Jdbc d  =  new Jdbc();  
		        String username = id.getText(); 
		        String phonenum = phone1.getText();
		        String password = pw1.getText();  
		         String password2 = pw2.getText();
		         d.insert(username,password,password2,phonenum); 
			}
			
		});
		
		fh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Denglu();
				ZhuchePanel.this.dispose();
			}
			
		});
		

		buildLayout();
	}

	private void buildLayout() {
		// TODO Auto-generated method stub
		Box topBox = Box.createHorizontalBox();
		
		topBox.add(k);
		
		Box bottomBox = Box.createHorizontalBox();
		bottomBox.add(zhuPanel);
		
		Container mainPanel = getContentPane();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(Color.PINK);
		mainPanel.add(topBox);
		mainPanel.add(bottomBox);
		mainPanel.add(Box.createVerticalStrut(15));
	}
}
