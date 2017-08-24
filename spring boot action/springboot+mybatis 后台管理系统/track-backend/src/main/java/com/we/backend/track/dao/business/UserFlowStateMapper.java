package com.we.backend.track.dao.business;

import com.we.backend.track.domain.business.po.UserFlowState;
import com.we.backend.track.domain.business.po.UserFlowStateExample;
import java.util.List;

import com.we.backend.track.domain.business.vo.UserFlowStateVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserFlowStateMapper {
    int countByExample(UserFlowStateExample example);

    int deleteByExample(UserFlowStateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFlowState record);

    int insertSelective(UserFlowState record);

    List<UserFlowState> selectByExample(UserFlowStateExample example);

    List<UserFlowStateVo> selectVoByExample(UserFlowStateExample example);

    UserFlowState selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFlowState record, @Param("example") UserFlowStateExample example);

    int updateByExample(@Param("record") UserFlowState record, @Param("example") UserFlowStateExample example);

    int updateByPrimaryKeySelective(UserFlowState record);

    int updateByPrimaryKey(UserFlowState record);
}