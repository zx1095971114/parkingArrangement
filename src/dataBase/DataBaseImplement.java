package dataBase;

import java.util.*;
import java.sql.*;

import allInerface.*;

public class DataBaseImplement implements DataBase{
	public boolean add_update_delete(String sql) {
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
//		System.out.println("ok1");
		
		// i记录改变表中记录的条数
		int i = 0;
		try {
			//获得数据库操作对象
			stm = PrepareAndRlease.getStm(conn, stm);
			
			//4.进行sql操作
			i= stm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			PrepareAndRlease.release(conn, stm, rs);
		}
		
//		System.out.println("ok2");
		
		if(i == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	public List<Map<String, String>> executeQuery(String sql, String[] columns){
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		//Map中key为属性名，value为属性值
		//Set中的一个Map集合为一个元组
		List<Map<String, String>> set = new ArrayList<>();
		
		try {
			//获得数据库操作对象
			stm = PrepareAndRlease.getStm(conn, stm);
			
			//4.进行sql操作
			rs = stm.executeQuery(sql);
			
			//5.处理查询结果集
			while(rs.next()) {
				Map<String, String> map = new TreeMap<>();
				for(String key : columns) {
					map.put(key,rs.getString(key));
				}
				set.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			PrepareAndRlease.release(conn, stm, rs);
		}
		
		return set;
	}
}
