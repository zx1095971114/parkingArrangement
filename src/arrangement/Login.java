/*
 * Arrangement中要用到的登录类
 */

package arrangement;

import java.io.Console;
import java.util.*;

public class Login {
	public static boolean login() {
		//加载登录界面,读取用户输入的用户名密码
		Map<String, char[]> map = Load.load();
		//判断是否正确
		return Judge.judge(map);
	}
}

class Load{
	public static Map<String, char[]> load() {
		String usr = null;
		char[] psw = null;
		Map<String, char[]> map = new HashMap<>();
		Console console = System.console();
		
		if(console == null) {
			System.out.println("在IDE中得不到Console的对象实例,请在windows cmd或linux terminal中运行此程序");
			System.exit(0);
		}
		
		System.out.println("请输入用户名");
		usr = console.readLine();
		System.out.println("请输入密码");
		psw = console.readPassword();
		
		map.put(usr,psw);
		return map;
	}
}

class Judge{
	public static boolean judge(Map<String, char[]> map) {
		String usr = null;
		char[] psw = null;
		Set<Map.Entry<String, char[]>> s = map.entrySet();
		for(Map.Entry<String, char[]> m : s) {
			usr = m.getKey();
			psw = m.getValue();
		}
		
		String usr0 = String.valueOf(usr);
		String psw0 = String.valueOf(psw);
		
		if(usr0.equals("administrator") && psw0.equals("123456")) {
			return true;
		}
		else {
			return false;
		}
	}
}