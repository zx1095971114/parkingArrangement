package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import allInerface.DataBase;
import dataBase.DataBaseImplement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class SearchGui extends JFrame {

	private JPanel contentPane;
	private JTable statusTable;
	private JTable historyTable;
	private JTextField statusStartTimeTextField;
	private JTextField StatusEndTimeTextField;
	private JTextField historyStartTimeTextField;
	private JTextField historyEndTimeTextField;
	private JLabel lblFee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGui frame = new SearchGui();
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
	public SearchGui() {
		setResizable(false);
		setTitle("停车场出入管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPaneStatus = new JScrollPane();
		
		JScrollPane scrollPaneHistory = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("实时状态");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("历史记录");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		statusStartTimeTextField = new JTextField();
		statusStartTimeTextField.setFont(new Font("宋体", Font.BOLD, 18));
		statusStartTimeTextField.setColumns(10);
		
		StatusEndTimeTextField = new JTextField();
		StatusEndTimeTextField.setFont(new Font("宋体", Font.BOLD, 18));
		StatusEndTimeTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("起始时间");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_2_1 = new JLabel("截止时间");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_2_2 = new JLabel("起始时间");
		lblNewLabel_2_2.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("截止时间");
		lblNewLabel_2_1_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		historyStartTimeTextField = new JTextField();
		historyStartTimeTextField.setFont(new Font("宋体", Font.BOLD, 18));
		historyStartTimeTextField.setColumns(10);
		
		historyEndTimeTextField = new JTextField();
		historyEndTimeTextField.setFont(new Font("宋体", Font.BOLD, 18));
		historyEndTimeTextField.setColumns(10);
		
		JButton btnStatusSearch = new JButton("实时查询");
		btnStatusSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatusSearchActionPerformed(e);
			}
		});
		btnStatusSearch.setFont(new Font("宋体", Font.BOLD, 20));
		btnStatusSearch.setForeground(new Color(0, 0, 0));
		
		JButton btnHistorySearch = new JButton("历史查询");
		btnHistorySearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historyActionPerformed(e);
			}
		});
		btnHistorySearch.setForeground(Color.BLACK);
		btnHistorySearch.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnNewButton_1_1 = new JButton("收费查询");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargedActionPerformed(e);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		lblFee = new JLabel("");
		lblFee.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_3_1 = new JLabel("总金额");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		JButton btnReturn = new JButton("返回");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed();
			}
		});
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(182)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(365)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(242, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(statusStartTimeTextField, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(StatusEndTimeTextField, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnStatusSearch))
							.addGap(77))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPaneStatus, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(historyEndTimeTextField, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnHistorySearch, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(historyStartTimeTextField, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblFee, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnNewButton_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnReturn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(scrollPaneHistory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPaneStatus, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPaneHistory, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(statusStartTimeTextField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(StatusEndTimeTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblFee, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addComponent(historyStartTimeTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(historyEndTimeTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStatusSearch, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnHistorySearch, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		
		historyTable = new JTable();
		historyTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8F66\u724C\u53F7", "\u505C\u8F66\u8D39", "\u5165\u573A\u65F6\u95F4", "\u51FA\u573A\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		historyTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		historyTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		historyTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		scrollPaneHistory.setViewportView(historyTable);
		
		statusTable = new JTable();
		statusTable.setBackground(Color.WHITE);
		statusTable.setFont(new Font("宋体", Font.BOLD, 15));
		statusTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8F66\u724C\u53F7", "\u5165\u573A\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		statusTable.getColumnModel().getColumn(0).setPreferredWidth(47);
		statusTable.getColumnModel().getColumn(1).setPreferredWidth(131);
		scrollPaneStatus.setViewportView(statusTable);
		contentPane.setLayout(gl_contentPane);
	}
	
	/*
	 * 收费查询按钮操作
	 */
	protected void chargedActionPerformed(ActionEvent e) {
		//查表
		DataBase db = new DataBaseImplement();
		String in_timestamp = historyStartTimeTextField.getText();
		String out_timestamp = historyEndTimeTextField.getText();
		String[] columns = {"charged_fee"};
		String sql = "select charged_fee from history where in_timestamp > \'" + in_timestamp + "\' and out_timestamp < \'" + out_timestamp + "\'";
		List<Map<String,String>> list = db.executeQuery(sql, columns);
		//计算总金额
		double fee = 0.00;
		for(Map<String,String> map : list) {
			fee = fee + Double.valueOf(map.get("charged_fee") );
		}
		
		//将费用保留2位小数
		DecimalFormat df = new DecimalFormat("0.00");
		
		lblFee.setText(df.format(fee));
	}

	/*
	 * 历史查询按钮操作
	 */
	protected void historyActionPerformed(ActionEvent e) {
		DefaultTableModel dtm = (DefaultTableModel) historyTable.getModel();
		//初始化表格
		dtm.setRowCount(0);
		//查表
		DataBase db = new DataBaseImplement();
		String in_timestamp = historyStartTimeTextField.getText();
		String out_timestamp = historyEndTimeTextField.getText();
		String[] columns = {"car_id","charged_fee","in_timestamp","out_timestamp"};
		String sql = "select car_id,charged_fee,in_timestamp,out_timestamp from history where in_timestamp > \'" + in_timestamp + "\' and out_timestamp < \'" + out_timestamp + "\'";
		List<Map<String,String>> list = db.executeQuery(sql, columns);
		for(Map<String,String> map : list) {
				//将费用保留2位小数
				DecimalFormat df = new DecimalFormat("0.00");
				Double fee = Double.valueOf(map.get("charged_fee") );
				String feeString = df.format(fee);
				//显示
				Vector<String> v = new Vector<>();
				v.add(map.get("car_id"));
				v.add(feeString);
				v.add(map.get("in_timestamp"));
				v.add(map.get("out_timestamp"));
				dtm.addRow(v);
		}
	}

	/*
	 * 实时查询按钮操作
	 */
	protected void StatusSearchActionPerformed(ActionEvent event) {
		DefaultTableModel dtm = (DefaultTableModel) statusTable.getModel();
		//初始化表格
		dtm.setRowCount(0);
		//查表
		DataBase db = new DataBaseImplement();
		String startTime = statusStartTimeTextField.getText();
		String endTime = StatusEndTimeTextField.getText();
		String sql = "select * from status where in_timestamp > \'" + startTime + "\' and in_timestamp < \'" + endTime + "\'";
		String[] columns = {"car_id", "in_timestamp"};
		List<Map<String,String>> list = db.executeQuery(sql, columns);
		//放数
		for (Map<String,String> map : list) {
			Vector<String> performedList = new Vector<>();
			performedList.add(map.get("car_id"));
			performedList.add(map.get("in_timestamp"));
			dtm.addRow(performedList);
		}
	}

	/*
	 * 返回按钮操作
	 */
	protected void returnActionPerformed() {
		this.dispose();
		new ArrangementMainGui().setVisible(true);
		
	}
}
