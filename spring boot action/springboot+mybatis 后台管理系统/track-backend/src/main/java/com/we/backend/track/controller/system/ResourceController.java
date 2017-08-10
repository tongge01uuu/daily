package com.we.backend.track.controller.system;

import com.alibaba.fastjson.JSON;
import com.we.backend.track.controller.BasicController;
import com.we.backend.track.domain.vo.Resource;
import com.we.backend.track.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        return JSON.toJSONString(resourceService.selectResourceList());
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
    @RequestMapping("/res_edit.do")
    public String toResEditPage() {
        return "system/res_edit";
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
