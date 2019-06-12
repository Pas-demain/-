package com.hubPlayer.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.hubPlayer.denglu.Denglu;
import com.hubPlayer.song.SongInfos;
import com.hubPlayer.ui.tool.ButtonToolBar;
import com.hubPlayer.ui.tool.IconButton;
import com.hubPlayer.ui.tool.LibraryPanel;
import com.hubPlayer.ui.tool.LibraryTableModel;

/**
 * �����������
 * 
 */

public class SearchPanel extends JPanel {

	// �����������
	private JTextField textField;
	private JButton searchButton;
	// ��¼ǰһ��������ı�
	private String beforeKey;
	// �����ɹؼ��ֲ�����������ҳ
	private Thread searchThread;

	private JButton userButton;

	// ��Ҫ�����л�չʾ���ҳ��
	private ButtonToolBar hubToolBar;

	private JButton[] toolBarButtons;

	// ��չʾ������
	private ShowPanel showPanel;
	private CardLayout cardLayout;

	private LibraryPanel libraryPanel;
	private LibraryTableModel libraryTableModel;

	// �������ҳ��
	private int maxPage;

	// ���ֿ����ݼ�
	private Map<String, List<SongInfos>> songLibraryMap;

	public SearchPanel() {

		setLayout(new BorderLayout());
		setOpaque(true);
		setBackground(Color.PINK);

		init();
		setAction();
		createLayout();
	}

	private void init() {
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 30));

		searchButton = new IconButton("����", "icon/����1.png");
		userButton = new IconButton("�û�", "icon/��1.png");

		searchButton.setPreferredSize(new Dimension(50, 30));
		userButton.setPreferredSize(new Dimension(50, 30));

		hubToolBar = new ButtonToolBar(JToolBar.HORIZONTAL, 6);
		hubToolBar.setPreferredSize(new Dimension(300, 65));

		toolBarButtons = new JButton[6];

		toolBarButtons[0] = new IconButton("�۵�", "");//F:/musicͼƬ/�˵��۵�.png
		toolBarButtons[1] = new IconButton("�ֿ�");
		toolBarButtons[1].setText("�ֿ�");
		toolBarButtons[2] = new IconButton("MV");
		toolBarButtons[2].setText("MV");
		toolBarButtons[3] = new IconButton("���");
		toolBarButtons[3].setText("���");
		toolBarButtons[4] = new IconButton("��̨");
		toolBarButtons[4].setText("��̨");
		toolBarButtons[5] = new IconButton("ֱ��");
		toolBarButtons[5].setText("ֱ��");

		hubToolBar.addButtons(toolBarButtons);

		maxPage = 100;
	}

	private void createLayout() {

		Box Box1 = Box.createHorizontalBox();
		Box1.add(Box.createHorizontalStrut(10));
		Box1.add(userButton);
		Box1.add(Box.createHorizontalStrut(20));
		Box1.add(textField);
		Box1.add(Box.createHorizontalStrut(5));
		Box1.add(searchButton);
		Box1.add(Box.createHorizontalStrut(10));

		Box Box2 = Box.createVerticalBox();
		Box2.add(Box.createVerticalStrut(7));
		Box2.add(Box1);
		Box2.add(Box.createVerticalStrut(5));

		add(Box2, BorderLayout.NORTH);
		add(hubToolBar, BorderLayout.CENTER);
	}

	private void setAction() {

		for (int i = 1; i < toolBarButtons.length; i++) {
			int k = i;
			toolBarButtons[i].addActionListener(event -> {
				cardLayout.show(showPanel, String.valueOf(k));
			});

		}

		searchButton.addActionListener(event -> {

			String key = textField.getText();

			if (!prejudgeForSearchButton(key))
				return;

			searchThread = new Thread(() -> {
				searchForSearchButton(key);
			});

			searchThread.start();

		});

		userButton.addActionListener(event ->{
			new Denglu();
			setVisible(true);
			
		});
	}

	private void searchForSearchButton(String key) {
		// TODO Auto-generated method stub
		
	}

	private boolean prejudgeForSearchButton(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	private void setMoreSearchAction(JButton moreSearch) {

		
	}
}
