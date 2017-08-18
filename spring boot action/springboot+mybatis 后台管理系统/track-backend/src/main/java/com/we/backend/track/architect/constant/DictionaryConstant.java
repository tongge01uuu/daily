package com.we.backend.track.architect.constant;

import com.alibaba.fastjson.JSON;
import com.we.backend.track.dao.business.DictionaryMapper;
import com.we.backend.track.domain.business.po.Dictionary;
import com.we.backend.track.domain.business.po.DictionaryExample;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.security.pkcs11.P11Util;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by yukai on 2017-8-16.
 */
@Component
public class DictionaryConstant {
    private static Logger logger= LoggerFactory.getLogger(DictionaryConstant.class);
    @Autowired
    private DictionaryMapper dictionaryMapper;
    //Map<pid,children>
    public Map<Integer,List<Dictionary>> dicData=new HashMap<Integer, List<Dictionary>>();

    @PostConstruct
    public void init()
    {
        logger.info("-------------加载字典数据-开始---------------");
        try {
            DictionaryExample dictionaryExample=new DictionaryExample();
            //0-失效 1-有效
            dictionaryExample.createCriteria().andAccessEqualTo(1).andPidNotEqualTo(0);
            List<Dictionary> dictionaryListChildren=dictionaryMapper.selectByExample(dictionaryExample);
            dictionaryExample.clear();
            dictionaryExample.createCriteria().andAccessEqualTo(1).andPidEqualTo(0);
            List<Dictionary> dictionaryListParent=dictionaryMapper.selectByExample(dictionaryExample);
//            for (int type:DictionaryType.allTypes())
//            {
//                dicData.put(type,new ArrayList<>());
//            }
            for (Dictionary parent:dictionaryListParent)
            {
                dicData.put(parent.getId(),new ArrayList<>());
            }
            for (Dictionary dictionary:dictionaryListChildren)
            {
                int pid=dictionary.getPid();
                List list=dicData.get(pid);
                if (list==null)
                {
                    throw new RuntimeException(String.format("字典类型数据 -%s- 未在系统中声明，请删除数据库中pid=%s的数据 或者添加 id=%s的父节点",pid,pid,pid));
                }
                list.add(dictionary);
            }

        } catch (Exception e) {
            logger.error("-------------加载字典数据-异常---------------\n{}", ExceptionUtils.getStackTrace(e));
        }
        logger.info("-------------加载字典数据-结束---------------\n{}", JSON.toJSON(dicData));

    }
}
