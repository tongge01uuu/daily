package com.we.backend.track.dao.business;

import com.we.backend.track.domain.business.po.UserFlowCount;
import com.we.backend.track.domain.business.po.UserFlowCountExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserFlowCountMapper {
    int countByExample(UserFlowCountExample example);

    int deleteByExample(UserFlowCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFlowCount record);

    int insertSelective(UserFlowCount record);

    List<UserFlowCount> selectByExample(UserFlowCountExample example);

    UserFlowCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFlowCount record, @Param("example") UserFlowCountExample example);

    int updateByExample(@Param("record") UserFlowCount record, @Param("example") UserFlowCountExample example);

    int updateByPrimaryKeySelective(UserFlowCount record);

    int updateByPrimaryKey(UserFlowCount record);
}