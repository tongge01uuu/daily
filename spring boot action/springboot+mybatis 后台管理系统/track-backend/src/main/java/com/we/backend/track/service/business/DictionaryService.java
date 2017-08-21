package com.we.backend.track.service.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.backend.track.controller.business.DictionaryController;
import com.we.backend.track.dao.business.DictionaryMapper;
import com.we.backend.track.domain.business.po.Dictionary;
import com.we.backend.track.domain.business.po.DictionaryExample;
import com.we.backend.track.domain.system.bo.ResultEntity;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Dictionary> getDictionarys(Integer pid) throws Exception
    {
        List<Dictionary> result= null;
        try {
            result = new ArrayList<>();
            DictionaryExample example=new DictionaryExample();
            DictionaryExample.Criteria criteria= example.createCriteria();
            if (pid==null)
            {
                //查所有字典元素
                result=dictionaryMapper.selectByExample(example);
            }else
            {
                //查对应pid元素
                criteria.andPidEqualTo(pid);
                result=dictionaryMapper.selectByExample(example);
            }
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }

    public ResultEntity saveOrUpdate(Dictionary dictionary)throws Exception
    {
        ResultEntity resultEntity=ResultEntity.build();
        if (dictionary.getId()!=null&&dictionary.getId()>0)
        {
            dictionaryMapper.updateByPrimaryKeySelective(dictionary);
        }else {
            dictionaryMapper.insertSelective(dictionary);
        }
        return resultEntity;
    }

    public Dictionary get(Integer dictionaryId)throws Exception
    {
        Dictionary dictionary=dictionaryMapper.selectByPrimaryKey(dictionaryId);
        return dictionary;
    }

    public ResultEntity fail(Integer dictionaryId)throws Exception
    {
        ResultEntity resultEntity=ResultEntity.build();
        Dictionary dictionary = get(dictionaryId);
        dictionary.setAccess(0);
        saveOrUpdate(dictionary);
        return resultEntity;
    }
    @Transactional
    public ResultEntity failBatch(Integer[] dictionaryIds)throws Exception
    {
        ResultEntity resultEntity=ResultEntity.build();
        if (dictionaryIds!=null && dictionaryIds.length>0)
        {
            int count=dictionaryMapper.doBatchAccess(dictionaryIds,0);
            resultEntity.setData(count);
            resultEntity.setMessage(String.format("成功更新%d条数据",count));
        }
        return resultEntity;
    }

}
