/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2017 © yangxiaobing, 873559947@qq.com
 *
 * This file is part of contentManagerSystem.
 * contentManagerSystem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * contentManagerSystem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with contentManagerSystem.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 这个文件是contentManagerSystem的一部分。
 * 您可以单独使用或分发这个文件，但请不要移除这个头部声明信息.
 * contentManagerSystem是一个自由软件，您可以自由分发、修改其中的源代码或者重新发布它，
 * 新的任何修改后的重新发布版必须同样在遵守GPL3或更后续的版本协议下发布.
 * 关于GPL协议的细则请参考COPYING文件，
 * 您可以在contentManagerSystem的相关目录中获得GPL协议的副本，
 * 如果没有找到，请连接到 http://www.gnu.org/licenses/ 查看。
 *
 * - Author: yangxiaobing
 * - Contact: 873559947@qq.com
 * - License: GNU Lesser General Public License (GPL)
 * - source code availability: http://git.oschina.net/yangxiaobing_175/contentManagerSystem
 */
package com.yxb.cms.domain.vo;


import com.yxb.cms.domain.dto.PageDto;

import java.io.Serializable;
import java.util.Date;



/**
 * 角色管理实体
 * @author yangxiaobing
 * @date 2017/7/24
 */
public class Role extends PageDto implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_role.role_id
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_role.role_name
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_role.role_status
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    private Integer roleStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_role.role_remark
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    private String roleRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_role.creator
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_role.create_time
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_role.modifier
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    private String modifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_role.modifier_time
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    private Date modifierTime;

    
    private String beginTime;
    private String endTime;
    
    
    /**
     * 角色所对应的资源Id
     */
    private String resourceIds;
    /**
     * 角色所对应的资源名称
     */
    private String resourceNames;
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_role.role_id
     *
     * @return the value of cc_role.role_id
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_role.role_id
     *
     * @param roleId the value for cc_role.role_id
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_role.role_name
     *
     * @return the value of cc_role.role_name
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_role.role_name
     *
     * @param roleName the value for cc_role.role_name
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_role.role_status
     *
     * @return the value of cc_role.role_status
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public Integer getRoleStatus() {
        return roleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_role.role_status
     *
     * @param roleStatus the value for cc_role.role_status
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_role.role_remark
     *
     * @return the value of cc_role.role_remark
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public String getRoleRemark() {
        return roleRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_role.role_remark
     *
     * @param roleRemark the value for cc_role.role_remark
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark == null ? null : roleRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_role.creator
     *
     * @return the value of cc_role.creator
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_role.creator
     *
     * @param creator the value for cc_role.creator
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_role.create_time
     *
     * @return the value of cc_role.create_time
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_role.create_time
     *
     * @param createTime the value for cc_role.create_time
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_role.modifier
     *
     * @return the value of cc_role.modifier
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_role.modifier
     *
     * @param modifier the value for cc_role.modifier
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cc_role.modifier_time
     *
     * @return the value of cc_role.modifier_time
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public Date getModifierTime() {
        return modifierTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cc_role.modifier_time
     *
     * @param modifierTime the value for cc_role.modifier_time
     *
     * @mbggenerated Tue Nov 29 21:23:21 CST 2016
     */
    public void setModifierTime(Date modifierTime) {
        this.modifierTime = modifierTime;
    }
    
    
    
    
    
    
    public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getResourceNames() {
		return resourceNames;
	}

	public void setResourceNames(String resourceNames) {
		this.resourceNames = resourceNames;
	}
}