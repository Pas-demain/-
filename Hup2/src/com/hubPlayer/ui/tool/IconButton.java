package com.hubPlayer.ui.tool;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * ͼƬ��ť
 * 
 */

public class IconButton extends JButton {

	public IconButton(String tip) {
		setToolTipText(tip);
		setBorderPainted(false);
		setOpaque(true);
		setBackground(Color.PINK);
		setContentAreaFilled(false);

	}

	public IconButton(String tip, String imgUrl) {
		this(tip);
		setIcon(new ImageIcon(imgUrl));
	}

	public String toString() {
		return getToolTipText();
	}
}
