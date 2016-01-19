package local.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws Exception {
		RandomAccessFile randomAccessFile=new RandomAccessFile("test.txt","rw");
		Person p=new Person(12,"tom",12.1);
		p.write(randomAccessFile);
		
		randomAccessFile.seek(0);//游标回到起始
		
		p.read(randomAccessFile);
		
		randomAccessFile.close();
		
		//DataOutputStream
		
		DataOutputStream os=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("zhuangshi.txt")));
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

class Person{
	private int age;
	private String name;
	private double height;
	
	public Person(){}
	public Person(int age,String name,double height){
		this.age=age;
		this.name=name;
		this.height=height;
	}
	
	public void write(RandomAccessFile randomAccessFile) throws Exception
	{
		randomAccessFile.writeInt(age);
		randomAccessFile.writeUTF(name);
		randomAccessFile.writeDouble(height);
		
	}
	
	public void read(RandomAccessFile randomAccessFile) throws Exception
	{
		System.out.println(randomAccessFile.readInt());
		System.out.println(randomAccessFile.readUTF());
		System.out.println(randomAccessFile.readDouble());
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	
}