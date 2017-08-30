package com.we.contract.admin.controller.system;

import com.alibaba.fastjson.JSON;
import com.we.contract.admin.controller.BasicController;
import com.we.contract.admin.domain.system.bo.ResultEntity;
import com.we.contract.admin.domain.system.vo.Resource;
import com.we.contract.admin.service.system.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 资源Controller
 *
 * @author YK
 * @date 2017/7/6
 */
@Controller
@RequestMapping("res")
public class ResourceController extends BasicController {

    @Autowired
    private ResourceService resourceService;


    /**
     *跳转到资源列表页面
     * @return
     */
    @RequestMapping("/res_list.do")
    public String toResListPage() {
        return "system/res_list";
    }


    /**
     * 加载资源列表List
     * @param resource
     * @return
     */
    @RequestMapping("/ajax_res_list.do")
    @ResponseBody
    public String ajaxResourceList(Resource resource){
        return resourceService.selectResourceResultPageList(resource);
    }
    @RequestMapping("/ajax_res_list_all.do")
    @ResponseBody
    public String ajaxResourceListAll(Integer roleId){
        return JSON.toJSONString(resourceService.selectResourceList(roleId));
    }

    /**
     * 选择图标
     * @return
     */
    @RequestMapping("/res_img.do")
    public String toResImgPage() {
        return "system/res_img";
    }
    /**
     * 资源添加页面
     * @return
     */
    @RequestMapping("/res_add.do")
    public String toResAddPage(Model model) {
        model.addAttribute("parents",resourceService.selectParentResources().getData());
        //添加菜单 默认状态-有效
        Resource resource=new Resource();
        resource.setResStatus(0);
        model.addAttribute("resource",resource);
        return "system/res_edit";
    }
    /**
     * 资源编辑页面
     * @return
     */
    @RequestMapping("/res_edit.do")
    public String toResEditPage(Model model, Integer resId) {
        Resource resource=resourceService.selectByPrimaryKey(resId);
        model.addAttribute("resource",resource);
        model.addAttribute("parents",resourceService.selectParentResources().getData());
        return "system/res_edit";
    }

    /**
     * 编辑或者新增resource
     * @param resource
     * @return
     */
    @RequestMapping("/ajax_saveOrUpdate_res.do")
    @ResponseBody
    public ResultEntity saveOrUpdate(Resource resource){
        ResultEntity resultEntity = ResultEntity.build();
        resultEntity =resourceService.saveOrUpdate(resource);
        return resultEntity;
    }

    @RequestMapping("/ajax_res_menu_top.do")
    @ResponseBody
    public String ajaxResMenuTop(){
        return resourceService.selectResMenuTop();
    }

    @RequestMapping("/ajax_res_menu_left.do")
    @ResponseBody
    public String ajaxResMenuLeft(Integer resParentid){
        return resourceService.selectResLevelListByParentid(resParentid);
    }




}
