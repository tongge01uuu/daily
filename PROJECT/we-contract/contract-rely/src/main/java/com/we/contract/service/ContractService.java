package com.we.contract.service;

import com.site.bean.resultBean.Result;
import com.we.contract.entity.ContractTemplate;
import com.we.contract.entity.FinancePlanContract;
import com.we.contract.enums.ContractType;

import java.util.List;

/**
 * Created by yukai on 2017-9-18.
 */
public interface ContractService {
    public Result<ContractTemplate> getTemplate(Integer id);

    public Result getContract(Integer id, ContractType contractType);

    public Result saveContractRecord(Object contract,ContractType contractType);

}
