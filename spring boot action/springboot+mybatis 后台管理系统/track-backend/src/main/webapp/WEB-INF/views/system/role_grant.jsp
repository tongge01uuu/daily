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
<div class="zTreeDemoBackground left">
    <ul id="treeDemo" class="ztree"></ul>
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
                roleId:roleId
            },
            success : function(data) {
                var pdata = $.parseJSON(data);

                $(pdata).each(function(index,item){
                    var cell={
                        id:item.resId,
                        pId:item.resParentid,
                        name:item.resName,
                        checked:true,
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

    $(document).ready(function(){
        zNodes=fetchData();
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });
</script>
</body>
</html>