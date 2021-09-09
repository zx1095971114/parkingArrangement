package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import allInerface.DataBase;
import dataBase.DataBaseImplement;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class ChangeGui extends JFrame {

	private JPanel contentPane;
	private JTable VipTable;
	private JTextField vipCar_idTextField;
	private JTextField all_positionTextField;
	private JTextField FeeTextField;
	private JLabel lblAll_position;
	private JLabel lblNow_position;
	private JLabel lblFee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeGui frame = new ChangeGui();
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
	public ChangeGui() {
		setTitle("停车场出入管理系统");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("VIP车辆");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		vipCar_idTextField = new JTextField();
		vipCar_idTextField.setFont(new Font("宋体", Font.BOLD, 20));
		vipCar_idTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("增加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addVipActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnDeleteVipCar_id = new JButton("删除");
		btnDeleteVipCar_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteVipCar_idActionPerformed(e);
			}
		});
		btnDeleteVipCar_id.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("总停车位");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_1_1 = new JLabel("可停车位");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		lblAll_position = new JLabel("");
		lblAll_position.setFont(new Font("宋体", Font.BOLD, 15));
		
		lblNow_position = new JLabel("");
		lblNow_position.setFont(new Font("宋体", Font.BOLD, 15));
		
		JButton btnPosition_numSearch = new JButton("查询");
		btnPosition_numSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position_numSearchActionPerformed(e);
			}
		});
		btnPosition_numSearch.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnAll_positionChange = new JButton("修改");
		btnAll_positionChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				all_positionChangeActionPerformed(e);
			}
		});
		btnAll_positionChange.setFont(new Font("宋体", Font.BOLD, 20));
		
		all_positionTextField = new JTextField();
		all_positionTextField.setFont(new Font("宋体", Font.BOLD, 15));
		all_positionTextField.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("费率");
		lblNewLabel_1_3.setFont(new Font("宋体", Font.BOLD, 20));
		
		lblFee = new JLabel("");
		lblFee.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnSearchFee = new JButton("查询");
		btnSearchFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFeeActionPerformed(e);
			}
		});
		btnSearchFee.setFont(new Font("宋体", Font.BOLD, 20));
		
		FeeTextField = new JTextField();
		FeeTextField.setFont(new Font("宋体", Font.BOLD, 20));
		FeeTextField.setColumns(10);
		
		JButton btnChangeFee = new JButton("修改");
		btnChangeFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeFeeActionPerformed(e);
			}
		});
		btnChangeFee.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnReturn = new JButton("返回");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnReturn.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_4 = new JLabel("总停车位");
		lblNewLabel_1_4.setFont(new Font("宋体", Font.BOLD, 15));
		
		JButton btnSearchVip = new JButton("查询");
		btnSearchVip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchVipActionPerformed(e);
			}
		});
		btnSearchVip.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
									.addComponent(btnDeleteVipCar_id, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
								.addComponent(vipCar_idTextField, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSearchVip, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(52)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(all_positionTextField)
								.addComponent(lblAll_position, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
								.addComponent(lblNow_position, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(lblNewLabel_1_3)
							.addGap(18)
							.addComponent(lblFee, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(FeeTextField, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addGap(27)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSearchFee, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPosition_numSearch, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAll_positionChange, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChangeFee, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addGap(56))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(113)
					.addComponent(lblNewLabel)
					.addContainerGap(445, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnSearchVip, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAll_position, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNow_position, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
									.addGap(27)
									.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFee, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSearchFee, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(btnPosition_numSearch, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAll_positionChange, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(all_positionTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(107)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnChangeFee, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(vipCar_idTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDeleteVipCar_id, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
						.addComponent(FeeTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		VipTable = new JTable();
		VipTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8F66\u724C\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		VipTable.getColumnModel().getColumn(0).setPreferredWidth(111110);
		scrollPane.setViewportView(VipTable);
		contentPane.setLayout(gl_contentPane);
	}

	/*
	 * 更改费率按钮操作
	 */
	protected void changeFeeActionPerformed(ActionEvent event) {
		DataBase db = new DataBaseImplement();
		String fee = FeeTextField.getText();
		
		if(fee.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入要修改的标准");
			return;
		}
		
		//判断fee的值是否大于0
		if(Double.valueOf(fee) < 0) {
			JOptionPane.showMessageDialog(null, "输入的标准不合法，修改收费标准失败");
			return;
		}
		
		if(db.add_update_delete("update money set fee = " + fee) ) {
			JOptionPane.showMessageDialog(null, "修改收费标准成功");
		}
		else {
			JOptionPane.showMessageDialog(null, "修改收费标准失败");
			return;
		}
		
		Double feeDouble = Double.valueOf(fee);
		DecimalFormat df = new DecimalFormat("0.00");
		String feeString = df.format(feeDouble).toString();
		lblFee.setText(feeString);
	}

	/*
	 * 查询费率按钮操作
	 */
	protected void searchFeeActionPerformed(ActionEvent event) {
		DataBase db = new DataBaseImplement();
		String sql = "select * from money";
		String[] columns = {"fee"};
		List<Map<String,String>> list = db.executeQuery(sql, columns);
		
		for (Map<String, String> map : list) {
			DecimalFormat df = new DecimalFormat("0.00");
			Double fee = Double.valueOf(map.get("fee"));
			String feeString = df.format(fee).toString();
			lblFee.setText(feeString);
		}
	}

	/*
	 * 总车位数修改按钮事件
	 */
	protected void all_positionChangeActionPerformed(ActionEvent e) {
		DataBase db = new DataBaseImplement();
		String all_position = all_positionTextField.getText();
		
		//取回原总车位
		int former_all_position = 0;
		String[] columns = {"all_position"};
		List<Map<String,String>> list = db.executeQuery("select all_position from position_num", columns);
		for(Map<String,String> map : list) {
			former_all_position = Integer.valueOf(map.get("all_position"));
		}
		
		//取回原可用车位
		int former_now_position = 0;
		String[] columns2 = {"now_position"};
		List<Map<String,String>> list2 = db.executeQuery("select now_position from position_num", columns2);
		for(Map<String,String> map : list2) {
			former_now_position = Integer.valueOf(map.get("now_position"));
		}
		
		//计算已用车位
		int used_position = former_all_position - former_now_position;
		
		if(db.add_update_delete("update position_num set all_position = " + all_position) ) {
			//计算现可用车位
			int now_position = Integer.valueOf(all_position) - used_position;
			//判断总车位数是否合法
			if(now_position < 0) {
				JOptionPane.showMessageDialog(null, "该总车位数太小，不合实际，修改总车位数失败");
				return;
			}
			
			//修改现可用车位
			db.add_update_delete("update position_num set now_position = " + now_position);
			
			JOptionPane.showMessageDialog(null, "修改总车位数成功");
		}
		else {
			JOptionPane.showMessageDialog(null, "修改总车位数失败");
			return;
		}
		
		String[] columns3 = {"all_position","now_position"};
		List<Map<String,String>> list3 = db.executeQuery("select * from position_num", columns3);
		
		for(Map<String,String> map : list3) {
			lblAll_position.setText(map.get("all_position"));
			lblNow_position.setText(map.get("now_position"));
		}
	}

	/*
	 * 车位查询按钮事件
	 */
	protected void position_numSearchActionPerformed(ActionEvent event) {
		DataBase db = new DataBaseImplement();
		
		String[] columns = {"all_position","now_position"};
		List<Map<String,String>> list = db.executeQuery("select * from position_num", columns);
		
		for(Map<String,String> map : list) {
			lblAll_position.setText(map.get("all_position"));
			lblNow_position.setText(map.get("now_position"));
		}
	}

	/*
	 * Vip删除按钮事件
	 */
	protected void deleteVipCar_idActionPerformed(ActionEvent event) {
		DataBase db = new DataBaseImplement();
		String car_id = vipCar_idTextField.getText();
		
		if(db.add_update_delete("delete from vip where car_id = '" + car_id + "\'") ) {
			//取回now_position
			int now_position = 0;
			String[] columns = {"now_position"};
			List<Map<String,String>> list = db.executeQuery("select now_position from position_num", columns);
			for(Map<String,String> map : list) {
				now_position = Integer.valueOf(map.get("now_position"));
			}
			//修改now_position并将修改同步至数据库
			now_position++;
			db.add_update_delete("update position_num set now_position = " + now_position);
			
			JOptionPane.showMessageDialog(null, "删除成功");
		}
		else {
			JOptionPane.showMessageDialog(null, "删除失败");
			return;
		}
		
		//初始化表
		DefaultTableModel dtm = (DefaultTableModel) VipTable.getModel();
		dtm.setRowCount(0);
		//查询
		String[] columns = {"car_id"};
		List<Map<String,String>> list = db.executeQuery("select car_id from vip", columns);
		
		for(Map<String,String> map : list) {
			String[] obj = {map.get("car_id")};
			dtm.addRow(obj);
		}	
	}

	/*
	 * Vip增加按钮事件
	 */
	protected void addVipActionPerformed(ActionEvent event) {
			DataBase db = new DataBaseImplement();
			String car_id = vipCar_idTextField.getText();
			
			if(!DataBase.isCarId(car_id)) {
				JOptionPane.showMessageDialog(null, "车牌非法，添加失败");
				return;
			}
			
			if(db.add_update_delete("insert into vip values('" + car_id + "')")) {
				//取回now_position
				int now_position = 0;
				String[] columns = {"now_position"};
				List<Map<String,String>> list = db.executeQuery("select now_position from position_num", columns);
				for(Map<String,String> map : list) {
					now_position = Integer.valueOf(map.get("now_position"));
				}
				//修改now_position并将修改同步至数据库
				now_position--;
				db.add_update_delete("update position_num set now_position = " + now_position);
				
				JOptionPane.showMessageDialog(null, "添加成功");
			}
			else {
				JOptionPane.showMessageDialog(null, "添加失败");
				return;
			}
			
			//初始化表
			DefaultTableModel dtm = (DefaultTableModel) VipTable.getModel();
			dtm.setRowCount(0);
			//查询
			String[] columns = {"car_id"};
			List<Map<String,String>> list = db.executeQuery("select car_id from vip", columns);
			
			for(Map<String,String> map : list) {
				String[] obj = {map.get("car_id")};
				dtm.addRow(obj);
			}
		
	}

	/*
	 * Vip查询按钮事件
	 */
	protected void searchVipActionPerformed(ActionEvent e) {
		//初始化表
		DefaultTableModel dtm = (DefaultTableModel) VipTable.getModel();
		dtm.setRowCount(0);
		//查询
		DataBase db = new DataBaseImplement();
		String[] columns = {"car_id"};
		List<Map<String,String>> list = db.executeQuery("select car_id from vip", columns);
		
		for(Map<String,String> map : list) {
			String[] obj = {map.get("car_id")};
			dtm.addRow(obj);
		}
		
	}

	/*
	 * 返回按钮事件
	 */
	protected void returnActionPerformed(ActionEvent e) {
		this.dispose();
		new ArrangementMainGui().setVisible(true);
		
	}
}
