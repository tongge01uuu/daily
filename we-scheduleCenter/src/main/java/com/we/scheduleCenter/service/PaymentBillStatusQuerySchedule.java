package com.we.scheduleCenter.service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import com.site.bean.resultBean.Result;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import com.we.exchange.service.PaymentBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by qibaichao on 2016/5/26.
 */
@Service("paymentBillStatusQuerySchedule")
public class PaymentBillStatusQuerySchedule implements IScheduleTaskDealSingle<Object> {

    private static final Logger logger = LoggerFactory.getLogger(PaymentBillStatusQuerySchedule.class);

    @Autowired
    private PaymentBillService paymentBillService;

    @Override
    public List<Object> selectTasks(String taskParameter, String ownSign, int taskItemNum, List<TaskItemDefine> taskItemList, int eachFetchDataNum)
            throws Exception {
        List<Object> list = null;
        try {
            logger.info("--------还款状态查询开始-----------");
            this.paymentBillService.statusQuery();
            logger.info("--------还款状态查询结束-----------");
        } catch (Exception e) {
            logger.error("PaymentBillStatusQuerySchedule.selectTasks occured exception.", e);
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
