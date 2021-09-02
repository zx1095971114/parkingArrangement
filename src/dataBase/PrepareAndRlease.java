package dataBase;

import java.sql.*;

public class PrepareAndRlease {
	//取得数据库操作对象
	public static Statement getStm(Connection conn, Statement stm) {
		try {
			//1.注册驱动
			Class.forName("org.postgresql.Driver");
			
			//2.建立连接
			String url = "jdbc:postgresql://localhost:5432/park_test";
			String usr = "postgres";
			String psw = "Zx191702";
			conn = DriverManager.getConnection(url, usr, psw);
			
			//3.取得数据库操作对象
			stm = conn.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stm;
	}
	
	//资源释放
	//6.释放资源
	public static void release(Connection conn, Statement stm, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(stm != null) {
				stm.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
