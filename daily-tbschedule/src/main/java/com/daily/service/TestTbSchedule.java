package com.daily.service;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yukai on 2016/9/6.
 */
@Component("testTbSchedule")
public class TestTbSchedule implements IScheduleTaskDealSingle{
    static final Logger logger= LoggerFactory.getLogger(TestTbSchedule.class);
    @Override
    public boolean execute(Object o, String s) throws Exception {
//        logger.error("{}","------------selectTasks");
        System.out.println(o.toString());
        return true;
    }

    @Override
    public List selectTasks(String s, String s1, int i, List list, int i1) throws Exception {
        List result=new ArrayList();
//        logger.error("------------selectTasks");
        result.add("hello1");
        result.add("hello2");
        result.add("hello3");
        return result;
    }

    @Override
    public Comparator getComparator() {
        return null;
    }
}
