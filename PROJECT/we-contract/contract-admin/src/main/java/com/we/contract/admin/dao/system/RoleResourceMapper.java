package com.we.contract.admin.dao.system;

import com.we.contract.admin.domain.system.vo.RoleResource;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 角色资源关联DAO
 *
 * @author YK
 * @date 2017 7/24
 */
@Repository
public interface RoleResourceMapper {
    int deleteByPrimaryKey(Integer roleResId);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(Integer roleResId);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);

    List<RoleResource> getBySelective(RoleResource roleResource);
}