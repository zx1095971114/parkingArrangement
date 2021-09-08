/*
 * 与后端数据库交互的接口
 * ps:由于我的计算机设置了防火墙，你们连不到我计算机的数据库，所以请你们完成程序后将源码合并到git的develop分支上，
 * 再跟我说，我来给你们检验程序
 */
package allInerface;

import java.text.SimpleDateFormat;
import java.util.*;

import java.util.regex.*;

import dataBase.DataBaseImplement;

public interface DataBase{
	/*
	 * 参数：sql为要执行的SQL指令
	 * 返回值：执行成功返回true,否则返回false
	 * 用途：执行sql指令(只支持insert,delete,update)
	 */
	public boolean add_update_delete(String sql);
	
	/*
	 * 参数：sql为SQL语句，
	 * 返回值：被List<Map<String,String>>封装好的查询语句查到的结果集
	 * 用途：执行Sql 查询语句，把结果集合放在一个 List<Map<String,String>> 里面
	 * 	Map中key(前一个)为属性名，value(后一个)为属性值
		Set中的一个Map集合为一个元组
	 *	注意：Map实现是用的TreeMap会根据键值自动升序排列
	 */
	public List<Map<String, String>> executeQuery(String sql, String[] columns);
	
	/*
	 * 参数:无
	 * 返回值：int型，可用车位数
	 * 用途：计算已经使用的车位数
	 */
	public static int used_position() {
		DataBase db = new DataBaseImplement();
		
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
		
		return used_position;
	}
	
	/*
	 * 参数:要判断的字符串
	 * 返回值:如果符合车牌号基本规则，返回true，否则返回false
	 * 用途:判断某字符串是否符合蓝牌一般私家车的车牌号规则
	 */
	public static boolean isCarId(String car_id) {
		//正则表达式，[]内为可出现的字符，{}内为匹配次数
		//判断规则是：第一个字符是“京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼川贵云渝藏陕甘青宁新使”中的一个，第二个字符是A-Z中的一个，后面的五个是0-9，A-Z中的五个
		String stdId = "([京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼川贵云渝藏陕甘青宁新使]{1}[A-Z]{1}[0-9A-Z]{5})";
		
		return Pattern.matches(stdId, car_id);
	}
	
	/*
	 * 参数：无
	 * 返回值：now_position的值
	 * 用处：查询now_positon
	 */
	public static int getNow_position() {
		//获取now_position
		String sql = "select now_position from position_num";
		String[] columns = {"now_position"};
		DataBase db = new DataBaseImplement();
		List<Map<String,String>> list = db.executeQuery(sql, columns);
		
		int now_position = 0;
		for (Map<String, String> map : list) {
			now_position = Integer.valueOf(map.get("now_position"));
		}
		return now_position;
		
	}
	
	/*
	 * 参数：
	 * 返回值：当前时间的timestamp
	 * 用处：获取当前时间的时间戳
	 */
	
	
	//返回时间时，HH表示24小时制，hh表示12小时制，千万别打错，血的教训
	/*
	 * 1、yyyy表示年，如2013；

　　　　2、MM表示月，如12；

　　　　3、dd表示天，如31；

　　　　4、hh表示用12小时制，如7；

　　　　5、HH表示用24小时制，如18；

　　　　6、mm表示分，如59；

　　　　7、ss表示秒，如59；

　　　　8、SSS表示毫米，如333
	 */
    public static String getNowTimestamp() {
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String nowTimestamp = sdf.format(date);
		return nowTimestamp;
	}
}











/*
 * 以下为废弃的接口
 */

///*
// * 参数：table为需要增加元组的表名(vip)，tuple为要增加的元组
// * 返回值：增加成功为true,增加失败为false
// * 用途：向指定表中添加给定的一个元组
// */
//public boolean add(String table, String tuple); 
//
///*
// * 参数：table为需要删除某条记录的表名(vip, status)，car_id为要删除的一行的车牌号
// * 返回值：删除成功为true,删除失败为false
// * 用途：删除vip或status表中的一行记录
// */
//public boolean delete(String table, String car_id); 
//
///*
// * 参数：table为需要更新信息的表名(money, position)，data为要更新成为的数据
// * 返回值：更新成功为true,更新失败为false
// * 用途：更新money或position表中的记录
// */
//public boolean update(String table, String data);

