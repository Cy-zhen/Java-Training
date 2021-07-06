package com.oracle.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainJFrame extends JFrame {

	private JPanel contentPane;
	JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1019, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("\u5957\u9910\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u65B0\u589E\u5957\u9910");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5957\u9910\u7EF4\u62A4");
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u8BA2\u9910\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u5176\u4ED6");
		menuBar.add(menu_2);
		/**
		 * ÐÞ¸ÄÃÜÂëÒ³
		 */
		JMenuItem menuItem_2 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}

			
		});
		menu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5173\u95ED\u7CFB\u7EDF");
		menu_2.add(menuItem_3);
		
		table = new JDesktopPane();
		table.setBounds(0, 0, 1041, 733);
		contentPane.add(table);
		//ÏÔÊ¾È«ÆÁ
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	/**
	 * Ìø×ªÐÞ¸ÄÃÜÂëÒ³
	 */
	private void changePassword() {
		ChangeThePasswordInterFrame c = new ChangeThePasswordInterFrame();
		c.setVisible(true);
		this.table.add(c);
	}
}
