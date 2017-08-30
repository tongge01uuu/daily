package com.we.demo.dao;

import com.we.demo.BaseTest;
import com.we.p2p.dao.DemoDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qibaichao on 2016/8/30.
 */
public class DemoDaoTest extends BaseTest {

    @Autowired
    private DemoDao demoDao;

    @Test
    public void insert() {

        try {
            demoDao.insert(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
