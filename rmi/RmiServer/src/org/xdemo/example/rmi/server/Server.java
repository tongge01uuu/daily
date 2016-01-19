/**
 * Written by xdemo.org
 */
package org.xdemo.example.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.xdemo.example.rmi.server.service.impl.HelloWorldServiceImpl;
import org.xdemo.example.rmi.service.IHelloWorldService;

/**
 * @author Goofy <a href="http://www.xdemo.org">xdemo.org</a>
 * 启动RMI服务
 */
public class Server {
	//服务注册接口
	static Registry registry;
	
	static IHelloWorldService helloWorldService;

	public static void main(String[] args) throws MalformedURLException, RemoteException, AlreadyBoundException {
		
		//注册服务,端口8888
		registry=LocateRegistry.createRegistry(8888);
		
		//接口的实现类
		helloWorldService=new HelloWorldServiceImpl();
		
		//绑定远程对象到注册的服务器上,防止重复绑定
		Naming.bind("rmi://localhost:8888/helloWorld", helloWorldService);
		
		System.out.println("RMI服务已启动");
	}
}
