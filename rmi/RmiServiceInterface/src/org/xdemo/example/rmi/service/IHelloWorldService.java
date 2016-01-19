/**
 * Written by xdemo.org
 */
package org.xdemo.example.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.xdemo.example.rmi.bean.User;

/**
 * @author Goofy <a href="http://www.xdemo.org">xdemo.org</a>
 * 定义远程调用的接口方法,该接口必须继承Remote接口
 */
public interface IHelloWorldService extends Remote {
	
	//在服务端打印一句话
	public void sayHello() throws RemoteException;
	
	//想客户端返回客户端传输的内容
	public String getResponse(String text) throws RemoteException;
	
	//获取用户信息
	public void getUserInfo(User user) throws RemoteException;

}
