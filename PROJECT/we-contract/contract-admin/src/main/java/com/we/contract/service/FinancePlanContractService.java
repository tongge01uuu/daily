package com.we.contract.service;

import com.we.contract.dao.FinancePlanContractMapper;
import com.we.contract.entity.FinancePlanContract;
import com.we.contract.entity.FinancePlanContractExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yukai on 2017-9-11.
 */
@Service
public class FinancePlanContractService {
    @Autowired
    private FinancePlanContractMapper financePlanContractMapper;

    public List<FinancePlanContract> list(FinancePlanContract financePlanContract)throws Exception
    {
        FinancePlanContractExample example=new FinancePlanContractExample();
        example.setOrderByClause("update_time desc");
        FinancePlanContractExample.Criteria criteria=example.createCriteria();
        List<FinancePlanContract> list=financePlanContractMapper.selectByExample(example);
        return list;
    }

    public FinancePlanContract get(Integer id)
    {
        return financePlanContractMapper.selectByPrimaryKey(id);
    }
}
