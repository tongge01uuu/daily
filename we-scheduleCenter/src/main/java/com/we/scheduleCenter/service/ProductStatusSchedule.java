package com.we.scheduleCenter.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import com.site.bean.resultBean.Result;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import com.we.exchange.service.ExchangeProductService;

@Service("productStatusSchedule")
public class ProductStatusSchedule implements IScheduleTaskDealSingle<Object> {

    private static final Logger logger = LoggerFactory.getLogger(ProductStatusSchedule.class);

    @Autowired
    private ExchangeProductService exchangeProductService;

    @Override
    public List<Object> selectTasks(String taskParameter, String ownSign, int taskItemNum, List<TaskItemDefine> taskItemList, int eachFetchDataNum)
            throws Exception {
        List<Object> list = null;
        try {
            logger.info("--------product status schedule()-----------");
            /**
             * 调用远程任务处理，有两点需要说明：
             * 1、因为无法预知每个任务的执行时间，因此此处为异步调用
             * 2、此处仅为触发任务这一动作，具体的处理逻辑应在具体的任务中
             */

            this.exchangeProductService.productStatusSchedule();
            Future<Result<Boolean>> future = RpcContext.getContext().getFuture();
            Result<Boolean> result = future.get();
            logger.info("--------result info: " + JSON.toJSONString(result));
        } catch (Exception e) {
            logger.error("ProductStatusSchedule.selectTasks occured exception.", e);
        } finally {
            /**
             * 此处为固定写法
             */
            list = new LinkedList<Object>();
            list.add(new Object());
        }
        return list;
    }

    @Override
    public Comparator<Object> getComparator() {
        return null;
    }

    @Override
    public boolean execute(Object task, String ownSign) throws Exception {
        return false;
    }

}
