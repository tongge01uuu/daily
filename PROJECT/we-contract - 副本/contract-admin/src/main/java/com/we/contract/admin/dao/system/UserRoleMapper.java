package com.we.contract.admin.dao.system;

import com.we.contract.admin.domain.system.vo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户角色DAO
 *
 * @author YK
 * @date   2017/7/24
 *
 */
@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer userRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer userRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    /**
     * 根据用户Id,查询用户角色信息
     * @param userId 用户Id
     * @return
     */
    List<UserRole> selectUserRolesListByUserId(@Param("userId") Integer userId);
}