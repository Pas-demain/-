package com.hubPlayer.denglu;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.SubstanceLookAndFeel;

import com.hubPlayer.ui.HubFrame;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			new Denglu();
		});

	}

}
