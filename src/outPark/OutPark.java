/*
 * 出场程序的main()方法所在类
 */
package outPark;

import java.text.DecimalFormat;
import java.util.*;

import allInerface.DataBase;
import allInerface.Judge;
import dataBase.DataBaseImplement;
import inPark.Preparing;


public class OutPark {
//	public static  int parkingtime = 0;

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("请输入出场命令:");
			String command = scan.nextLine();
			//输入"out"开始入场模拟
			if(command.equals("out")) {
				//获取出场车车牌
				System.out.println("请输入要入场车辆的图片路径");
				String resouce = scan.nextLine();
				
				//此处写judge要用到的文件夹路径
				String destination = "";
				
				String outCar_id = Judge.preparingCar_id(resouce, destination);
				
				//判断入场车牌是否合法
				if(!DataBase.isCarId(outCar_id)) {
					System.out.println("车牌识别错误，非法车牌");
					System.out.println("本车辆出场模拟结束，若要再入场请再次键入\"out\",若要退出，请键入\"quit\"");
					continue;
				}
				
				//判断是否是固定车
				if(Judge.isVip(outCar_id)) {
					System.out.println("一路顺风");
					System.out.println("本车辆出场模拟结束，若要再入场请再次键入\"out\",若要退出，请键入\"quit\"");
					continue;
				}
				else {
					//显示车费
					double fee = OutPrepare.getFee(outCar_id);
					//费用保留2位小数
					DecimalFormat df = new DecimalFormat("0.00");
					System.out.println("请支付：" + df.format(fee) + "元");
					
					//收钱(读到"charged"字符串)
					while(true) {
						String charged = scan.nextLine();
						if(charged.equals("charged") ) {
							break;
						}
						else {
							System.out.println("请您按屏幕金额缴纳费用");
						}
					}
					
					DataBase db = new DataBaseImplement();
					
					//数据录入history
					
					//获得入场时间
					String sql0 = "select in_timestamp from status where car_id = \'" + outCar_id + "\'";
					String[] columns0 = {"in_timestamp"};
					List<Map<String,String>> list0 = db.executeQuery(sql0, columns0);
					String inTime = null;
					for (Map<String, String> map : list0) {
						inTime = map.get("in_timestamp");
					}
					
					
					//向history表中存入信息
					String out_timestamp = DataBase.getNowTimestamp();
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
								System.out.println("一路顺风！");
								System.out.println("本车辆出场模拟结束，若要再出场请再次键入\"out\",若要退出，请键入\"quit\"");
								continue;
							}
						
						}
					}
					System.out.println("数据库更新失败，请联系管理员查找问题");
					break;
					
				}
				
			}
			
			//退出入场模拟
			else if(command.equals("quit")) {
				scan.close();
				
				break;
			}
			
			//帮助
			else if (command.equals("help")) {
				System.out.println("out:模拟车辆出场");
				System.out.println("help:输出帮助信息");
				System.out.println("quit:退出程序");
				continue;
			}
			
			//错误命令提醒
			else {
				System.out.println("命令错误，键入\"help\"获取帮助信息");
				continue;
			}
		}
		
		System.out.println("退出成功");
	}
	
}
//   fileaction.copyFile(srting carParking/1.jpg, string carReady/1.jpg);
//  
//   //urc(get String carID = id);
//   //查是否固定车
//   
//  
//			String sql = "select 'car_id' from uip";
//			String[] columns = {"car_id"};
//			DataBase db = new DataBaseImplement();
//			
//			List<Map<String, String>> list = db.executeQuery(sql, columns);
//			
//			
//			String id;
//			
//			for(Map<String, String> map : list) {
//				Set<Map.Entry<String, String>> set = map.entrySet();
//				for(Map.Entry<String, String> m : set) {
//					if(m.getValue().equals(id))
//					{
//						 System.out.println("一路顺风");
//					
//					}
//	   else {
//		   //读取set接口，获得停放时间parkingtime
//		   
//
//			String sql2 = "select 'car_id','in_timestamp','out_timestamp' from nuip";
//			String[] columns2 = {"car_id","in_timestamp","out_timestamp"};
//			DataBase db2 = new DataBaseImplement();
//			
//			List<Map<String, String>> list2 = db2.executeQuery(sql2, columns2);
//			//只查询了三个map表，不知道怎么联系起来。
//			
//			
//		   System.out.println(pay.count(parkingtime)+"元");
//	   
//	   //获取管理员输入
//	   String rightans ="charged";
//	   Scanner input = new Scanner (System.in);
//	   
//	   String ans = input.next();
//	   
//	   while(ans.equals(rightans)) {
//	   System.out.println("一路顺风");
//	   
//   }
//   }
//
//   
//
//}
//		}
//
//	
//	}