/*
 * 与后端数据库交互的接口
 */
package allInerface;

import java.util.*;

public interface DataBase{
	/*
	 * 参数：sql为要执行的SQL指令
	 * 返回值：执行成功返回true,否则返回false
	 * 用途：执行sql指令(只支持insert,delete,update)
	 */
	public boolean add_update_delete(String sql);
	
	/*
	 * 参数：sql为SQL语句，
	 * 返回值：被List<Map<String,Object>>封装好的查询语句查到的结果集
	 * 用途：执行Sql 查询语句，把结果集合放在一个 List<Map<String,Object>> 里面
	 */
	public List<Map<String, Object>> executeQuery(String sql, Object[] params);
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

