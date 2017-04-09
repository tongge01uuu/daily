package com.daily;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.daily.dao.StockDao;
import com.daily.entity.StockEntity;

public class DailyTest {
	private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 

    static{
        try{
            reader    = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    
    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
        /*
         * 方法一、
         */
        StockEntity stockEntity = (StockEntity) session.selectOne("com.daily.dao.StockDao.get", 1);
        System.out.println(stockEntity.getCompany_name());
        System.out.println(stockEntity.getStock_no());
        
        /*
         * 方法二、
         */
        StockDao stockDao=session.getMapper(StockDao.class);
        StockEntity se2=stockDao.get(1);
        System.out.println(se2.getCompany_name());
        System.out.println(se2.getStock_no());
        } finally {
        session.close();
        }
    }

}
