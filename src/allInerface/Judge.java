/*
 * 该接口用于接入车牌识别模块
 */
package allInerface;

public interface Judge{
	/*
	 * 参数：用于识别的车牌图片的路径
	 * 返回值：车牌号存放的.properties文件名
	 * 用处：读取车牌，将其写到.properties文件中
	 */
	public String judge(String path) ;
}