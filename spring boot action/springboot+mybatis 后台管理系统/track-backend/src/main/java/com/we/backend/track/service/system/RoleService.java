package com.we.backend.track.service.system;

import com.alibaba.fastjson.JSON;
import com.we.backend.track.architect.constant.BussinessCode;
import com.we.backend.track.architect.utils.BussinessMsgUtil;
import com.we.backend.track.architect.utils.ParseObjectUtils;
import com.we.backend.track.dao.system.RoleMapper;
import com.we.backend.track.dao.system.RoleResourceMapper;
import com.we.backend.track.domain.system.bo.ResultEntity;
import com.we.backend.track.domain.system.vo.Role;
import com.we.backend.track.domain.system.vo.RoleResource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色信息服务类
 *
 * @author YK
 * @date 2017/7/14
 */

@Service
public class RoleService {

    private Logger log = LoggerFactory.getLogger(RoleService.class);


    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Transactional
    public ResultEntity grantResources2Role(RoleResource roleResource)
    {
        ResultEntity resultEntity = ResultEntity.build();
        Role role=roleMapper.selectByPrimaryKey(roleResource.getRoleId());
        if (role==null)
        {
            resultEntity.withError(String.format("ID为%s的角色已经不存在",roleResource.getRoleId()));
        }
        try {
            RoleResource param=new RoleResource();
            param.setRoleId(roleResource.getRoleId());
            List<RoleResource> list=roleResourceMapper.getBySelective(param);
            if (list!=null && list.size()>0)
            {
                RoleResource roleResourcePo=list.get(0);
                roleResourcePo.setResourceIds(roleResource.getResourceIds());
                roleResourcePo.setModifier(roleResource.getCreator());
                roleResourceMapper.updateByPrimaryKeySelective(roleResourcePo);
            }else {
                roleResourceMapper.insertSelective(roleResource);
            }
            role.setModifierTime(new Date());
            roleMapper.updateByPrimaryKey(role);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            resultEntity.withError("授权异常");
        }
        return resultEntity;
    }

    public List<Role> selectRoleList()
    {
        return roleMapper.selectRoleList();
    }

    /**
     * 根据角色Id查询角色信息
     *
     * @param roleId 角色Id
     * @return
     */
    public Role selectRoleById(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    /**
     * 角色信息分页显示
     *
     * @param role 角色实体
     * @return
     */
    public String selectRoleResultPageList(Role role) {

        List<Role> roleList = roleMapper.selectRoleListByPage(role);
        Long count = roleMapper.selectCountRole(role);
        role.setTotalCount(count);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("totalSize", role.getTotalSize());
        map.put("rows", roleList);

        return JSON.toJSONString(map);
    }


    /**
     * 保存角色信息
     *
     * @param role      角色对象
     * @param loginName 当前登录用户
     * @return
     * @throws Exception
     */
    @Transactional
    public ResultEntity saveOrUpdateRole(Role role, String loginName) throws Exception {
        log.info("保存用户角色开始");
        long start = System.currentTimeMillis();
        try {
            //保存角色信息
            if (null == role.getRoleId()) {
                role.setCreator(loginName);
                role.setCreateTime(new Date());
                roleMapper.insertSelective(role);
            } else {
                //更新角色
                role.setModifier(loginName);
                role.setModifierTime(new Date());
                roleMapper.updateByPrimaryKeySelective(role);
            }
        } catch (Exception e) {
            log.error("保存角色方法内部错误", e);
            throw e;
        } finally {
            log.info("保存角色信息结束,用时" + (System.currentTimeMillis() - start) + "毫秒");
        }
        return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
    }



    /**
     * 查询状态为有效,待分配的角色信息(用以用户分配角色时显示)
     * @param roleIds 已分配角色Id,以逗号分割
     */
    public String selectUserRoleByRoleIdList(String roleIds){
        Map<String, Object> map = new HashMap<String, Object>();
        //如果已给用户分配角色,则待分配用户显示栏中去除已分配的角色信息
        if(StringUtils.isNotEmpty(roleIds)){
            Integer[] roleIdInt = ParseObjectUtils.strArrayToIntArray(roleIds);
            List<Role> lists = roleMapper.selectUserRoleByRoleIdList(roleIdInt);
            map.put("rows", lists);
            return JSON.toJSONString(map);
        }
        map.put("rows", roleMapper.selectRoleList());
        //没有给用户分配角色,待分配显示栏中显示所有角色信息
        return JSON.toJSONString(map);
    }
    /**
     * 查询状态为有效,已分配的角色信息(用已用户分配角色显示)
     * @param roleIds 角色Id
     * @return
     */
    public String selectDeceasedUserRoleByRoleIdList(String roleIds){
        Map<String, Object> map = new HashMap<String, Object>();
        //没有给用户分配角色，则已分配角色列表为空
        if(StringUtils.isNotEmpty(roleIds)){
            Integer[] roleIdInt = ParseObjectUtils.strArrayToIntArray(roleIds);
            List<Role> lists = roleMapper.selectDeceasedUserRoleByRoleIdList(roleIdInt);
            map.put("rows", lists);
            return JSON.toJSONString(map);
        }
        return null;
    }
}
