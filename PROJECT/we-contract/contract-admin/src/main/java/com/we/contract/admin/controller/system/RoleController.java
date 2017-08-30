package com.we.contract.admin.controller.system;

import com.we.contract.admin.architect.constant.BussinessCode;
import com.we.contract.admin.architect.utils.BussinessMsgUtil;
import com.we.contract.admin.controller.BasicController;
import com.we.contract.admin.domain.system.bo.ResultEntity;
import com.we.contract.admin.domain.system.vo.Role;
import com.we.contract.admin.domain.system.vo.RoleResource;
import com.we.contract.admin.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * 角色管理Controller
 *
 * @author YK
 * @date 2017/7/6
 */
@Controller
@RequestMapping("role")
public class RoleController extends BasicController {


    @Autowired
    private RoleService roleService;


    /**
     *跳转到角色列表页面
     * @return
     */
    @RequestMapping("/role_list.do")
    public String toRoleListPage() {
        return "system/role_list";
    }
    /**
     * 加载角色列表List
     * @param role 角色实体
     * @return
     */
    @RequestMapping(value = "/ajax_role_list.do")
    @ResponseBody
    public Map<String, Object> ajaxRoleList(Role role){
        return roleService.selectRoleResultPageList(role);
    }

    /**
     * 跳转到角色新增页面
     * @return
     */
    @RequestMapping("/role_add.do")
    public String toRoleAddPage(Model model) {
        //新增页面标识
        model.addAttribute("pageFlag", "addPage");
        return "system/role_edit";
    }

    /**
     * 跳转到角色修改页面
     * @param roleId 角色Id
     * @return
     */
    @RequestMapping("/role_update.do")
    public String roleUpdatePage(Model model, Integer roleId){
        Role role = roleService.selectRoleById(roleId);
        //修改页面标识
        model.addAttribute("pageFlag", "updatePage");
        model.addAttribute("role", role);
        return "system/role_edit";
    }

    /**
     * 保存角色信息
     * @param role 角色实体
     * @return
     */
    @RequestMapping(value = "/ajax_save_role.do")
    @ResponseBody
    public ResultEntity ajaxSaveRole(Role role){
        try {
            return roleService.saveOrUpdateRole(role, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("保存角色信息方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.ROLE_SAVE_ERROR);
        }
    }

    /**
     * 角色授权页面
     * @param model
     * @return
     */
    @RequestMapping("/role_grant.do")
    public String roleGrantPage(Integer roleId,Model model){
        model.addAttribute("roleId", roleId);
        return "system/role_grant";
    }
    @RequestMapping(value = "/ajax_save_roleResource.do")
    @ResponseBody
    public ResultEntity saveRoleResource(Integer roleId, String resourceIds, Model model){
        RoleResource roleResource=new RoleResource();
        roleResource.setRoleId(roleId);
        roleResource.setResourceIds(resourceIds);
        roleResource.setCreator(getCurrentLoginName());
        ResultEntity resultEntity =roleService.grantResources2Role(roleResource);
        model.addAttribute("roleId", roleId);
        return resultEntity;
    }

}
