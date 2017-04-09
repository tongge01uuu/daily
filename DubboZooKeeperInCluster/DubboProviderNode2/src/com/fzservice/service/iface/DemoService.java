package com.fzservice.service.iface;

import java.sql.SQLException;

import com.fzservice.domain.TestBean;
import com.fzservice.entity.Tbtest;
import com.fzservice.exception.FzServiceException;

/**
 * @package com.fzservice.service.iface
 * @description 对web接口
 * @author Goliath
 * @createTime 2012-9-24 上午10:05:10
 * @modifyTime
 */
public interface DemoService {
	/**
	 * @package com.fzservice.service.iface
	 * @description 测试
	 * @param name
	 * @return
	 * @throws SQLException
	 * @returnType TestBean
	 * @author Goliath
	 * @createTime 2012-9-23 下午6:48:52
	 * @modifyTime
	 */
	public TestBean sayHello(String name) throws FzServiceException;

	public Tbtest getEntity(String name) throws FzServiceException;
	
	public void insertEntity(Tbtest oTbtest) throws FzServiceException;
}