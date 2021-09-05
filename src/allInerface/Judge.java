/*
 * 该接口用于接入车牌识别模块
 */
package allInerface;

import dataBase.DataBaseImplement;
import judge.*;


import java.util.*;

public interface Judge{
	/*
	 * 参数：要识别车牌所在的路径
	 * 返回值：车牌号的String值
	 * 用处：识别指定的车牌
	 */
	public static String judge(String path) {
		
		String resouce =  WebImage.webImage(path);
		String car_id = resouce.substring(27, 34);
		return car_id;
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
	
	
}