package com.daily.service;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
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
    /**
     * 执行单个任务
     * @param task Object
     * @param ownSign 当前环境名称
     * @throws Exception
     */
    @Override
    public boolean execute(Object task, String ownSign) throws Exception {
        logger.error("--------obj: {} string {}",task.toString(),ownSign);
//        System.out.println(o.toString());
        return true;
    }


    /**
     * 根据条件，查询当前调度服务器可处理的任务
     * @param taskParameter 任务的自定义参数
     * @param ownSign 当前环境名称
     * @param taskQueueNum 当前任务类型的任务队列数量
     * @param taskQueueList 当前调度服务器，分配到的可处理队列
     * @param eachFetchDataNum 每次获取数据的数量
     * @return
     * @throws Exception
     */
    @Override
    public List selectTasks(String taskParameter, String ownSign, int taskQueueNum, List taskQueueList, int eachFetchDataNum) throws Exception {
        List result=new ArrayList();
//        logger.error("------------selectTasks");
        logger.error("任务的自定义参数任务的自定义参数:{},当前环境名称:{},当前任务类型的任务队列数量{}," +
                "当前调度服务器分配到的可处理队列{},每次获取数据的数量{}",
                taskParameter,ownSign,taskQueueNum,taskQueueList,eachFetchDataNum);
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
