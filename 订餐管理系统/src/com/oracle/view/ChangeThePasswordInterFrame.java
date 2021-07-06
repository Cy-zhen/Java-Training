package com.oracle.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.oracle.tool.Tools;
import com.oracle.tool.UserService;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeThePasswordInterFrame extends JInternalFrame {
	private JTextField usernameTxt;
	private JPasswordField oldpassTxt;
	private JPasswordField newPass1Txt;
	private JPasswordField newPassTxt2;
	Tools tool = new Tools();
	UserService us = new UserService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeThePasswordInterFrame frame = new ChangeThePasswordInterFrame();
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
	public ChangeThePasswordInterFrame() {
		setClosable(true);
		setBounds(100, 100, 406, 414);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D:");
		label.setBounds(112, 59, 54, 15);
		getContentPane().add(label);
		
		usernameTxt = new JTextField();
		usernameTxt.setEditable(false);
		usernameTxt.setBounds(176, 56, 93, 21);
		getContentPane().add(usernameTxt);
		usernameTxt.setColumns(10);
		usernameTxt.setText(LoginJFrame.USER.getName());
		
		JLabel label_1 = new JLabel("\u65E7\u5BC6\u7801:");
		label_1.setBounds(112, 107, 54, 15);
		getContentPane().add(label_1);
		
		oldpassTxt = new JPasswordField();
		oldpassTxt.setBounds(176, 104, 93, 21);
		getContentPane().add(oldpassTxt);
		
		JLabel label_2 = new JLabel("\u65B0\u5BC6\u7801:");
		label_2.setBounds(112, 154, 54, 15);
		getContentPane().add(label_2);
		
		newPass1Txt = new JPasswordField();
		newPass1Txt.setBounds(176, 151, 93, 21);
		getContentPane().add(newPass1Txt);
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801:");
		label_3.setBounds(112, 202, 54, 15);
		getContentPane().add(label_3);
		
		newPassTxt2 = new JPasswordField();
		newPassTxt2.setBounds(176, 199, 93, 21);
		getContentPane().add(newPassTxt2);
		/**
		 * 修改密码
		 */
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = usernameTxt.getText();
				String oldpass = oldpassTxt.getText();
				String newpass1 = newPass1Txt.getText();
				String newpass2 = newPassTxt2.getText();
				if (!LoginJFrame.USER.getPassWord().equals(oldpass)) {
					JOptionPane.showMessageDialog(null, "密码输入错误");
					return;
				}
				if (tool.isEmpty(newpass1)) {
					JOptionPane.showMessageDialog(null, "新密码不能为空");
					return;
				}
				if (!newpass1.equals(newpass2)) {
					JOptionPane.showMessageDialog(null, "两次密码不一致,请核对后再尝试");
					return;
				}
				us.updatePasswordByName(name, newpass1);
				JOptionPane.showMessageDialog(null, "修改成功");
				
			}
		});
		button.setBounds(73, 285, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(203, 285, 93, 23);
		getContentPane().add(button_1);
		
	}

}
