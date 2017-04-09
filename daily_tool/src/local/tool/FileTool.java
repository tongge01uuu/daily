package local.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileTool {
	static List to_del_list=new ArrayList(); //待删除的文件名集合
	static{
		to_del_list.add("讲师张龙简介.pdf");
		to_del_list.add("北京圣思园教育科技有限公司第一期面授培训大纲.pdf");
		to_del_list.add("北京圣思园科技有限公司第一期面授培训大纲.pdf");
	}
	/**
	 * 扫描指定文件夹file_path，删除其路径下指定文件名文件
	 * @param file_path //需要扫描的目录
	 */
	public void searchFile(String file_path)
	{
		File file=new File(file_path);
		String file_name="";
		if(file.isDirectory())
		{
			File files[]=file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if(files[i].isDirectory())
				{
					searchFile(files[i].getPath());
				}else{
					file_name=files[i].getName();
					if(to_del_list.contains(file_name))
					{
						System.out.println(file_name);
						files[i].delete();
					}
					
				}
			}
		}
	}
	static String target_path="";
	public void moveFileFromPath(String path) throws Exception
	{
		File file=new File(path);
		
		if(file.isDirectory())
		{
			target_path=file.getParent();
			File[] files=file.listFiles();
			for (File item : files) {
				if(item.isDirectory() && (item.listFiles()).length<=1)
				{
					System.out.println((item.listFiles()).length);
					moveFileFromPath(item.getPath());
				}else if(item.isFile()){
					System.out.println(item.getPath());
					System.out.println(target_path);
					System.out.println(item.getParent());
					move(item.getPath(),target_path+"/"+item.getName());
					new File(item.getPath()).delete();
					new File(item.getParent()).delete();
				}
			}
		}
	}
	
	public void move(String from_path,String target_path) throws Exception
	{
		File from_file=new File(from_path);
		File target_file=new File(target_path);
		
		InputStream is=new FileInputStream(from_file);
		OutputStream os=new FileOutputStream(target_file);
		int tmp=0;
		int off=0;
		int len=1000;
		byte[] b=new byte[len];
		while((len=is.read(b))>0)
		{
			os.write(b,0,len);
			
		}
		os.flush();
		os.close();
		is.close();
	}
	public static void main(String[] args) throws Exception {
		FileTool fileTool=new FileTool();
		String file_path="/Users/phantom/Desktop/圣思源/";
		fileTool.searchFile(file_path);
		
//		String file_path="/Users/phantom/Desktop/圣思源/J2SE/98-131";
//		fileTool.moveFileFromPath(file_path);
		
		
//		String from_path="/Users/phantom/Desktop/Java SE 第二十一讲 多态详解 续2.avi";
//		String target_path="/Users/phantom/Desktop/Java SE 第二十一讲 多态详解 续22.avi";
//		fileTool.move(from_path, target_path);
	}
}
