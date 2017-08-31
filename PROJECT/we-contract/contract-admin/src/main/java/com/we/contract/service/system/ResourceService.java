package com.we.contract.service.system;


import com.we.contract.architect.constant.BussinessCode;
import com.we.contract.dao.system.ResourceMapper;
import com.we.contract.dao.system.RoleResourceMapper;
import com.we.contract.domain.system.bo.ResultEntity;
import com.we.contract.domain.system.dto.ResourceChildrenMenuDto;
import com.we.contract.domain.system.dto.ResourceMenuDto;
import com.we.contract.domain.system.vo.Resource;
import com.we.contract.domain.system.vo.RoleResource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 菜单资源服务类
 * @author YK
 * @date 2017/7/14
 *
 */
@Service
public class ResourceService {
	
	private Logger log = LoggerFactory.getLogger(ResourceService.class);
	@Autowired
	private ResourceMapper resourceMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;

    /**
     * 菜单便捷/新增
     * @param resource
     * @return
     */
    public ResultEntity saveOrUpdate(Resource resource)
    {
        ResultEntity resultEntity = ResultEntity.build();
        if (resource.getResParentid()!=null&&resource.getResParentid()!=0)
        {
            Resource parentResource=resourceMapper.selectByPrimaryKey(resource.getResParentid());
            //设置菜单的层级（父级+1）
            resource.setResType(parentResource.getResType()+1);
        }
        try {
            if (resource.getResId()==null)
            {
                //新增
                resourceMapper.insertSelective(resource);
            }else {
                //编辑
                resourceMapper.updateByPrimaryKeySelective(resource);
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            resultEntity.withError("菜单资源处理异常");
        }
        return resultEntity;
    }
    /**
     * 角色授权用， 查询所有资源
     * @param roleId
     * @return
     */
    public List<Resource> selectResourceList(Integer roleId)
    {
        RoleResource param=new RoleResource();
        param.setRoleId(roleId);
        List<Resource> resources=resourceMapper.selectResourceList();
        List<RoleResource> roleResources=roleResourceMapper.getBySelective(param);
        if (roleResources==null||roleResources.size()==0)
        {
            return resources;
        }
        String resourceIdString=roleResources.get(0).getResourceIds();
        List<String> resourceIds= Arrays.asList(StringUtils.split(resourceIdString,","));
        for (Resource resource:resources)
        {
            for (String resourceId:resourceIds)
            {
                if (resourceId.equals(String.valueOf(resource.getResId())))
                {
                    resource.setChecked(true);
                }
            }
        }
        return resources;
    }
    /**
     * 资源信息分页显示
     * @param resource
     * @return
     */
    public Map<String, Object> selectResourceResultPageList(Resource resource){

        List<Resource> resourceList = resourceMapper.selectResourceListByPage(resource);

        Long count = resourceMapper.selectCountResource(resource);
        resource.setTotalCount(count);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("totalSize",resource.getTotalSize());
        map.put("rows", resourceList);

        return map;
    }

    public  Resource selectByPrimaryKey(Integer resId){
        return resourceMapper.selectByPrimaryKey(resId);
    }

    /**
     * 查询所有父级菜单
     * @return
     */
    public ResultEntity selectParentResources()
    {
        ResultEntity resultEntity=ResultEntity.build();
        try {
            List<Resource> resources=resourceMapper.selectParentResources();
            resultEntity.setData(resources);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            resultEntity.withError(BussinessCode.GLOBAL_ERROR);
        }
        return resultEntity;
    }

    /**
     * 顶部菜单展示封装
     * @return
     */
    public List<ResourceMenuDto> selectResMenuTop(){

        List<ResourceMenuDto> parentResList =  resourceMapper.selectParentIdResList();
        if(null != parentResList && !parentResList.isEmpty()){
            return parentResList;
        }
        return null;

    }

    public  List<ResourceMenuDto> selectResLevelListByParentid(Integer resParentid) {

        //二级菜单
        List<Resource> ResLevel2List =resourceMapper.selectResLevelListByParentid(resParentid);
        if(null != ResLevel2List && !ResLevel2List.isEmpty()){

            List<ResourceMenuDto> resourceMenu = new ArrayList<>();

            for (Resource resource2 : ResLevel2List) {
                ResourceMenuDto menuDto = new ResourceMenuDto();
                menuDto.setTitle(resource2.getResName());
                menuDto.setIcon(resource2.getResImage());
                menuDto.setHref(resource2.getResLinkAddress());

                //三级菜单
                List<Resource> ResLevel3List =resourceMapper.selectResLevelListByParentid(resource2.getResId());
                if(null != ResLevel3List && !ResLevel3List.isEmpty()) {
                    List<ResourceChildrenMenuDto> childrens = new ArrayList<>();
                    for (Resource resource3 : ResLevel3List) {

                        ResourceChildrenMenuDto children = new ResourceChildrenMenuDto();
                        children.setTitle(resource3.getResName());
                        children.setIcon(resource3.getResImage());
                        children.setHref(resource3.getResLinkAddress());
                        childrens.add(children);
                    }
                    menuDto.setChildren(childrens);
                }
                resourceMenu.add(menuDto);

            }
            return resourceMenu;

        }
        return null;
    }
}
