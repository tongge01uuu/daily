package com.we.contract.dao.system;


import com.we.contract.domain.system.dto.ResourceMenuDto;
import com.we.contract.domain.system.vo.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单资源DAO
 *
 *
 */
@Repository
public interface ResourceMapper {
    int deleteByPrimaryKey(Integer resId);

    int insert(Resource record);

    void insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer resId);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);


    /**
     * 资源信息COUNT
     * @param resource 资源实体
     * @return
     */
    Long selectCountResource(Resource resource);
    /**
     * 资源信息分页列表显示
     * @param resource 资源实体
     * @return
     */
    List<Resource> selectResourceListByPage(Resource resource);

    /**
     * 查询所有资源信息(有效的)
     * @return
     */
    List<Resource> selectResourceList();

    /**
     * 查询资源父级菜单
     * @return
     */
    List<ResourceMenuDto>selectParentIdResList();

    List<Resource> selectResLevelListByParentid(@Param("resParentid") Integer resParentid);

    List<Resource> selectParentResources();


    
}