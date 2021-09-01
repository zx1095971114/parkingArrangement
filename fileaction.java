

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
 
public  class  fileaction  {  
 
   
 
   /**  
     *  删除文件  
     *  @param  filePathAndName  String  文件路径及名称  如c:/fqf.txt  
     *  @param  fileContent  String  
     *  @return  boolean  
     */  
   public  void  delFile(String  filePathAndName)  {  
       try  {  
           String  filePath  =  filePathAndName;  
           filePath  =  filePath.toString();  
           java.io.File  myDelFile  =  new  java.io.File(filePath);  
           myDelFile.delete();  
 
       }  
       catch  (Exception  e)  {  
           System.out.println("删除文件操作出错");  
           e.printStackTrace();  
 
       }  
 
   }  
 
  
 
   



/**  
     *  复制单个图片 
     *  @param  oldPath  String  原文件路径  如：c:/1.jpg  
     *  @param  newPath  String  复制后路径  如：f:/1.jpg 
     *  @return  boolean  
     */  
   public  void  copyFile(String  oldPath,  String  newPath)  {  
       try  {  
//           int  bytesum  =  0;  
           int  byteread  =  0;  
           File  oldfile  =  new  File(oldPath);  
           if  (oldfile.exists())  {  //文件存在时  
               InputStream  inStream  =  new  FileInputStream(oldPath);  //读入原文件 
               FileOutputStream  fs  =  new  FileOutputStream(newPath);  
               byte[]  buffer  =  new  byte[1444];  
//               int  length;  
               while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {  
//                   bytesum  +=  byteread;  //字节数  文件大小  
//                   System.out.println(bytesum);  
                   fs.write(buffer,  0,  byteread);  
               }  
               inStream.close();  
           }  
       }  
       catch  (Exception  e)  {  
           System.out.println("复制单个文件操作出错");  
           e.printStackTrace();  
 
       }  
 
   }  
 
  
 
   /**  
     *  移动文件到指定目录  
     *  @param  oldPath  String  如：c:/1.jpg  
     *  @param  newPath  String  如：d:/1.jpg
     */  
   public  void  moveFile(String  oldPath,  String  newPath)  {  
       copyFile(oldPath,  newPath);  
       delFile(oldPath);  
 
   }  
 
   
   public static void main(String[] args){
    fileaction file = new fileaction();
//    file.newFolder("newFolder22222");
    file.delFile("E:/1");
   }
// 拷贝文件
   private void copyFile2(String source, String dest) {
   try {
   File in = new File(source);
   File out = new File(dest);
   FileInputStream inFile = new FileInputStream(in);
   FileOutputStream outFile = new FileOutputStream(out);
   byte[] buffer = new byte[10240];
   int i = 0;
   while ((i = inFile.read(buffer)) != -1) {
   outFile.write(buffer, 0, i);
   }//end while
   inFile.close();
   outFile.close();
   }//end try
   catch (Exception e) {
 
   }//end catch
   }//end copyFile
 
}
