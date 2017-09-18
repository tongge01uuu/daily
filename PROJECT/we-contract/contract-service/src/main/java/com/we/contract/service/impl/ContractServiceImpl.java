package com.we.contract.service.impl;

import com.site.bean.resultBean.Result;
import com.we.contract.dao.ContractTemplateMapper;
import com.we.contract.dao.FinancePlanContractMapper;
import com.we.contract.entity.ContractTemplate;
import com.we.contract.entity.FinancePlanContract;
import com.we.contract.enums.ContractType;
import com.we.contract.service.ContractService;
import com.we.contract.util.MessageConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.stereotype.Service;

/**
 * Created by yukai on 2017-9-18.
 */
@Service("contractService")
public class ContractServiceImpl implements ContractService{
    protected Logger logger= LoggerFactory.getLogger(ContractServiceImpl.class);
    @Autowired
    private ContractTemplateMapper contractTemplateMapper;
    @Autowired
    private FinancePlanContractMapper financePlanContractMapper;
    @Override
    public Result<ContractTemplate> getTemplate(Integer id) {
        Result result=Result.build();
        try {
            ContractTemplate contractTemplate=contractTemplateMapper.selectByPrimaryKey(id);
            result.setValue(contractTemplate);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            result.withError(MessageConstant.GLOBAL_ERROR);
        }
        return result;
    }

    @Override
    public Result getContract(Integer id, ContractType contractType) {
        Result result=Result.build();
        try {
            switch (contractType){
                case FINANCE_PLAN:{
                    FinancePlanContract financePlanContract=financePlanContractMapper.selectByPrimaryKey(id);
                    result.setValue(financePlanContract);
                }
                case LOAN_TRANSFER:{

                }
                case BORROW:{

                }
                break;
            }
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            result.withError(MessageConstant.GLOBAL_ERROR);
        }
        return result;
    }

    @Override
    public Result saveContractRecord(Object contract, ContractType contractType) {
        Result result=Result.build();
        String className=contract.getClass().getName();
        if (StringUtils.isBlank(className) || !className.equals(contractType.getClassName()))
        {
            logger.error("对象类型：{},参数指示类型{}",className,contractType.getClassName());
            result.withError(MessageConstant.TYPE_ERROR);
            return result;
        }
        try {
            switch (contractType)
            {
                case FINANCE_PLAN:{
                    FinancePlanContract financePlanContract=(FinancePlanContract)contract;
                    financePlanContractMapper.insert(financePlanContract);
                }
                case LOAN_TRANSFER:{

                }
                case BORROW:{

                }
                break;

            }
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            result.withError(MessageConstant.GLOBAL_ERROR);
        }
        return result;
    }
}
