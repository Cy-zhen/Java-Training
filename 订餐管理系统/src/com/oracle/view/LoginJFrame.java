package com.oracle.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.oracle.entity.User;
import com.oracle.tool.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passWordTxt;
	UserService us = new UserService();
	static User USER=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
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
	public LoginJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u9910\u5385\u70B9\u9910\u7CFB\u7EDF\u6B22\u8FCE\u60A8");
		label.setIcon(new ImageIcon(LoginJFrame.class.getResource("/images/OrderMeal.png")));
		label.setFont(new Font("幼圆", Font.PLAIN, 17));
		label.setBounds(130, 39, 234, 64);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(LoginJFrame.class.getResource("/images/userName.png")));
		label_1.setBounds(130, 131, 68, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(LoginJFrame.class.getResource("/images/password.png")));
		lblNewLabel.setBounds(130, 176, 68, 15);
		contentPane.add(lblNewLabel);
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(237, 128, 107, 21);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		passWordTxt = new JPasswordField();
		passWordTxt.setBounds(237, 173, 107, 21);
		contentPane.add(passWordTxt);
		/**
		 * 登录验证
		 */
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = userNameTxt.getText();
				String pass = passWordTxt.getText();
				User u = us.loginAuthentication(name, pass);
				if (u!=null) {
					USER=u;//将用户信息储存
					JOptionPane.showMessageDialog(null, "登录成功");
					//跳转主页
					turnToMain();
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误,请重新输入");
					return;
				}
			}

			
		});
		button.setIcon(new ImageIcon(LoginJFrame.class.getResource("/images/login.png")));
		button.setBounds(78, 242, 93, 23);
		contentPane.add(button);
		/**
		 * 重置按钮
		 */
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNameTxt.setText("");
				passWordTxt.setText("");
			}
		});
		button_1.setIcon(new ImageIcon(LoginJFrame.class.getResource("/images/reset.png")));
		button_1.setBounds(205, 242, 93, 23);
		contentPane.add(button_1);
		/**
		 * 注册用户
		 */
		JButton button_2 = new JButton("\u6CE8\u518C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
				
			}
		});
		button_2.setIcon(new ImageIcon(LoginJFrame.class.getResource("/images/register.png")));
		button_2.setBounds(326, 242, 93, 23);
		contentPane.add(button_2);
		setLocationRelativeTo(null);
	}

	/**
	 * 跳转注册页
	 */
	protected void register() {
		this.dispose();//隐藏
		//创建一个注册页并且显示
		new RegisterJFrame().setVisible(true);
	}
	
	public  void turnToMain() {
		this.dispose();//隐藏
		new MainJFrame().setVisible(true);
	}
	
	
	
}
