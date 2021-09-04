package parkinginall;
import parkinginall.*;
import java.util.Calendar;
import java.util.Date;
import java.lang.Object;
import java.sql.*;
import java.util.*;
public class Parkingin extends Database{
	String nextOrder = null;
	public void order() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入命令:");
		String order = input.nextLine();
		while(order != null){
			nextOrder = order;
			Preparing.preparing(nextOrder);
			
		}
	}
	
	
	
		public  String parkin(){
			String outputOrder = "欢迎光临。";	
			if(DataBase.used_position == 1000)
				outputOrder = "车位已满。";
			while (outputOrder != "车位已满。") {
			try{
				String car_id = Preparing.carid;
				Date date = new Date();
				
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    String in_time = sdf.format(date);
				String sql="insert park(car_id,in_time) values('"+car_id+"','"+in_time+")";//入场登记
				sql.add_update_delete();
				
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return outputOrder;
		}		
    }
}
