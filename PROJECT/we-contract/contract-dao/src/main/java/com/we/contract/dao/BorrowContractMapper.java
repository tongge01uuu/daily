package com.we.contract.dao;

import com.we.contract.entity.BorrowContract;
import com.we.contract.entity.BorrowContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowContractMapper {
    int countByExample(BorrowContractExample example);

    int deleteByExample(BorrowContractExample example);

    int deleteByPrimaryKey(Integer contractid);

    int insert(BorrowContract record);

    int insertSelective(BorrowContract record);

    List<BorrowContract> selectByExample(BorrowContractExample example);

    BorrowContract selectByPrimaryKey(Integer contractid);

    int updateByExampleSelective(@Param("record") BorrowContract record, @Param("example") BorrowContractExample example);

    int updateByExample(@Param("record") BorrowContract record, @Param("example") BorrowContractExample example);

    int updateByPrimaryKeySelective(BorrowContract record);

    int updateByPrimaryKey(BorrowContract record);
}