package com.spring.demo;

import com.spring.demo.profile.ProfileConfig;
import com.spring.demo.profile.ProfileDemoBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yukai on 2017/6/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileConfig.class})
@ActiveProfiles("produc")
public class ActiveProfileTest {
    @Autowired
    private ProfileDemoBean profileDemoBean;
    @Test
    public void profileActiveTest()
    {
        String expected="produc";
        String result=profileDemoBean.getContent();
        System.out.println(profileDemoBean.getContent());
        Assert.assertEquals(result,expected);
    }
}
