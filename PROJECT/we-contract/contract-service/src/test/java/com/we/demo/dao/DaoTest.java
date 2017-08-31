package com.we.demo.dao;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.contract.dao.ContractTemplateMapper;
import com.we.demo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by qibaichao on 2016/8/30.
 */
public class DaoTest extends BaseTest {

    @Autowired
    private ContractTemplateMapper contractTemplateMapper;

    @Test
    public void test() {
        PageHelper.startPage(2,2);
        List list= contractTemplateMapper.selectByExample(null);
        PageInfo pageInfo=new PageInfo(list);
        System.out.println(JSON.toJSONString(pageInfo));

    }

}
