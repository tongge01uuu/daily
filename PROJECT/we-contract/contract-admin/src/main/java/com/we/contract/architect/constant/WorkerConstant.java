package com.we.contract.architect.constant;

import com.alibaba.fastjson.JSON;
import com.we.contract.dao.system.UserMapper;
import com.we.contract.entity.system.vo.User;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yukai on 2017-8-23.
 */
@Component
public class WorkerConstant {
    private static Logger logger= LoggerFactory.getLogger(WorkerConstant.class);
    @Autowired
    private UserMapper userMapper;
    public static final Map<Integer,User> USER_MAP=new ConcurrentHashMap<>();
    @PostConstruct
    public final void init()
    {
        logger.info("-------------加载Worker数据-开始---------------");
        try {
            List<User> users=userMapper.selectAll();
            for (User cell:users)
            {
                USER_MAP.put(cell.getUserId(),cell);
            }
        } catch (Exception e) {
            logger.error("-------------加载Worker数据-异常---------------\n{}", ExceptionUtils.getStackTrace(e));
        }
        logger.info("-------------加载字典数据-结束---------------\nUSER_MAP\n{} ",
                JSON.toJSON(USER_MAP));
    }
}
