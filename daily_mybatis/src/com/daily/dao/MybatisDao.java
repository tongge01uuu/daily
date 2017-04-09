package com.daily.dao;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;

public class MybatisDao {
	static DataSource datasource;
	static TransactionFactory tf=new JdbcTransactionFactory();
	static Environment environment;
	static Configuration configuration;
	static SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();;
	static SqlSessionFactory sf=builder.build(configuration);
	public MybatisDao()
	{
		
	}

}
