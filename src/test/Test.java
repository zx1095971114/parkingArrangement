package test;
import java.util.*;

import allInerface.*;
import dataBase.DataBaseImplement;
import arrangement.*;

public class Test {

	public static void main(String[] args) {
		DataBase db = new DataBaseImplement();
		
		/*
		 * 检验DataBase的add_up_delete()方法
		 * 检验成功
		 */
//		boolean b;
//		b = db.add_update_delete("insert into status values('湘A66666','2021-09-01','20:55:32','2021-09-05','06:07:01')");
//		b = db.add_update_delete("delete from status where car_id = '湘A88888'");
//		b = db.add_update_delete("update status set car_id = '湘H68866' where car_id = '湘H88888'");
//		System.out.println(b);
		
		
		/*
		 * 检验DataBase的executeQuery()方法
		 * 检验成功
		 */
//		List<Map<String,String>> set = new ArrayList<>();
//		String[] columns = {"car_id", "in_date", "in_time", "out_date", "out_time"};
//		set = db.executeQuery("select * from status", columns);
////		int i = 1;
//		for (Map<String,String> map : set) {
//			Set<Map.Entry<String, String>> set2 = map.entrySet();
//			for (Map.Entry<String, String> s : set2) {
//				String key = s.getKey();
//				String value = s.getValue();
////				System.out.println(i);
//				System.out.print(key + ":" + value + " ");
//			}
//			System.out.println(" ");
////			i++;
//		}
		
		
		Arrangement arrangement = new Arrangement();
		arrangement.start();
		

		/*
		 * 检验DataBase的used_position()方法
		 * 检验成功
		 */
//		System.out.println(DataBase.used_position());
	}

}
