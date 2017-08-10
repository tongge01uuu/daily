package com.we.backend.track.dao;

import com.we.backend.track.domain.vo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 角色DAO
 *
 * @author YK
 * @date 2017/7/24
 */
@Mapper
public interface RoleMapper {

    int deleteByPrimaryKey(Integer roleId);


    int insert(Role record);


    int insertSelective(Role record);


    Role selectByPrimaryKey(Integer roleId);


    int updateByPrimaryKeySelective(Role record);


    int updateByPrimaryKey(Role record);


    /**
     * 查询角色总记录数
     * @param role 角色实体
     * @return
     */
    Long selectCountRole(Role role);

    /**
     * 角色信息分页列表显示
     * @param role 角色实体
     * @return
     */
    List<Role> selectRoleListByPage(Role role);


    /**
     * 根据用户Id查询用户所对应的角色信息
     * @param userId 用户Id
     * @return
     */
    List<Role> selectUserRolesByUserId(@Param("userId") Integer userId);

    /**
     * 查询状态为有效的所有角色信息 role_status = 0
     * @return
     */
     List<Role>selectRoleList();

    /**
     *  查询状态为有效的待分配角色信息(已分配的角色信息除外)
     *  @param roleId 角色Id
     */
    List<Role> selectUserRoleByRoleIdList(Integer[] roleId);

    /**
     * 查询状态为有效的已分配角色信息
     * @param roleId 角色Id
     * @return
     */
    List<Role> selectDeceasedUserRoleByRoleIdList(Integer[] roleId);


}