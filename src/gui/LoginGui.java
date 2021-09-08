package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGui extends JFrame {

	private JPanel contentPane;
	private JTextField UsrtextField;
	private JPasswordField PswpasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGui frame = new LoginGui();
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
	public LoginGui() {
		setTitle("停车场出入管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		UsrtextField = new JTextField();
		UsrtextField.setFont(new Font("宋体", Font.PLAIN, 25));
		UsrtextField.setColumns(10);
		
		JButton btnReset = new JButton("重置");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				resetActionPerformed();
			}
		});
		btnReset.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel lblUsr = new JLabel("用户名");
		lblUsr.setFont(new Font("宋体", Font.BOLD, 25));
		
		JLabel lblPsw = new JLabel("密码");
		lblPsw.setFont(new Font("宋体", Font.BOLD, 25));
		
		JButton btnLogin = new JButton("登录");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				loginActionPerformed();
			}
		});
		btnLogin.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel lblScreenManagement = new JLabel("管理员登录");
		lblScreenManagement.setFont(new Font("宋体", Font.BOLD, 30));
		
		PswpasswordField = new JPasswordField();
		PswpasswordField.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(147)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPsw, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUsr, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
									.addGap(29)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(PswpasswordField)
										.addComponent(UsrtextField, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(228)
							.addComponent(lblScreenManagement)))
					.addContainerGap(172, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(lblScreenManagement, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsr, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(UsrtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblPsw, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(PswpasswordField)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(91))
		);
		contentPane.setLayout(gl_contentPane);
	}

	/*
	 * 点击登录按钮动作
	 */
	protected void loginActionPerformed() {
		String realUsr = "administrator";
		String realPsw = "123456";
		String usr = UsrtextField.getText();
		String psw = String.valueOf(PswpasswordField.getPassword());
		if(usr.equals("") || psw.equals("")) {
			JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
		}
		else if (usr.equals(realUsr) && psw.equals(realPsw)) {
			this.dispose();
			JFrame arrangementGui = new ArrangementMainGui();
			arrangementGui.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "用户名或密码不正确");
		}
	}
	
	/*
	 * 点击重置按钮动作
	 */
	protected void resetActionPerformed() {
		UsrtextField.setText("");
		PswpasswordField.setText("");
	}
}
