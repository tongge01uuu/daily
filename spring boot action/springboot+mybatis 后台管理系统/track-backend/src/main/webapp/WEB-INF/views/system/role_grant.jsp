<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="shortcut icon" href="${ctx}/static/img/favicon.ico">

    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">

    <link rel="stylesheet" href="${ctx}/static/css/metroStyle/metroStyle.css">
    <script type="text/javascript" src="${ctx}/static/js/jquery-1.4.4.min.js"></script>

    <script src="${ctx}/static/layui/layui.js"></script>

    <script type="text/javascript" src="${ctx}/static/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/jquery.ztree.excheck.js"></script>
</head>
<body class="childrenBody" style="font-size: 12px;">
<div class="zTreeBackground left">
    <ul id="resourceTree" class="ztree"></ul>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" id="save" lay-filter="saveRoleResources">保存</button>
            <button type="layui-btn" id="cancel" class="layui-btn layui-btn-primary">取消</button>
        </div>
    </div>
</div>
<script type="text/javascript">
    layui.use(['tree', 'layer','form'], function() {
        var layer = layui.layer
                , $ = layui.jquery,
         form = layui.form();




    });

    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    var zNodes=new Array();
    function fetchData(){
        $.ajax({
            url : '${ctx}/res/ajax_res_list_all.do',
            type : 'post',
            async:false,
            data :{
                roleId:${roleId}
            },
            success : function(data) {
                var pdata = $.parseJSON(data);

                $(pdata).each(function(index,item){
                    var cell={
                        id:item.resId,
                        pId:item.resParentid,
                        name:item.resName,
                        checked:item.checked,
                        open:true
                    };
                    console.log(cell);
                    zNodes[index]=cell;
                });

            }
        });
        console.log(zNodes);
        return zNodes;
    }

    function onCheck(treeId) {
        var treeObj = $.fn.zTree.getZTreeObj(treeId);
        var nodes = treeObj.getCheckedNodes(true);
        var result= "";
        for (var i = 0; i < nodes.length; i++) {
            result += nodes[i].id + ",";
        }
        return result //获取选中节点的值
    }

    $(document).ready(function(){
        zNodes=fetchData();
        $.fn.zTree.init($("#resourceTree"), setting, zNodes);

        $("#save").click(function(data){
            var roleData=onCheck("resourceTree");
            var pageFlag = $("#pageFlag").val();
            var userSaveLoading = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            //登陆验证
            $.ajax({
                url : '${ctx}/role/ajax_save_roleResource.do',
                type : 'post',
                async: false,
                data : data.field,
                success : function(data) {
                    if(data.returnCode == 0000){
                        top.layer.close(userSaveLoading);
                        if(pageFlag == 'addPage'){
                            top.layer.msg("用户信息保存成功,默认密码123456,请及时修改");
                        }else {
                            top.layer.msg("用户信息保存成功");
                        }
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭                        //刷新父页面
                        parent.location.reload();
                    }else{
                        top.layer.close(userSaveLoading);
                        top.layer.msg(data.returnMessage);
                    }
                },error:function(data){
                    top.layer.close(index);

                }
            });
            return false;
        });
        //取消
        $("#cancel").click(function(){
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
            // layer.closeAll("iframe");
        });
    });
</script>
</body>
</html>