package com.we.backend.track.service.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.backend.track.controller.business.DictionaryController;
import com.we.backend.track.dao.business.DictionaryMapper;
import com.we.backend.track.domain.business.po.Dictionary;
import com.we.backend.track.domain.business.po.DictionaryExample;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yukai on 2017-8-16.
 */
@Service
public class DictionaryService {
    private static Logger logger= LoggerFactory.getLogger(DictionaryService.class);
    @Autowired
    private DictionaryMapper dictionaryMapper;

    public List<Dictionary> getDictionary(Integer pid) throws Exception
    {
        List<Dictionary> result= null;
        try {
            result = new ArrayList<>();
            DictionaryExample example=new DictionaryExample();
            DictionaryExample.Criteria criteria= example.createCriteria().andAccessEqualTo(1);
            if (pid==null)
            {
                //查所有字典元素
                PageHelper.offsetPage(0,2,true);
                result=dictionaryMapper.selectByExample(example);
            }else
            {
                //查对应pid元素
                criteria.andPidEqualTo(pid);
                result=dictionaryMapper.selectByExample(example);
            }
            PageInfo pageInfo=new PageInfo(result);
            System.out.println(pageInfo.getTotal()+"-----"+JSON.toJSONString(pageInfo));
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }

    public void selectAll()
    {
        PageHelper.startPage(1,2);
        dictionaryMapper.selectAll();
    }

}
