package local.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataOutputStreamTest {
	public static void main(String[] args) throws Exception {
		//DataOutputStream
		/*
		 * 装饰模式
		 * 以缓冲的方式（buffered） 向文件写入 基本数据类型（DataOutputStream） 的输出流
		 * 
		 */
				DataOutputStream os=new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream("zhuangshi.txt")
								));
				os.writeInt(10);
				os.writeBoolean(false);
				os.writeUTF("112");
				
				os.close();
				DataInputStream d=new DataInputStream(new BufferedInputStream(new FileInputStream("zhuangshi.txt")));
				
				System.out.println(d.readInt());
				System.out.println(d.readBoolean());
				System.out.println(d.readUTF());
	}

}
