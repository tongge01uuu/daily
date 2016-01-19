package com.fzservice.service.demo;

import com.alibaba.dubbo.config.annotation.Service;
import com.fzservice.domain.TestBean;
import com.fzservice.entity.Tbtest;
import com.fzservice.exception.FzServiceException;
import com.fzservice.service.iface.DemoService;

@Service(version = "DemoServiceImpl", timeout = 3000)
public class DemoServiceImpl implements DemoService {

	@Override
	public TestBean sayHello(String name) throws FzServiceException {
		String returnStr = " say Hello " + name + "'";
		System.out.println("provider sayHello:" + returnStr);
		TestBean testBean = new TestBean();
		testBean.setStr(returnStr);
		return testBean;
	}

	@Override
	public Tbtest getEntity(String name) throws FzServiceException {
		Tbtest oTbtest = new Tbtest();
		oTbtest.setName(name);
		return oTbtest;
	}

	@Override
	public void insertEntity(Tbtest oTbtest) throws FzServiceException {
		System.out.println(oTbtest.getName());
	}
}
