package com.we.demo.logic;

import com.we.demo.BaseTest;
import com.we.p2p.logic.DemoLogic;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by moruwen on 2016/9/19.
 */
public class DemoLogicTest extends BaseTest {
    @Autowired
    private DemoLogic demoLogic;

    @Test
    public void testGetWorkDay() {
        demoLogic.insert(null);
    }
}
