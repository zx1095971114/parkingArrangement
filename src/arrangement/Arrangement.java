/*
 * Arrangement程序，用于实现“停车场管理”的需求
 * 注意：此程序只能在windows cmd等或 linux terminal中运行，因为使用了System.console()方法得到了Console的实例对象，但是
 * 
 * Java 要与Console进行交互，不总是能得到可用的Java Console类的。一个JVM是否有可用的Console，依赖于底层平台和JVM如何被调用。如果JVM是在交互式命令行（比如Windows的 cmd，linux/unix的 terminal）中启动的，并且输入输出没有重定向到另外的地方，才可得到一个可用的Console实例。
————————————————
版权声明：本文为CSDN博主「RiskAI」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/jhsword/article/details/108564052
 */

package arrangement;

import java.text.DecimalFormat;
import java.util.*;
import allInerface.*;
import dataBase.DataBaseImplement;

public class Arrangement {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		//此处输用户名与密码不能有空格
		while(!Login.login()) {
			System.out.println("用户名或密码错误，请重新输入");
		}
		
		System.out.println("欢迎进入Arrangement系统");
		
		System.out.println("input-car_id:在vip表中添加固定车车牌");
		System.out.println("delete-car_id:从vip表中删除固定车车牌");
		System.out.println("update-all_position:更新总车位数，同步修改现有车位数");
		System.out.println("update-fee:更新收费标准");
		System.out.println("print-vip:打印固定车车牌");
		System.out.println("print-position:打印总车位数与现可停车位数信息");
		System.out.println("print-history-info:输出某时间段内的所有非固定车的历史停靠信息");
		System.out.println("print-history-money:打印某时段内总的应收金额");
		System.out.println("quit:退出程序");
		System.out.println("help:获取帮助信息");
		
		String command = null;
		boolean i = true;
		while(i) {
			command = scan.nextLine();
			//在vip表中添加固定车车牌，注意要在position_num里把now_position--
			//此处无法识别非车牌号的输入，已解决
			if(command.equals("input-car_id")) {
				DataBase db = new DataBaseImplement();
				String car_id = scan.nextLine();
				
				if(!DataBase.isCarId(car_id)) {
					System.out.println("车牌非法，添加失败");
					continue;
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
					
					System.out.println("添加成功");
				}
				else {

					System.out.println("添加失败");
				}
				continue;
			}
			
			//从vip表中删除固定车车牌,注意要在position_num里把now_position++
			//输入不在vip表中的数据是无法被删除的
			else if(command.equals("delete-car_id") ) {
				DataBase db = new DataBaseImplement();
				String car_id = scan.nextLine();
				
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
					
					System.out.println("删除成功");
				}
				else {
					System.out.println("删除失败");
				}
				continue;
			}
			
			//更新总车位数，记得同步修改现有车位数
			//当总车位数比已用车位数小时，现有车位数会出现负数的情况，已解决
			else if(command.equals("update-all_position") ) {
				DataBase db = new DataBaseImplement();
				String all_position = scan.nextLine();
				
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
						System.out.println("该总车位数太小，不合实际，修改总车位数失败");
						continue;
					}
					
					//修改现可用车位
					db.add_update_delete("update position_num set now_position = " + now_position);
					
