/*
 * Arrangement中要用到的登录类
 */

package arrangement;

import java.util.*;

public class Login {
	public static boolean login(Scanner scan) {
		//加载登录界面,读取用户输入的用户名密码
		Map<String, String> map = Load.load(scan);
		//判断是否正确
		return Judge.judge(map);
	}
}

class Load{
	public static Map<String, String> load(Scanner scan) {
		String usr = null;
		String psw = null;
		Map<String,String> map = new HashMap<>();
		
		System.out.println("请输入用户名");
		usr = scan.nextLine();
		System.out.println("请输入密码");
		psw = scan.nextLine();
		
		
		map.put(usr, psw);
		return map;
	}
}

class Judge{
	public static boolean judge(Map<String, String> map) {
		String usr = null;
		String psw = null;
		Set<Map.Entry<String, String>> s = map.entrySet();
		for(Map.Entry<String, String> m : s) {
			usr = m.getKey();
			psw = m.getValue();
		}
		
		if(usr.equals("administrator") && psw.equals("123456")) {
			return true;
		}
		else {
			return false;
		}
	}
}