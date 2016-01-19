/**
 * Written by xdemo.org
 */
package org.xdemo.example.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.xdemo.example.rmi.bean.User;
import org.xdemo.example.rmi.service.IHelloWorldService;

/**
 * @author Goofy <a href="http://www.xdemo.org">xdemo.org</a>
 * 客户端连接RMI服务，调用其中的方法
 */
public class Client {
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		//遍历已注册服务
		for(String s:Naming.list("rmi://localhost:8888/helloWorld")){
			System.out.println("RMI服务"+s);
		}
		
		//查找服务
		IHelloWorldService helloWorldService=(IHelloWorldService) Naming.lookup("rmi://localhost:8888/helloWorld");
		
		//远程调用
		helloWorldService.sayHello();
		
		//远程调用
		System.out.println(helloWorldService.getResponse("Test"));
		
		User user=new User();
		user.setName("xdemo");
		user.setAddress("http://www.xdemo.org/");
		
		//远程调用
		helloWorldService.getUserInfo(user);
		
	}

}
