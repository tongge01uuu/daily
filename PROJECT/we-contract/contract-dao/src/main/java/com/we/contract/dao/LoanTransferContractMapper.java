package com.we.contract.dao;

import com.we.contract.entity.LoanTransferContract;
import com.we.contract.entity.LoanTransferContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoanTransferContractMapper {
    int countByExample(LoanTransferContractExample example);

    int deleteByExample(LoanTransferContractExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoanTransferContract record);

    int insertSelective(LoanTransferContract record);

    List<LoanTransferContract> selectByExample(LoanTransferContractExample example);

    LoanTransferContract selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoanTransferContract record, @Param("example") LoanTransferContractExample example);

    int updateByExample(@Param("record") LoanTransferContract record, @Param("example") LoanTransferContractExample example);

    int updateByPrimaryKeySelective(LoanTransferContract record);

    int updateByPrimaryKey(LoanTransferContract record);
}