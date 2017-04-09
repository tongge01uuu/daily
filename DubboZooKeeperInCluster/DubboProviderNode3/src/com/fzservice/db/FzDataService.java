/**
 * 
 */
package com.fzservice.db;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjpii.modules.orm.dataservice.impl.DataServiceImpl;
import com.zjpii.modules.spring.SpringContextHolder;

@Service
@Transactional
public class FzDataService extends DataServiceImpl {
	
	public FzDataService() throws IOException {
		super.logger = Logger.getLogger(this.getClass());
		super.hibernateDao = SpringContextHolder.getBean("fzDao");
	}
}
