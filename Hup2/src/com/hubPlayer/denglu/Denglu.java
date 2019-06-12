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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hubPlayer.ui.HubFrame;

@SuppressWarnings("serial")
public class Denglu extends JFrame{
	
	private final int InitialWidth =  470;
	private final int InitialHeight = 360;   
	private final Point InitialPoint;
	
	//JFrame frame = new JFrame("deng");
	
	private JLabel denglu;
	   JPanel p1,p2,p3,p4;
	   JLabel zhanghao , mima;
	   JButton deng,zhuce,zhijie;
	   JTextField zhsr;
	   JPasswordField mmsr;
	   JCheckBox jizhu,zidong;
	private JPanel dengluPanel;
	
	public Denglu() {
		
		
		setTitle("��¼");
		setSize(InitialWidth, InitialHeight);
		this.setIconImage(new ImageIcon("icon/logo.jpg").getImage());

		Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ����
		InitialPoint = new Point((dime.width - InitialWidth) / 2,
				(dime.height - InitialHeight) / 2);
		setLocation(InitialPoint);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);//��frame����ʧȥ�߿�ͱ�����������
		//setOpacity((float)0.90);
		setVisible(true);
		setResizable(false);

	
		buildPanel();
	}

	private void buildPanel() {
		// TODO Auto-generated method stub
		denglu = new JLabel(new ImageIcon("D:/vagu music/images/vv.jpg"));
		
		dengluPanel = new JPanel();
		
		denglu.setPreferredSize(new Dimension(470, 150));
		dengluPanel.setPreferredSize(new Dimension(470, 80));
		
		dengluPanel.setLayout( new GridLayout(4,1));
		//setOpaque(true);
		dengluPanel.setBackground(Color.white);
		
		p1 = new JPanel();
		p1.setBackground(Color.white);
		p2 = new JPanel();
		p2.setBackground(Color.white);
		p3 = new JPanel();
		p3.setBackground(Color.white);
		p4 = new JPanel();
		p4.setBackground(Color.white);
		
		zhanghao = new JLabel("�˺�");
		mima = new JLabel("����");
		
		deng = new JButton("��¼");
		deng.setBackground(Color.PINK);
		zhuce = new JButton("ע��");
		zhuce.setBackground(Color.PINK);
		zhijie = new JButton("�ο�");
		zhijie.setBackground(Color.PINK);
		
		zhsr = new JTextField(13);
		zhsr.setText("�����˺�");
		zhsr.setForeground(Color.gray);
		mmsr = new JPasswordField(13);
		//mmsr.setText("��������");
		
		jizhu = new JCheckBox("��ס����");
		jizhu.setBackground(Color.WHITE);
		zidong = new JCheckBox("�Զ���¼");
		zidong.setBackground(Color.WHITE);
		
		p1.add(zhanghao);
		p1.add(zhsr);
		//p1.add(zhuche);
		
		p2.add(mima);
		p2.add(mmsr);
		//p2.add(wangji);
		
		p3.add(zidong);
		p3.add(jizhu);
		
		p4.add(deng);
		p4.add(zhuce);
		p4.add(zhijie);
		
		dengluPanel.add(p1);
		dengluPanel.add(p2);
		dengluPanel.add(p3);
		dengluPanel.add(p4);
	   
		deng.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Jdbc d  = new Jdbc();  
			     String username = zhsr.getText();  
			     String password = mmsr.getText();  
			      if(d.compare(username, password)){  
			        //JOptionPane.showMessageDialog(null,"��¼�ɹ���");  
			           new HubFrame();
			           setVisible(false); 
			      }
			}
	
		});
		
		zhijie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HubFrame();
				Denglu.this.dispose();
			}
			
		});

//   deng.addActionListener(new ActionListener() {	
//	   public void actionPerformed(ActionEvent e) {	
//	  new HubFrame(); //ע�� ���������һ���Ǵ����������,������ķ�������
//	  setVisible(false);
//	   }
//   });
   zhuce.addActionListener(new ActionListener() {	
	   public void actionPerformed(ActionEvent e) {	
	  new ZhuchePanel(); //ע�� ���������һ���Ǵ����������,������ķ�������
	  setVisible(false);
	   }
   });
		buildLayout();
	}

	private void buildLayout() {
		// TODO Auto-generated method stub
		Box topBox = Box.createHorizontalBox();
		
		topBox.add(denglu);
		
		Box bottomBox = Box.createHorizontalBox();
		bottomBox.add(dengluPanel);
		
		Container mainPanel = getContentPane();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(Color.PINK);
		mainPanel.add(topBox);
		mainPanel.add(bottomBox);
		mainPanel.add(Box.createVerticalStrut(15));
	}
}
