package com.we.contract.dao;

import com.we.contract.entity.FinancePlanContract;
import com.we.contract.entity.FinancePlanContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinancePlanContractMapper {
    int countByExample(FinancePlanContractExample example);

    int deleteByExample(FinancePlanContractExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinancePlanContract record);

    int insertSelective(FinancePlanContract record);

    List<FinancePlanContract> selectByExample(FinancePlanContractExample example);

    FinancePlanContract selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinancePlanContract record, @Param("example") FinancePlanContractExample example);

    int updateByExample(@Param("record") FinancePlanContract record, @Param("example") FinancePlanContractExample example);

    int updateByPrimaryKeySelective(FinancePlanContract record);

    int updateByPrimaryKey(FinancePlanContract record);
}