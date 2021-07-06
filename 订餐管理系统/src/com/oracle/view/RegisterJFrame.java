package com.oracle.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.oracle.entity.User;
import com.oracle.tool.Tools;
import com.oracle.tool.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class RegisterJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passWordTxt;
	private JPasswordField passWordTxt2;
	private JTextField emailTxt;
	Tools tool = new Tools();
	
	UserService us = new UserService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterJFrame frame = new RegisterJFrame();
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
	public RegisterJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u65B0\u7528\u6237\u6CE8\u518C");
		label.setIcon(new ImageIcon(RegisterJFrame.class.getResource("/images/new_register.png")));
		label.setFont(new Font("幼圆", Font.PLAIN, 18));
		label.setBounds(144, 55, 153, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(RegisterJFrame.class.getResource("/images/new_user.png")));
		label_1.setBounds(107, 134, 70, 15);
		contentPane.add(label_1);
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(203, 131, 110, 21);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(RegisterJFrame.class.getResource("/images/new_password.png")));
		label_2.setBounds(107, 165, 70, 15);
		contentPane.add(label_2);
		
		passWordTxt = new JPasswordField();
		passWordTxt.setBounds(203, 162, 110, 21);
		contentPane.add(passWordTxt);
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon(RegisterJFrame.class.getResource("/images/password_config.png")));
		label_3.setBounds(107, 199, 86, 15);
		contentPane.add(label_3);
		
		passWordTxt2 = new JPasswordField();
		passWordTxt2.setBounds(203, 196, 110, 21);
		contentPane.add(passWordTxt2);
		
		JLabel label_4 = new JLabel("\u90AE\u7BB1\uFF1A");
		label_4.setIcon(new ImageIcon(RegisterJFrame.class.getResource("/images/email.png")));
		label_4.setBounds(107, 237, 70, 15);
		contentPane.add(label_4);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(203, 234, 110, 21);
		contentPane.add(emailTxt);
		emailTxt.setColumns(10);
		/**
		 * 注册
		 */
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = userNameTxt.getText();
				String pass1 = passWordTxt.getText();
				String pass2 = passWordTxt2.getText();
				String email = emailTxt.getText();
				if (tool.isEmpty(username)) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					return ;
				}
				if (tool.isEmpty(pass1)) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					return ;
				}
				if (!pass1.equals(pass2)) {
					JOptionPane.showMessageDialog(null, "两次输入密码不一致,请核对后再次尝试!");
					return ;
				}
				String regex="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(email);
				if (!m.matches()) {
					JOptionPane.showMessageDialog(null, "邮箱格式错误");
					return ;
				}
				User u = new User();
				u.setId(UUID.randomUUID().toString());
				u.setName(username.trim());
				u.setPassWord(pass1.trim());
				u.setEmail(email.trim());
				boolean success = us.insertUser(u);
				if (success) {
					JOptionPane.showMessageDialog(null, "注册成功");
					//跳转页面
					login();
				} else {
					JOptionPane.showMessageDialog(null, "用户名已存在,请重新输入");
					return;
				}
				
			}
		});
		button.setBounds(100, 283, 93, 23);
		contentPane.add(button);
		/**
		 * 重置按钮
		 */
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNameTxt.setText("");
				passWordTxt.setText("");
				passWordTxt2.setText("");
				emailTxt.setText("");
			}
		});
		button_1.setBounds(289, 283, 93, 23);
		contentPane.add(button_1);
		setLocationRelativeTo(null);
	}

	/**
	 * 跳转登录页
	 */
	protected void login() {
		this.dispose();
		new LoginJFrame().setVisible(true);
		
	}

}
