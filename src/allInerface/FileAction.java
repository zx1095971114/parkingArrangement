/*
 * 该接口涵盖了关于文件（主要是图片）的操作
 */
package allInerface;

public interface FileAction{
	/*
	 * 参数：String类型的文件名
	 * 返回值：无
	 * 用处：从文件系统指定位置读图片
	 */
	public void readFile(String fileName);
	
	/*
	 * 参数：fileName为文件名，resuorce为文件源路径，destination为文件目标路径
	 * 返回值：无
	 * 用处：将文件从resouce转移到destination
	 */
	public void moveFile(String fileName, String resuorce, String destination); 
}