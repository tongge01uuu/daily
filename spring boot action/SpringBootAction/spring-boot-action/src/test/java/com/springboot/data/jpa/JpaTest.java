package com.springboot.data.jpa;

import com.alibaba.fastjson.JSON;
import com.springboot.data.jpa.dao.PersonRepositoryExtendsJpa;
import com.springboot.data.jpa.domain.Person;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Sortable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yukai on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class JpaTest {
    private static final Logger logger= LoggerFactory.getLogger(JpaTest.class);
    @Autowired
    PersonRepositoryExtendsJpa personRepositoryExtendsJpa;
    @Test
    public void test()
    {
        personRepositoryExtendsJpa.findByName("JAY");
        personRepositoryExtendsJpa.readByNameAndAge("zz",29);
        personRepositoryExtendsJpa.selectOfCustomBindByName("武汉",28);
        personRepositoryExtendsJpa.selectOfCustomBindByNumber(6,27);

        //分页&排序
        Pageable pageable=new PageRequest(0,10, Sort.Direction.DESC,"age","address");
        personRepositoryExtendsJpa.findAll(pageable);

        //排序-1
        Sort sortCommon=new Sort(Sort.Direction.ASC,"age","name");
        personRepositoryExtendsJpa.findAll(sortCommon);

        //排序-2
        Sort.Order orderAge=new Sort.Order(Sort.Direction.ASC,"age");
        Sort.Order orderName=new Sort.Order(Sort.Direction.ASC,"name");
        Sort sortOrder=new Sort(orderAge,orderName);
        personRepositoryExtendsJpa.findAll(sortOrder);

    }

}
