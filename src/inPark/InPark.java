/*
 * 入场程序的main()方法所在类
 */
package inPark;

import java.util.Date;
import java.util.Scanner;

import allInerface.DataBase;
import allInerface.Judge;
import dataBase.DataBaseImplement;

public class InPark {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("请输入入场命令:");
			String command = scan.nextLine();
			//输入"in"开始入场模拟
			if(command.equals("in")) {
				//获取入场车车牌
				System.out.println("请输入要入场车辆的图片路径");
				String resouce = scan.nextLine();
				
				//此处写judge要用到的文件夹路径
				String destination = "";
				
				String inCar_id = Judge.preparingCar_id(resouce, destination);
				
				//判断入场车牌是否合法
				if(!DataBase.isCarId(inCar_id)) {
					System.out.println("车牌识别错误，非法车牌");
					System.out.println("本车辆入场模拟结束，若要再入场请再次键入\"in\",若要退出，请键入\"quit\"");
					continue;
				}
				
				//判断是否是固定车
				if(Judge.isVip(inCar_id)) {
					System.out.println("欢迎光临！");
					System.out.println("本车辆入场模拟结束，若要再入场请再次键入\"in\",若要退出，请键入\"quit\"");
					continue;
				}
				else {
					//获取now_position信息
					int now_position = DataBase.getNow_position();
					
					//判断车位是否已满
					if(now_position <= 0) {
						System.out.println("车位已满，请耐心等待");
						System.out.println("本车辆入场模拟结束，若要再入场请再次键入\"in\",若要退出，请键入\"quit\"");
						continue;
					}
					else {
						DataBase db = new DataBaseImplement();
						//向status表中存入信息
						String in_timestamp = DataBase.getNowTimestamp();
						String sql0 = "insert into status values (\'" + inCar_id + "\', \'" + in_timestamp + "\')";
						if(db.add_update_delete(sql0) ) {
						
							//更改now_position的信息
							now_position--;
							String newNow_position = String.valueOf(now_position);
							String sql1 = "update position_num set now_position = " + newNow_position;
							if(db.add_update_delete(sql1) ) {
							
								System.out.println("欢迎光临！");
								System.out.println("本车辆入场模拟结束，若要再入场请再次键入\"in\",若要退出，请键入\"quit\"");
								continue;
							}
						}
						System.out.println("数据库更新失败，请联系管理员查找问题");
						break;
					}
				}
				
			}
			
			//退出入场模拟
			else if(command.equals("quit")) {
				
				break;
			}
			
			//帮助
			else if (command.equals("help")) {
				System.out.println("in:模拟车辆入场");
				System.out.println("help:输出帮助信息");
				System.out.println("quit:退出程序");
				continue;
			}
			
			//错误命令提醒
			else {
				System.out.println("入场命令错误，请重新输入");
				continue;
			}
		}
		scan.close();
		System.out.println("退出成功");
	}

}
