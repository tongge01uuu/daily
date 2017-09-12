package com.we.contract.service;

import com.we.contract.dao.FinancePlanContractMapper;
import com.we.contract.entity.FinancePlanContract;
import com.we.contract.entity.FinancePlanContractExample;
import com.we.contract.param.FinancePlanContractParam;
import com.we.p2p.service.UPlanService;
import org.apache.commons.lang3.StringUtils;
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


    public List<FinancePlanContract> list(FinancePlanContractParam param)throws Exception
    {
        FinancePlanContractExample example=new FinancePlanContractExample();
        example.setOrderByClause("update_time desc");
        FinancePlanContractExample.Criteria criteria=example.createCriteria();
        if (param.getUserId()!=null)
        {
            criteria.andUserIdEqualTo(param.getUserId());
        }
        if (StringUtils.isNotBlank(param.getSubPointType()))
        {
            criteria.andSubPointTypeEqualTo(param.getSubPointType());
        }
        List<FinancePlanContract> list=financePlanContractMapper.selectByExample(example);
        return list;
    }

    public FinancePlanContract get(Integer id)
    {
        return financePlanContractMapper.selectByPrimaryKey(id);
    }
}