					System.out.println("修改总车位数成功");
				}
				else {
					System.out.println("修改总车位数失败");
				}
				continue;
			}
			
			//更新收费标准
			//收费标准不为数字不会被更新
			//收费标准为负数会被更新，已解决
			else if(command.equals("update-fee") ) {
				DataBase db = new DataBaseImplement();
				String fee = scan.nextLine();
				
				//判断fee的值是否大于0
				if(Double.valueOf(fee) < 0) {
					System.out.println("输入的标准不合法，修改收费标准失败");
					continue;
				}
				
				if(db.add_update_delete("update money set fee = " + fee) ) {
					System.out.println("修改收费标准成功");
				}
				else {
					System.out.println("修改收费标准失败");
				}
				continue;
			}
			
			//打印固定车车牌
			else if(command.equals("print-vip") ) {
				DataBase db = new DataBaseImplement();
				
				String[] columns = {"car_id"};
				List<Map<String,String>> list = db.executeQuery("select car_id from vip", columns);
				
				System.out.println("固定车车牌");
				for(Map<String,String> map : list) {
					System.out.println(map.get("car_id"));
				}
				continue;
			}
			
			//打印总车位数与现可停车位数信息
			else if(command.equals("print-position") ) {
				DataBase db = new DataBaseImplement();
				
				String[] columns = {"all_position","now_position"};
				List<Map<String,String>> list = db.executeQuery("select * from position_num", columns);
				
				System.out.println("总车位数" + "    "+ "除固定车外可停车位数");
				for(Map<String,String> map : list) {
					System.out.print(map.get("all_position"));
					System.out.print("           ");
					System.out.println(map.get("now_position"));
				}
				continue;
			}
			
			//输出某时间段内的所有非固定车的历史停靠信息
			//必须按照timestamp支持的格式输入，如：2021-09-02 22:10:00
			//打印的车辆的历史信息一定是在输入的时间范围内的，且不能包括起止时间
			//开始时间和结束时间之间要求换行
			
			//不能解决用户对时间戳的非法输入
			else if(command.equals("print-history-info") ) {
				DataBase db = new DataBaseImplement();
				System.out.println("请以\"yyyy-MM-dd hh:mm:ss\"的形式输入要查询开始时间");
				String in_timestamp = scan.nextLine();
				System.out.println("请以\"yyyy-MM-dd hh:mm:ss\"的形式输入要查询结束时间");
				String out_timestamp = scan.nextLine();
				
				String[] columns = {"car_id","charged_fee","in_timestamp","out_timestamp"};
				String sql = "select car_id,charged_fee,in_timestamp,out_timestamp from history where in_timestamp > \'" + in_timestamp + "\' and out_timestamp < \'" + out_timestamp + "\'";
				List<Map<String,String>> list = db.executeQuery(sql, columns);
				
				System.out.println("车牌号" + "		"+ "停车费" + "		" + "进场时间" + "				" + "出场时间");
				for(Map<String,String> map : list) {
					if(!map.get("car_id").equals(null)) {
						System.out.print(map.get("car_id"));
						System.out.print("		");
						
						//将费用保留2位小数
						DecimalFormat df = new DecimalFormat("0.00");
						Double fee = Double.valueOf(map.get("charged_fee") );
						System.out.print(df.format(fee) );
						System.out.print("		");
						
						System.out.print(map.get("in_timestamp"));
						System.out.print("		");
						System.out.print(map.get("out_timestamp"));
						System.out.println(" ");
					}
					else {
						System.out.println("查询出错，请找管理员解决问题");
					}
				}
				continue;
			}
			
			//打印某时段内总的应收金额
			//必须按照timestamp支持的格式输入，如：2021-09-02 22:10:00
			//打印的车辆的总金额信息一定是在输入的时间范围内的，且不能包括起止时间
			//开始时间和结束时间之间要求换行
			
			//不能解决用户对时间戳的非法输入
			else if(command.equals("print-history-money") ) {
				DataBase db = new DataBaseImplement();
				System.out.println("请以\"yyyy-MM-dd hh:mm:ss\"的形式输入要查询开始时间");
				String in_timestamp = scan.nextLine();
				System.out.println("请以\"yyyy-MM-dd hh:mm:ss\"的形式输入要查询结束时间");
				String out_timestamp = scan.nextLine();
				
				String[] columns = {"charged_fee"};
				String sql = "select charged_fee from history where in_timestamp > \'" + in_timestamp + "\' and out_timestamp < \'" + out_timestamp + "\'";
				List<Map<String,String>> list = db.executeQuery(sql, columns);
				
				
				System.out.println(in_timestamp + "————————————>" + out_timestamp + "总应收金额为");
				//计算总金额
				double fee = 0.00;
				for(Map<String,String> map : list) {
					
					fee = fee + Double.valueOf(map.get("charged_fee") );
				}
				
				//将费用保留2位小数
				DecimalFormat df = new DecimalFormat("0.00");
				System.out.println(df.format(fee) );
				continue;
			}
			
			//获取帮助信息
			else if(command.equals("help")) {
				System.out.println("input-car_id:在vip表中添加固定车车牌");
				System.out.println("delete-car_id:从vip表中删除固定车车牌");
				System.out.println("update-all_position:更新总车位数，同步修改现有车位数");
				System.out.println("update-fee:更新收费标准");
				System.out.println("print-vip:打印固定车车牌");
				System.out.println("print-position:打印总车位数与现可停车位数信息");
				System.out.println("print-history-info:输出某时间段内的所有非固定车的历史停靠信息");
				System.out.println("print-history-money:打印某时段内总的应收金额");
				System.out.println("quit:退出程序");
				System.out.println("help:获取帮助信息");
				continue;
			}
			
			
			//退出程序
			else if(command.equals("quit")) {
				break;
			}
			
			else {
				System.out.println("未定义的命令，输入\"help\"获取帮助信息");
				continue;
			}
			
			
		}
		scan.close();
		System.out.println("arrangement程序已退出");
	}
}
