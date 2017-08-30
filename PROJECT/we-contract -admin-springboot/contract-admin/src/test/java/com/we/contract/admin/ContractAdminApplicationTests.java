package com.we.contract.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.contract.admin.service.system.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractAdminApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void test() throws Exception{
		PageHelper.startPage(2,2,true);
		List list= userService.selectUsersList(null);
		PageInfo pageInfo=new PageInfo(list);
		System.out.println(JSON.toJSONString(pageInfo));
	}





}
