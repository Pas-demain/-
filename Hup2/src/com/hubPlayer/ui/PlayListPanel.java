package com.hubPlayer.ui;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;

import com.hubPlayer.player.HigherPlayer;
import com.hubPlayer.ui.tool.SongListPanel;

/**
 * �����б����
 * 
 */

public class PlayListPanel extends JPanel {
	
	private SongListPanel songListPanel;
	private SongListPanel cloudsPanel;
	private SongListPanel downloadPanel;
	private SongListPanel historyPanel;

	private JButton[] buttons;
	private JFrame parent;

	private CardLayout card;

	public PlayListPanel(JButton[] buttons, JFrame parent) {

		setOpaque(true);
		setBackground(Color.PINK);

		card = new CardLayout();
		setLayout(card);

		this.buttons = buttons;
		this.parent = parent;

		initPanel();
	}

	private void initPanel() {
		songListPanel = new SongListPanel("Ĭ���б�");
		songListPanel.addPopupMenuToTree();

		cloudsPanel = new SongListPanel("Ĭ���б�", "��ϲ��");
		cloudsPanel.addPopupMenuToTree();

		downloadPanel = new SongListPanel("������", "������");

		historyPanel = new SongListPanel("�������");

		add(songListPanel, "0");
		add(cloudsPanel, "1");
		add(downloadPanel, "2");
		add(historyPanel, "3");

		setAction();
	}

	private void setAction() {

		for (int i = 0; i < buttons.length; i++) {
			int k = i;
			buttons[i].addActionListener(event -> {
				card.show(this, "" + k);
			});
		}

	}

	public void deliverHigherPlayer(HigherPlayer HigherPlayer) {
		songListPanel.setPlayer(HigherPlayer);
		cloudsPanel.setPlayer(HigherPlayer);
		downloadPanel.setPlayer(HigherPlayer);
		historyPanel.setPlayer(HigherPlayer);
	}

	public JTree[] deliverTree() {
		return new JTree[] { songListPanel.getTree(), cloudsPanel.getTree(),
				downloadPanel.getTree(),historyPanel.getTree() };
	}
}
