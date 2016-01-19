package com.fzweb.action;

import java.util.Map;

import org.springframework.stereotype.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fzservice.domain.TestBean;
import com.fzservice.entity.Tbtest;
import com.fzservice.exception.FzServiceException;
import com.fzservice.service.iface.DemoService;
import com.fzweb.exception.FzWebException;

@Controller
public class DubboAction {

	@Reference(version = "DemoServiceImpl", init = true)
	private DemoService demoService;

	public void throwException() throws FzWebException {
		throw new FzWebException("自定义异常");
	}

	public String sayHello(Map<String,String> paramMap) throws FzServiceException {
		// throw new IOException("测试异常");
		String param = (String) paramMap.get("param");
		TestBean oTestBean = demoService.sayHello("DWRer " + param);
		return oTestBean.getStr();
		// response.getWriter().print(oTestBean.getStr());
	}

	public Tbtest getEntity(String name) throws FzServiceException {
		return demoService.getEntity(name);
	}

	public void insertEntiry(Tbtest oTbtest) throws FzServiceException {
		demoService.insertEntity(oTbtest);
	}
}
