package com.we.contract.dao;

import com.we.contract.entity.ContractTemplate;
import com.we.contract.entity.ContractTemplateExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractTemplateMapper {
    int countByExample(ContractTemplateExample example);

    int deleteByExample(ContractTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ContractTemplate record);

    int insertSelective(ContractTemplate record);

    List<ContractTemplate> selectByExampleWithBLOBs(ContractTemplateExample example);

    List<ContractTemplate> selectByExample(ContractTemplateExample example);

    ContractTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ContractTemplate record, @Param("example") ContractTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") ContractTemplate record, @Param("example") ContractTemplateExample example);

    int updateByExample(@Param("record") ContractTemplate record, @Param("example") ContractTemplateExample example);

    int updateByPrimaryKeySelective(ContractTemplate record);

    int updateByPrimaryKeyWithBLOBs(ContractTemplate record);

    int updateByPrimaryKey(ContractTemplate record);
}