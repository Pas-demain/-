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
 * 搜索功能面板
 * 
 */

public class SearchPanel extends JPanel {

	// 搜索功能相关
	private JTextField textField;
	private JButton searchButton;
	// 记录前一次输入的文本
	private String beforeKey;
	// 解析由关键字产生的搜索网页
	private Thread searchThread;

	private JButton userButton;

	// 主要用于切换展示面板页面
	private ButtonToolBar hubToolBar;

	private JButton[] toolBarButtons;

	// 与展示面板相关
	private ShowPanel showPanel;
	private CardLayout cardLayout;

	private LibraryPanel libraryPanel;
	private LibraryTableModel libraryTableModel;

	// 最大搜索页数
	private int maxPage;

	// 音乐库数据集
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

		searchButton = new IconButton("搜索", "icon/搜索1.png");
		userButton = new IconButton("用户", "icon/我1.png");

		searchButton.setPreferredSize(new Dimension(50, 30));
		userButton.setPreferredSize(new Dimension(50, 30));

		hubToolBar = new ButtonToolBar(JToolBar.HORIZONTAL, 6);
		hubToolBar.setPreferredSize(new Dimension(300, 65));

		toolBarButtons = new JButton[6];

		toolBarButtons[0] = new IconButton("折叠", "");//F:/music图片/菜单折叠.png
		toolBarButtons[1] = new IconButton("乐库");
		toolBarButtons[1].setText("乐库");
		toolBarButtons[2] = new IconButton("MV");
		toolBarButtons[2].setText("MV");
		toolBarButtons[3] = new IconButton("歌词");
		toolBarButtons[3].setText("歌词");
		toolBarButtons[4] = new IconButton("电台");
		toolBarButtons[4].setText("电台");
		toolBarButtons[5] = new IconButton("直播");
		toolBarButtons[5].setText("直播");

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
