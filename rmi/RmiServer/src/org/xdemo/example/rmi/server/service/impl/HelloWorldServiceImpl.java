/**
 * Written by xdemo.org
 */
package org.xdemo.example.rmi.server.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.xdemo.example.rmi.bean.User;
import org.xdemo.example.rmi.service.IHelloWorldService;


/**
 * @author Goofy <a href="http://www.xdemo.org">xdemo.org</a>
 * 实现HelloWordService的方法
 */
@SuppressWarnings("serial")
public class HelloWorldServiceImpl extends UnicastRemoteObject implements
		IHelloWorldService {

	public HelloWorldServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public void sayHello() throws RemoteException {
		System.out.println("sayHello方法被调用");
		System.out.println("Hello world");
	}
	
	@Override
	public String getResponse(String text) throws RemoteException {
		System.out.println("getResponse方法被调用");
		return "你输入的字符串是:"+text;
	}

	@Override
	public void getUserInfo(User user) throws RemoteException {
		System.out.println("getUserInfo方法被调用");
		System.out.println(user.getName()+"\t"+user.getAddress());
	}

}
