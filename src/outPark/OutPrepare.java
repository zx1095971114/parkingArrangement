/*
 * 出场程序要调用的方法
 */

/*
 * 问题：为什么
 * Date date = Date();
 * long t1 = date.getTime();
 * 
 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
 * String s = sdf.format(date);
 * Date date2 = sdf.parse(s);
 * long t2 = date2.getTime;
 * t1会与t2不相等
 * 解决，在getTime方法中，时间戳要是24小时制的，而"yyyy-MM-dd hh:mm:ss"是12小时制的，应该将hh改为HH才行
 */


//计算费用会出现有时正确，有时错误的情况
package outPark;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

import allInerface.DataBase;
import dataBase.DataBaseImplement;

public class OutPrepare  {
	public static double getFee(String car_id) {

		DataBase db = new DataBaseImplement();
		//获得入场时间
		String sql0 = "select in_timestamp from status where car_id = \'" + car_id + "\'";
		String[] columns0 = {"in_timestamp"};
		List<Map<String,String>> list0 = db.executeQuery(sql0, columns0);
		String inTime = null;
		for (Map<String, String> map : list0) {
			inTime = map.get("in_timestamp");
		}
		
		//获得目前时间
		Date inDate = null;
		Date outDate = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    	try {
    		inDate = sdf.parse(inTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	//计算时间差(ms计算)
    	long parkTime = outDate.getTime() - inDate.getTime();
//    	System.out.println(parkTime/1000 / 3600);
    	
    	//计算金额(每小时fee元,不足一小时部分舍弃)
    	//获取fee
    	String sql1 = "select * from money";
		String[] columns1 = {"fee"};
		List<Map<String,String>> list1 = db.executeQuery(sql1, columns1);
		double fee = 0.0;
		for (Map<String, String> map : list1) {
			fee = Double.valueOf(map.get("fee"));
		}
		
		//计算并返回
		
		double charged_fee = parkTime / (1000 * 3600) * fee;
		
    	return charged_fee;
    	
	}
}
