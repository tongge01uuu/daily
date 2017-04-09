package com.daily.dao;

import com.daily.entity.StockEntity;
/**
 * 1、需映射到相应的动态sql xml映射文件
 *	<mapper namespace="com.daily.dao.StockDao">
 * 2、或者用注解的方式
 * 3、或者动态添加到sessionfactory，
 *   例如：sqlSessionFactory.getConfiguration().addMapper(StockDao.class);	
 * 
 */
public interface StockDao {

	public  StockEntity get(int id);
}
