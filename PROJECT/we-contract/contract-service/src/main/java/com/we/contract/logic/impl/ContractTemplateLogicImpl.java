package com.we.contract.logic.impl;

import com.we.contract.dao.ContractTemplateMapper;
import com.we.contract.entity.ContractTemplateExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yukai on 2017-8-31.
 */
@Component
public class ContractTemplateLogicImpl implements ContractTemplateLogic{
    @Autowired
    private ContractTemplateMapper contractTemplateMapper;
    @Override
    public List select(ContractTemplateExample example) {
        return contractTemplateMapper.selectByExample(example);
    }
}
