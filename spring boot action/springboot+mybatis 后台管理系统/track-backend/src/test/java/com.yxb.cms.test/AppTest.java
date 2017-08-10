package com.yxb.cms.test;

import com.we.backend.track.Application;
import com.we.backend.track.architect.properties.JdbcProperties;
import com.we.backend.track.service.ResourceService;
import com.we.backend.track.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring boot 测试
 * @author YK@ule.com
 * @date 2017/4/1 11:34
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AppTest {

    @Autowired
    private JdbcProperties jdbcProperties;

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceService resourceService;
    @Test
    public void test() {}

    @Test
    public void test2() throws Exception{


        String result = resourceService.selectResLevelListByParentid(7);

        System.out.println(result);


    }





    


}
