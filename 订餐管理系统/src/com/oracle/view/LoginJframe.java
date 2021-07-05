package com.oracle.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class LoginJframe extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordTxt;
	private JTextField userNameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJframe frame = new LoginJframe();
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
	public LoginJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("餐厅点餐管理系统欢迎您");
		lblNewLabel.setIcon(new ImageIcon(LoginJframe.class.getResource("/images/OrderMeal.png")));
		lblNewLabel.setBounds(138, 6, 233, 69);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		lblNewLabel_1.setIcon(new ImageIcon(LoginJframe.class.getResource("/images/userName.png")));
		lblNewLabel_1.setBounds(138, 100, 72, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密码：");
		lblNewLabel_2.setIcon(new ImageIcon(LoginJframe.class.getResource("/images/password.png")));
		lblNewLabel_2.setBounds(138, 128, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(216, 123, 130, 26);
		contentPane.add(passwordTxt);
		
		JButton btnNewButton = new JButton("登陆");
		btnNewButton.setBounds(145, 186, 72, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.setBounds(218, 186, 84, 26);
		contentPane.add(btnNewButton_1);
		/**
		 * 重置按钮
		 */
		JButton btnNewButton_2 = new JButton("重置");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNameTxt.setText("");
				passwordTxt.setText("");
			}
		});
		btnNewButton_2.setBounds(307, 186, 91, 26);
		contentPane.add(btnNewButton_2);
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(216, 95, 130, 26);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
	}
}
