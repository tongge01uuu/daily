package com.we.contract.admin.domain.system.dto;

import java.io.Serializable;

/**
 * 资源菜单Dto
 * @author YK
 * @date 2017/7/28
 */

public class ResourceChildrenMenuDto implements Serializable {

    //菜单名称
    private String title;

    // 菜单图标
    private String icon;

    //菜单链接
    private String href;




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }




}
