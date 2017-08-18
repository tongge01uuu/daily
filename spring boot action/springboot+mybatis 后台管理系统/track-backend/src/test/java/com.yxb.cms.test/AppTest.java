package com.yxb.cms.test;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.we.backend.track.Application;
import com.we.backend.track.architect.properties.JdbcProperties;
import com.we.backend.track.service.business.DictionaryService;
import com.we.backend.track.service.system.ResourceService;
import com.we.backend.track.service.system.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Spring boot 测试
 * @author YK@ule.com
 * @date 2017/4/1 11:34
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AppTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private DictionaryService dictionaryService;

    @Test
    public void test() throws Exception{

//        List list = dictionaryService.getDictionary(null);

//        System.out.println(JSON.toJSONString((Page)list));
        dictionaryService.selectAll();
    }

    @Test
    public void test2() throws Exception{


        String result = resourceService.selectResLevelListByParentid(7);

        System.out.println(result);


    }





    


}
