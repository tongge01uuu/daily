package com.we.backend.track.dao.business;

import com.we.backend.track.domain.business.po.WorkSheet;
import com.we.backend.track.domain.business.po.WorkSheetExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface WorkSheetMapper {
    int countByExample(WorkSheetExample example);

    int deleteByExample(WorkSheetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkSheet record);

    int insertSelective(WorkSheet record);

    List<WorkSheet> selectByExample(WorkSheetExample example);

    WorkSheet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkSheet record, @Param("example") WorkSheetExample example);

    int updateByExample(@Param("record") WorkSheet record, @Param("example") WorkSheetExample example);

    int updateByPrimaryKeySelective(WorkSheet record);

    int updateByPrimaryKey(WorkSheet record);
}