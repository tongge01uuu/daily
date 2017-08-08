package com.springboot.data.jpa;

import com.alibaba.fastjson.JSON;
import com.springboot.data.jpa.dao.PersonRepository;
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
    @Autowired
    PersonRepository personRepository;

    private static final Pageable pageable=new PageRequest(0,10, Sort.Direction.DESC,"age","address");
    private static final Sort sortCommon=new Sort(Sort.Direction.ASC,"age","name");
    private static final Sort.Order orderAge=new Sort.Order(Sort.Direction.ASC,"age");
    private static final Sort.Order orderName=new Sort.Order(Sort.Direction.ASC,"name");
    @Test
    public void test()
    {
        personRepository.withNameAndAddressNamedQuery("JAY","合肥");

        Person param=new Person();
        param.setAge(28);
        param.setName("aa");
        personRepository.findByAuto(param,pageable);
        personRepository.selectByHql("select p from Person p");
        logger.info("=================before delete============================");
        personRepository.selectBySql("select count(*) from person p");
        personRepository.updateBySql("delete from person where id=?",44);
        logger.info("=================after delete============================");
        personRepository.selectBySql("select count(*) from person p");


        personRepositoryExtendsJpa.findByName("JAY");
        personRepositoryExtendsJpa.readByNameAndAge("zz",29);
        personRepositoryExtendsJpa.selectOfCustomBindByName("武汉",28);
        personRepositoryExtendsJpa.selectOfCustomBindByNumber(6,27);

        //分页&排序
        personRepositoryExtendsJpa.findAll(pageable);

        //排序-1
        personRepositoryExtendsJpa.findAll(sortCommon);

        //排序-2
        Sort sortOrder=new Sort(orderAge,orderName);
        personRepositoryExtendsJpa.findAll(sortOrder);

    }

}
