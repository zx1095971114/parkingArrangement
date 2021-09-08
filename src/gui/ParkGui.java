package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.graalvm.compiler.asm.Label;

import allInerface.DataBase;
import allInerface.Judge;
import dataBase.DataBaseImplement;
import outPark.OutPrepare;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class ParkGui extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField pathTextField;
	private JLabel lblPicture;
	private JLabel lblCar_id;
	private JLabel lblScreen;
	private JLabel lblFee;
	private JLabel lblOutTime;
	private JLabel lblInTime;
	private boolean isIn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkGui frame = new ParkGui();
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
	public ParkGui() {
		setResizable(false);
		setTitle("停车场出入管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1235, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnOut = new JButton("车辆出场");
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				outActionPerformed(event);
			}
		});
		btnOut.setFont(new Font("宋体", Font.BOLD, 30));
		
		JButton btnSure = new JButton("车辆确认");
		btnSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				okActionPerformed(event);
			}
		});
		btnSure.setFont(new Font("宋体", Font.BOLD, 30));
		
		pathTextField = new JFormattedTextField();
		pathTextField.setFont(new Font("宋体", Font.BOLD, 30));
		
		lblPicture = new JLabel("");
		lblPicture.setIcon(null);
		
		
		lblScreen = new JLabel("");
		lblScreen.setIcon(null);
		
		JLabel lblScreenCarId = new JLabel("识别出的车牌号");
		lblScreenCarId.setFont(new Font("宋体", Font.BOLD, 20));
		
		lblCar_id = new JLabel("");
		lblCar_id.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btncharged = new JButton("已收费");
		btncharged.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				chargedActionPerformed(event);
			}
		});
		btncharged.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel lblScreenFee = new JLabel("停车费");
		lblScreenFee.setFont(new Font("宋体", Font.BOLD, 30));
		
		lblFee = new JLabel("");
		lblFee.setFont(new Font("宋体", Font.BOLD, 30));
		lblFee.setForeground(Color.RED);
		
		JButton btnIn = new JButton("车辆入场");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				inActionPerformed(event);
			}
		});
		btnIn.setFont(new Font("宋体", Font.BOLD, 30));
		
		JButton btnReset = new JButton("重置");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				resetActionPerformed(event);
			}
		});
		btnReset.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel lblScreenPath = new JLabel("图片路径");
		lblScreenPath.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel lblScreenOutTime = new JLabel("出场时间");
		lblScreenOutTime.setFont(new Font("宋体", Font.BOLD, 20));
		
		lblOutTime = new JLabel("");
		lblOutTime.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblScreenInTime = new JLabel("入场时间");
		lblScreenInTime.setFont(new Font("宋体", Font.BOLD, 20));
		
		lblInTime = new JLabel("");
		lblInTime.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblScreenInTime, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPicture, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblScreenOutTime, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
											.addComponent(lblScreenCarId, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblOutTime, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblCar_id, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblInTime, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))))
								.addGap(29))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnIn)
								.addGap(18)
								.addComponent(btnOut)
								.addGap(25)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
								.addGap(43))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblScreenPath, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(pathTextField, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblScreenFee, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSure, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
							.addGap(93)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFee, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
								.addComponent(btncharged, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
							.addGap(91))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblScreen, GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblScreenInTime, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInTime, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblScreenOutTime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblOutTime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCar_id)
								.addComponent(lblScreenCarId, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPicture, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
							.addGap(32))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblScreen, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(pathTextField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblScreenFee, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblScreenPath, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(30))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblFee, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnSure, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btncharged, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
								.addGap(56))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnIn, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnOut, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
								.addContainerGap()))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}

	/*
	 * 点击车辆入场按钮的操作
	 * 无法解决非法入场路径输入问题
	 */
	protected void inActionPerformed(ActionEvent event) {
		//获取图片路径
		//要识别的路径为C:\大学\大三\软件工程综合实践\停车场出入管理系统\src\inCars\1.jpg
		//要显示的路径为/outCars/3.jpg
		//输入的是3.jpg
		String distiguishPath = null;
		String performPath = null;
		String path = null;
		path = pathTextField.getText();
		
		//得到识别图片路径,显示图片路径
		distiguishPath = "C:\\大学\\大三\\软件工程综合实践\\停车场出入管理系统\\src\\inCars\\" + path;
		performPath = "/inCars/" + path;
		
		if(path.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入图片路径");
		}
		else {
			
			//显示图片
			ImageIcon picture = new ImageIcon(ParkGui.class.getResource(performPath));
			lblPicture.setIcon(picture);
			//显示车牌
			String car_id = Judge.judge(distiguishPath);
			lblCar_id.setText(car_id);
			//显示入场时间
			String in_timestamp = DataBase.getNowTimestamp();
			lblInTime.setText(in_timestamp);
	
			//将isIn设为true
			this.isIn = true;
		}
	}

	/*
	 * 点击已收费的操作
	 */
	protected void chargedActionPerformed(ActionEvent event) {
		DataBase db = new DataBaseImplement();
		String outCar_id = lblCar_id.getText();
		String fee = lblFee.getText();
		//数据录入history
		
		//获得入场时间
		String inTime = lblInTime.getText();

		//向history表中存入信息
		String out_timestamp = lblOutTime.getText();
		String sql1 = "insert into history values (\'" + outCar_id + "\', \'" + fee + "\',\'" + inTime + "\',\'" + out_timestamp + "\')";
		if(db.add_update_delete(sql1) ) {
		
			//更改now_position的信息
			int now_position = DataBase.getNow_position();
			now_position++;
			String newNow_position = String.valueOf(now_position);
			String sql2 = "update position_num set now_position = " + newNow_position;
			if(db.add_update_delete(sql2) ) {
				
				//删status中信息
				String sql3 = "delete from status where car_id = \'" + outCar_id + "\'";
				if(db.add_update_delete(sql3)) {
					//显示出场图片
					ImageIcon picture = new ImageIcon(ParkGui.class.getResource("/screenPicture/out.jpg"));
					lblScreen.setIcon(picture);
				}
				else {
					JOptionPane.showMessageDialog(null, "点击已收费时status信息删除失败，请联系管理员解决");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "点击已收费时now_position修改信息失败，请联系管理员解决");
			}
		}
		else {
			if(pathTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请输入图片路径");
			}
			else {
				JOptionPane.showMessageDialog(null, "点击已收费时history存入信息失败，请联系管理员解决");
			}
		}
		
	}

	/*
	 * 点击车辆确认按钮的操作
	 */
	protected void okActionPerformed(ActionEvent event) {
		if(pathTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "请输入图片路径");
		}
		else {
			//获取识别的车牌
			String car_id = lblCar_id.getText();
			
			//判断是入场还是出场
			if(this.isIn) {
				//入场
				//判断vip
				//是vip，显示入场图片
				if(Judge.isVip(car_id)) {
					ImageIcon picture = new ImageIcon(ParkGui.class.getResource("/screenPicture/in.jpg"));
					lblScreen.setIcon(picture);
					
				}
				//不是vip，判断是否可入
				else {
					//获取now_position信息
					int now_position = DataBase.getNow_position();
					
					//判断车位是否已满
					if(now_position <= 0) {
						//显示车位已满的图片
						ImageIcon picture = new ImageIcon(ParkGui.class.getResource("/screenPicture/full.jpg"));
						lblScreen.setIcon(picture);
					}
					else {
						DataBase db = new DataBaseImplement();
						//向status表中存入信息
						String inCar_id = lblCar_id.getText();
						String in_timestamp = lblInTime.getText();
						String sql0 = "insert into status values (\'" + inCar_id + "\', \'" + in_timestamp + "\')";
						if(db.add_update_delete(sql0) ) {
						
							//更改now_position的信息
							now_position--;
							String newNow_position = String.valueOf(now_position);
							String sql1 = "update position_num set now_position = " + newNow_position;
							if(db.add_update_delete(sql1) ) {
								//显示入场图片
								ImageIcon picture = new ImageIcon(ParkGui.class.getResource("/screenPicture/in.jpg"));
								lblScreen.setIcon(picture);
							}
							else {
								JOptionPane.showMessageDialog(null, "车辆确认时修改now_position信息失败，请联系管理员解决");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "车辆确认时status存入信息失败，请联系管理员解决");
						}
					}
				}
			}
			
			
			else {
				//出场
				//判断vip
				//是VIP，显示出场图片
				if(Judge.isVip(car_id)) {
					ImageIcon picture = new ImageIcon(ParkGui.class.getResource("/screenPicture/out.jpg"));
					lblScreen.setIcon(picture);
				}
				//不是VIP，显示停车费
				else {
					double fee = OutPrepare.getFee(car_id);
					DecimalFormat df = new DecimalFormat("0.00");
					lblFee.setText(df.format(fee));
					
				}
			}
		
		}
		
	}

	/*
	 * 点击车辆出场按钮的操作
	 * 
	 */
	protected void outActionPerformed(ActionEvent event) {
		//获取图片路径
		//要识别的路径为C:\大学\大三\软件工程综合实践\停车场出入管理系统\src\outCars\1.jpg
		//要显示的路径为/outCars/3.jpg
		//输入的是3.jpg
		String distiguishPath = null;
		String performPath = null;
		String path = null;
		path = pathTextField.getText();
		
		//获取显示和识别路径
		distiguishPath = "C:\\大学\\大三\\软件工程综合实践\\停车场出入管理系统\\src\\outCars\\" + path;
		performPath = "/outCars/" + path;
		
		if(pathTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "请输入图片路径");
		}
		else {
			String car_id = Judge.judge(distiguishPath);
			//显示入场时间
			DataBase db = new DataBaseImplement();
			String sql0 = "select in_timestamp from status where car_id = \'" + car_id + "\'";
			String[] columns0 = {"in_timestamp"};
			List<Map<String,String>> list0 = db.executeQuery(sql0, columns0);
			String inTime = null;
			for (Map<String, String> map : list0) {
				inTime = map.get("in_timestamp");
			}
			if(inTime == null) {
				JOptionPane.showMessageDialog(null, "该车未录入停车场入场记录，请让车主配合调查");
			}
			else {
				lblInTime.setText(inTime);
				
				//显示图片
				ImageIcon picture = new ImageIcon(ParkGui.class.getResource(performPath));
				lblPicture.setIcon(picture);
				//显示车牌
				lblCar_id.setText(car_id);
				
				
				//显示出场时间
				String out_timestamp = DataBase.getNowTimestamp();
				lblOutTime.setText(out_timestamp);
				
				//将isIn设为false
				isIn = false;
			}
		}
	}
	
	/*
	 * 清除所有内容
	 */
	protected void resetActionPerformed(ActionEvent event) {
		lblCar_id.setText("");
		lblFee.setText("");
		lblPicture.setIcon(null);
		lblScreen.setIcon(null);
		lblInTime.setText("");
		lblOutTime.setText("");
		pathTextField.setText("");
	}
}
