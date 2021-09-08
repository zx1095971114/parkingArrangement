/*
 * 该接口用于接入车牌识别模块
 */
package allInerface;

import dataBase.DataBaseImplement;
import fileAction.ExePerformed;
import fileAction.FileAction;
import judge.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public interface Judge{
	/*
	 * 参数：要识别车牌所在的路径
	 * 返回值：车牌号的String值
	 * 用处：识别指定的车牌
	 * 该方法调用了百度云的API库
	 */
//	public static String judge(String path) {
//		
//		String resouce =  WebImage.webImage(path);
//		String car_id = resouce.substring(27, 34);
//		return car_id;
//	}
	
	/*
	 * 参数：要识别车牌所在的路径
	 * 返回值：车牌号的String值
	 * 用处：识别指定的车牌
	 * 该方法调用了肖学敏同学写的matlab脚本
	 * 注意该脚本产生的车牌字符串后面有空格，要用subString来截取有用的一段
	 * 在java中用subString和length方法处理包含汉字的字符串时，汉字被当成一个英文字母来看，实际汉字占2字节，英文字母占1字节
	 */
	public static String judge(String path) {
		//复制图片至指定文件夹
		FileAction.copyFile(path, "C:\\大学\\大三\\软件工程综合实践\\停车场出入管理系统\\handlingPicture\\1.jpg");
		//执行exe程序
		if(ExePerformed.exePerformed()) {
			//读取matlab.txt中的数据
			InputStreamReader input = null;
			BufferedReader bf = null;
			String line = null;
			try {
				File file=new File("C:\\大学\\大三\\软件工程综合实践\\停车场出入管理系统\\handlingPicture\\matlabtest.txt");
				input=new InputStreamReader(new FileInputStream(file));
				bf=new BufferedReader(input);//按行读入
				line = bf.readLine();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					bf.close();
					input.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			//删除图片
			FileAction.delFile("C:\\大学\\大三\\软件工程综合实践\\停车场出入管理系统\\handlingPicture\\1.jpg");
			
			
			return line.substring(0,7);
		}
		else {
			return null;
		}
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