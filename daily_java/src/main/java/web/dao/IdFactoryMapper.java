package web.dao;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.NotEmpty;
import web.pojo.IdFactory;
import web.pojo.IdFactoryExample;

public interface IdFactoryMapper {
    long countByExample(IdFactoryExample example);

    int deleteByExample(IdFactoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IdFactory record);

    int insertSelective(IdFactory record);

    List<IdFactory> selectByExample(IdFactoryExample example);

    IdFactory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IdFactory record, @Param("example") IdFactoryExample example);

    int updateByExample(@Param("record") IdFactory record, @Param("example") IdFactoryExample example);

    int updateByPrimaryKeySelective(IdFactory record);

    int updateByPrimaryKey(IdFactory record);
}