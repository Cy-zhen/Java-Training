package com.oracle.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterJframe extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JTextField emailTxt;
	private JPasswordField passWordTxt;
	private JPasswordField passWordTxt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterJframe frame = new RegisterJframe();
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
	public RegisterJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新用户注册");
		lblNewLabel.setIcon(new ImageIcon(RegisterJframe.class.getResource("/images/new_register.png")));
		lblNewLabel.setFont(new Font("KufiStandardGK", Font.PLAIN, 14));
		lblNewLabel.setBounds(159, 18, 136, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		lblNewLabel_1.setIcon(new ImageIcon(RegisterJframe.class.getResource("/images/new_user.png")));
		lblNewLabel_1.setBounds(132, 78, 76, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密码：");
		lblNewLabel_2.setIcon(new ImageIcon(RegisterJframe.class.getResource("/images/new_password.png")));
		lblNewLabel_2.setBounds(132, 107, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(215, 73, 130, 26);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("确认密码：");
		lblNewLabel_3.setIcon(new ImageIcon(RegisterJframe.class.getResource("/images/password_config.png")));
		lblNewLabel_3.setBounds(132, 135, 85, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("邮箱：");
		lblNewLabel_4.setIcon(new ImageIcon(RegisterJframe.class.getResource("/images/email.png")));
		lblNewLabel_4.setBounds(132, 168, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(215, 163, 130, 26);
		contentPane.add(emailTxt);
		emailTxt.setColumns(10);
		
		passWordTxt = new JPasswordField();
		passWordTxt.setBounds(215, 101, 130, 26);
		contentPane.add(passWordTxt);
		
		passWordTxt2 = new JPasswordField();
		passWordTxt2.setBounds(215, 132, 130, 26);
		contentPane.add(passWordTxt2);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.setBounds(164, 202, 85, 29);
		contentPane.add(btnNewButton);
		/*
		 * 重置
		 */
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNameTxt.setText("");
				passWordTxt.setText("");
				passWordTxt2.setText("");
				emailTxt.setText("");
			}
		});
		btnNewButton_1.setBounds(250, 202, 85, 29);
		contentPane.add(btnNewButton_1);
	}

}
