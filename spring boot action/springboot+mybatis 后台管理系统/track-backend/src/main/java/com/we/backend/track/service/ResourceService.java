package com.we.backend.track.service;


import com.alibaba.fastjson.JSON;
import com.we.backend.track.dao.ResourceMapper;
import com.we.backend.track.dao.RoleResourceMapper;
import com.we.backend.track.domain.dto.ResourceChildrenMenuDto;
import com.we.backend.track.domain.dto.ResourceMenuDto;
import com.we.backend.track.domain.vo.Resource;
import com.we.backend.track.domain.vo.RoleResource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单资源服务类
 * @author YK
 * @date 2017/7/14
 *
 */
@Service
public class ResourceService {
	
	private  Log log = LogFactory.getLog(ResourceService.class);
	@Autowired
	private ResourceMapper resourceMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;

    public List<Resource> selectResourceList(Integer roleId)
    {
        RoleResource param=new RoleResource();
        param.setRoleId(roleId);
        List<RoleResource> roleResources=roleResourceMapper.getBySelective(param);
        List<Resource> resources=resourceMapper.selectResourceList();
        for (Resource resource:resources)
        {
            for (RoleResource roleResource:roleResources)
            {
                if (roleResource.getResourceId().equals(resource.getResId()));
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
    public String selectResourceResultPageList(Resource resource){

        List<Resource> resourceList = resourceMapper.selectResourceListByPage(resource);

        Long count = resourceMapper.selectCountResource(resource);
        resource.setTotalCount(count);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("totalSize",resource.getTotalSize());
        map.put("rows", resourceList);

        return JSON.toJSONString(map);
    }

    public  Resource selectByPrimaryKey(Integer resId){
        return resourceMapper.selectByPrimaryKey(resId);
    }


    /**
     * 顶部菜单展示封装
     * @return
     */
    public String selectResMenuTop(){

        List<ResourceMenuDto> parentResList =  resourceMapper.selectParentIdResList();
        if(null != parentResList && !parentResList.isEmpty()){
            return JSON.toJSONString(parentResList);
        }
        return null;

    }

    public  String selectResLevelListByParentid(Integer resParentid) {

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
            return JSON.toJSONString(resourceMenu,true);

        }
        return null;
    }
}
