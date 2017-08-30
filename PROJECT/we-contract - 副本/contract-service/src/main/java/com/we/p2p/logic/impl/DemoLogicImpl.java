package com.we.p2p.logic.impl;

import com.we.p2p.dao.DemoDao;
import com.we.p2p.entity.Demo;
import com.we.p2p.logic.DemoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User:hgq
 * Datetime:2016/9/6 18:21
 */
@Component
public class DemoLogicImpl implements DemoLogic {


    @Autowired
    private DemoDao dao;

    @Override
    public int insert(Demo record) {
        return dao.insert(record);
    }

}
