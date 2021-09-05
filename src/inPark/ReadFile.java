package inPark;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import inPark.*;
public class ReadFile {
public static String read(String file) {
		
		// 创建字符流对象，并根据已创建的字节流对象创建字符流对象
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader raf = null;
	String ids = null;
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			raf = new BufferedReader(isr);
			
			String s = null;
			
			// 读取文件内容，并将其打印
			while((s = raf.readLine()) != null) {
				ids = s;
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				raf.close();
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}
		return ids;
	}
 
}
