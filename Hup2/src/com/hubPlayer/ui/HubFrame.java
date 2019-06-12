package com.hubPlayer.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JTree;


import java.util.Map;
import java.util.List;

import com.hubPlayer.player.HigherPlayer;
import com.hubPlayer.ui.tool.ButtonToolBar;
import com.hubPlayer.ui.tool.IconButton;

/**
 * �� KuGou����Ϊ���
 * 
 */

public class HubFrame extends JFrame {

	private final int InitialWidth =  980;
	private final int InitialHeight = 650;   
	private final Point InitialPoint;

	private final int ChangedWidth = 365;

	private PlayPanel playPanel;
	private PlayListPanel playListPanel;
	private SearchPanel searchPanel;
	private ShowPanel showPanel;
	private JLabel v;
	private ButtonToolBar toolBar;

	private final static String savaPath = "E:/Hub/download";

	public HubFrame() {

		setTitle("VAGU����");
		setSize(InitialWidth, InitialHeight);
		setIconImage(new ImageIcon("icon/logo.jpg").getImage());

		Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ����
		InitialPoint = new Point((dime.width - InitialWidth) / 2,
				(dime.height - InitialHeight) / 2);
		setLocation(InitialPoint);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �������ظ����ļ���
		File savefolder = new File(savaPath);

		// ���������ظ����Ĵ洢�ļ���
		if (!savefolder.exists())
			savefolder.mkdirs();

		readSongLibrary();

		buildPanel();

		setVisible(true);

		requestFocus();
	}

	private void buildPanel() {
		playPanel = new PlayPanel();

		// ToolBar:the left of the Frame
		toolBar = new ButtonToolBar(JToolBar.VERTICAL, 4);

		JButton[] toolBarButtons = new JButton[] {
				new IconButton("�����б�", "icon/���� (1).png"),
				new IconButton("�����ղ�", "icon/��.png"),
				new IconButton("�ҵ�����", "icon/���� (3).png"),
				new IconButton("��ʷ��¼", "icon/��ʷ��¼.png") };

		toolBar.addButtons(toolBarButtons);
		
		v = new JLabel("�ҵ�����"); 
		v.setFont(new Font("��Բ",Font.PLAIN,20));
		v.setOpaque(true);
		v.setBackground(Color.PINK);
		v.setForeground(Color.DARK_GRAY);
		//v.setIcon(new ImageIcon("F:/musicͼƬ/12.jpg"));
		//v.setBorder(BorderFactory.createLineBorder(Color.PINK));
	
		playListPanel = new PlayListPanel(toolBar.getButtons(), this);

		searchPanel = new SearchPanel();

		showPanel = new ShowPanel();

		// ���ݸ�����������
		JTree[] listTree = playListPanel.deliverTree();
		HigherPlayer player = playPanel.getHigherPlayer();

		// ��ͨ�������������б����
		playPanel.setTrees(listTree);
		player.setJTree(listTree[0]);
		playListPanel.deliverHigherPlayer(player);

		// ��ͨ�ֿ����������б����
		showPanel.setListTree(listTree);

		// ��ͨ��������������
		playPanel.setLrcPanelTextArea(showPanel.getTextArea());

		// ��ͨ�ֿ�����벥�����
		showPanel.setPlayer(player);

		playPanel.setParentFrame(this);

		// Set the preferredSize of those panels
		playPanel.setPreferredSize(new Dimension(350, 115));
		playListPanel.setPreferredSize(new Dimension(305, 520));
		toolBar.setPreferredSize(new Dimension(47, 520));
		searchPanel.setPreferredSize(new Dimension(610, 115));
		showPanel.setPreferredSize(new Dimension(610, 520));
		v.setPreferredSize(new Dimension(950,46));
		
		
		buildLayout();

		setAction();
	}

	private void setAction() {

		// ��������¼� ��չ������
		this.addWindowStateListener(event -> {
			if (event.getNewState() == JFrame.MAXIMIZED_BOTH) {
				searchPanel.setVisible(true);
				showPanel.setVisible(true);
				setSize(InitialWidth, InitialHeight);
				setLocation(InitialPoint);
				setVisible(true);

			}
		});

		// �۵�����
		/*searchPanel.getCollapseButton().addActionListener(event -> {
			searchPanel.setVisible(false);
			showPanel.setVisible(false);
			setSize(ChangedWidth, InitialHeight);
			setVisible(true);
		});*/

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				saveSongLibrary();

				System.exit(0);
			}
		});
	}

	private void buildLayout() {
		Box topBox = Box.createHorizontalBox();
		
		topBox.add(v);
		
		Box middleBox = Box.createHorizontalBox();
		
		middleBox.add(toolBar);
		middleBox.add(playListPanel);
		middleBox.add(showPanel);
		Box bottomBox = Box.createHorizontalBox();
		bottomBox.add(playPanel);
		bottomBox.add(searchPanel);
		
		
		Container mainPanel = getContentPane();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(Color.PINK);
		mainPanel.add(topBox);
		mainPanel.add(middleBox);
		mainPanel.add(bottomBox);
		mainPanel.add(Box.createVerticalStrut(15));
	}

	@SuppressWarnings({ "unchecked" })
	private void readSongLibrary() {
	}

	private void saveSongLibrary() {
	}
}
