/*
 * 执行图像识别的exe程序
 */
package fileAction;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExePerformed {
	/*
	 * 参数：无
	 * 返回值：正常执行返回true，否则返回false
	 * 用途：执行图像识别exe
	 */
	
	public static boolean exePerformed() {
		String cmd = "C:\\大学\\大三\\软件工程综合实践\\停车场出入管理系统\\handlingPicture\\matlabJudge\\for_testing\\matlabJudge.exe";
		BufferedReader br = null;
        try {
        	//执行exe  cmd可以为字符串(exe存放路径)也可为数组，调用exe时需要传入参数时，可以传数组调用(参数有顺序要求)
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
		return true;
	}
	
	
}
