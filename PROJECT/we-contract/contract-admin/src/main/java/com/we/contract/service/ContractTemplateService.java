package com.we.contract.service;

import com.we.contract.constant.ContractTemplateType;
import com.we.contract.dao.ContractTemplateMapper;
import com.we.contract.entity.ContractTemplate;
import com.we.contract.entity.ContractTemplateExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yukai on 2017-9-4.
 */
@Service
public class ContractTemplateService {
    @Autowired
    private ContractTemplateMapper contractTemplateMapper;

    public List<ContractTemplate> list(ContractTemplateType contractTemplateType)
    {
        ContractTemplateExample example=new ContractTemplateExample();
        ContractTemplateExample.Criteria criteria=example.createCriteria();
        if (contractTemplateType!=null)
        {
            criteria.andTypeEqualTo(contractTemplateType.name());
        }
        List list=contractTemplateMapper.selectByExample(example);
        return list;
    }
}
