import java.util.*;

public class outpark extends DataBaseImplement {
	public static  int parkingtime = 0;

	void run(){
   fileaction.copyFile(srting carParking/1.jpg, string carReady/1.jpg);
  
   //urc(get String carID = id);
   //查是否固定车
   
  
			String sql = "select 'car_id' from uip";
			String[] columns = {"car_id"};
			DataBase db = new DataBaseImplement();
			
			List<Map<String, String>> list = db.executeQuery(sql, columns);
			
			
			String id;
			
			for(Map<String, String> map : list) {
				Set<Map.Entry<String, String>> set = map.entrySet();
				for(Map.Entry<String, String> m : set) {
					if(m.getValue().equals(id))
					{
						 System.out.println("一路顺风");
					
					}
	   else {
		   //读取set接口，获得停放时间parkingtime
		   

			String sql2 = "select 'car_id','in_timestamp','out_timestamp' from nuip";
			String[] columns2 = {"car_id","in_timestamp","out_timestamp"};
			DataBase db2 = new DataBaseImplement();
			
			List<Map<String, String>> list2 = db2.executeQuery(sql2, columns2);
			//只查询了三个map表，不知道怎么联系起来。
			
			
		   System.out.println(pay.count(parkingtime)+"元");
	   
	   //获取管理员输入
	   String rightans ="charged";
	   Scanner input = new Scanner (System.in);
	   
	   String ans = input.next();
	   
	   while(ans.equals(rightans)) {
	   System.out.println("一路顺风");
	   
   }
   }

   

}
		}

	
	}
