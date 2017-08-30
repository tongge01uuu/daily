package com.we.contract.logic.impl;

import com.we.contract.dao.DemoDao;
import com.we.contract.entity.Demo;
import com.we.contract.logic.DemoLogic;
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
