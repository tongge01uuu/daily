/**
 * Written by xdemo.org
 */
package org.xdemo.example.rmi.bean;

import java.io.Serializable;

/**
 * @author Goofy <a href="http://www.xdemo.org">xdemo.org</a>
 * User对象，实现序列化接口
 */
public class User implements Serializable,Cloneable{

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 2857323539517761766L;

	private String name;
	
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
