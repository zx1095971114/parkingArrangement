package dataBase;

import java.util.List;
import java.util.Map;
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
	
	
	
	
	
	public List<Map<String, Object>> executeQuery(String sql, Object[] params){
		return null;
	}
}
