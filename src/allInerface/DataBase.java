/*
 * 与后端数据库交互的接口
 * ps:由于我的计算机设置了防火墙，你们连不到我计算机的数据库，所以请你们完成程序后将源码合并到git的develop分支上，
 * 再跟我说，我来给你们检验程序
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
	 * 返回值：被Set<Map<String,String>>封装好的查询语句查到的结果集
	 * 用途：执行Sql 查询语句，把结果集合放在一个 Set<Map<String,String>> 里面
	 * 	Map中key(前一个)为属性名，value(后一个)为属性值
		Set中的一个Map集合为一个元组
	 *	注意：无论Map集合还是Set集合，在遍历时均无法保证有序性，使用时要记得判断一下
	 */
	public Set<Map<String, String>> executeQuery(String sql, String[] columns);
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

