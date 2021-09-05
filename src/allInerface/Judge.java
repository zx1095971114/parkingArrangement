/*
 * 该接口用于接入车牌识别模块
 */
package allInerface;

import dataBase.DataBaseImplement;
import fileAction.FileActionImplement;


import java.util.*;

public interface Judge{
	/*
	 * 参数：无
	 * 返回值：车牌号存放的.properties文件名
	 * 用处：读取车牌，将其写到.properties文件中
	 */
	public static String judge() {
		return null;
	}
	
	/*
	 * 参数：要比较的车牌号
	 * 返回值：在vip中出现过则返回true,否则返回false
	 * 用处：判断所给的车牌是否在vip中出现过
	 */
	public static boolean isVip(String targetCar_id) {
		//获取vip表数据
		String sql = "select * from vip";
		String[] columns = {"car_id"};
		DataBase db = new DataBaseImplement();
		List<Map<String,String>> list = db.executeQuery(sql, columns);
		
		//遍历vip并比较
		for (Map<String, String> map : list) {
			if(targetCar_id.equals(map.get("car_id") ) ) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/*
	 * 参数
	 * 返回值
	 * 用处：获取要模拟入场或出场的car_id
	 */
	public static String preparingCar_id(String resource, String destination)
    {
    	//复制要识别的图片到指定文件夹
////    	FileAction fileAction = new FileActionImplement();
//    	fileAction.copyFile(resource, destination);
    	
    	//调用judge()得inCar_id
		String inCar_id = Judge.judge();
//    	return inCar_id;
		return "湘A12346";
    	
    }
}