/*
 * 该接口涵盖了关于文件（主要是图片）的操作
 */
package allInerface;

public interface FileAction{
//	/*
//	 * 参数：String类型的文件名
//	 * 返回值：无
//	 * 用处：从文件系统指定位置读图片
//	 */
//	public void readFile(String fileName);
	
	/*
	 * 参数：resuorce为文件源路径(包含文件名)，destination为文件目标路径
	 * 返回值：无
	 * 用处：将resouce中的文件复制到到destination中
	 */
	public void copyFile(String resource, String destination); 
}