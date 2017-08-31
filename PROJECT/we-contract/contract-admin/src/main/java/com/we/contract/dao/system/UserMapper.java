package com.we.contract.dao.system;


import com.we.contract.domain.system.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * 用户信息DAO
 *
 *
 */
@Repository
public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);


    int insert(User record);


    int insertSelective(User record);


    User selectByPrimaryKey(Integer userId);


    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKey(User record);

    /**
     * 更改用户状态
     * @param params 参数
     */
    void updateUserByStatus(Map<String, Object> params);

    /**
     * 根据登陆用户名和状态查询用户信息
     * @param userLoginName
     * @param userStatus
     * @return
     */
    User selectUserByloginNameAndStatus(@Param("userLoginName") String userLoginName, @Param("userStatus") Long userStatus);


    /**
     * 查询用户总记录数
     * @param user 用户实体
     * @return
     */
    Long selectCountUser(User user);
    /**
     * 用户信息分页列表显示
     * @param user 用户实体
     * @return
     */
    List<User> selectUserListByPage(User user);

    /**
     * 用户信息列表信息List
     * @param user 用户实体
     * @return
     */
    List<User>selectUserList(User user);
    List<User>selectAll();


    /**
     * 验证用户账号唯一性
     * @param userLoginName 登陆账号
     * @param userId  用户Id
     * @return
     */
    Long selectUserLoginNameCheck(@Param("userLoginName") String userLoginName, @Param("userId") Integer userId);
    
    
    
    
}