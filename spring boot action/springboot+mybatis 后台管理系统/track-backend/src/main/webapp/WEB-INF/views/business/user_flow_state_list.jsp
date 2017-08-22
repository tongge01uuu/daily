<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <link rel="stylesheet" href="${ctx}/static/css/global.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/personal.css" media="all">
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_9h680jcse4620529.css">
    <script src="${ctx}/static/layui/layui.js"></script>
<body>
<div class="larry-grid larryTheme-A">
    <div class="larry-personal">
        <div class="layui-tab">
            <blockquote class="layui-elem-quote mylog-info-tit">
                <div class="layui-inline">
                    <form class="layui-form" id="dictionarySearchForm">
                        <div class="layui-input-inline" style="width:110px;">
                            <select name="flowId" id="flowId">
                                <option value="0">全部</option>
                                <c:forEach var="cell" items="${flows}">
                                    <option value="${cell.id}">${cell.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <a class="layui-btn dictionarySearchList_btn" lay-submit lay-filter="listSearchFilter"><i class="layui-icon larry-icon larry-chaxun7"></i>查询</a>
                    </form>
                </div>
            </blockquote>
            <div class="larry-separate"></div>
            <!-- 列表 -->
            <div class="layui-tab-item layui-field-box layui-show">
                <div class="layui-form">
                    <table class="layui-table" lay-even="" lay-skin="row">
                        <thead >
                            <tr>
                                <th>用户ID</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>订单号</th>
                                <th>状态</th>
                                <th>民生数据</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th>处理状态</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody id="listTbody"></tbody>
                    </table>
                </div>
                <div class="larry-table-page clearfix" id="listPage"></div>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form', 'laypage', 'layer','common'], function () {
        var $ = layui.jquery,
                form = layui.form(),
                laypage = layui.laypage,
                layer = layui.layer,
                common = layui.common;


        /**加载列表信息*/
        listPageList(1,null);

        /**全选*/
        form.on('checkbox(allChoose)', function (data) {
            var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
            child.each(function (index, item) {
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
        });
        /**添加元素*/
        $(".dictionaryAdd_btn").click(function(){
            var index = layui.layer.open({
                title : "新增元素",
                type : 2,
                content : "${ctx}/dictionary/toSaveOrUpdate.do",
                area: ['550px', '265px'],
                success : function(layero, index){

                }
            });
        });
        /**修改元素*/
        $("body").on("click",".dictionary_edit",function(){
            var dictionaryId = $(this).attr("data-id");
             var index = layui.layer.open({
                 title : "编辑用户",
                 type : 2,
                 content : "${ctx}/dictionary/toSaveOrUpdate.do?dictionaryId="+dictionaryId,
                 area: ['550px', '265px'],
                 success : function(layero, index){

                 }
             });
        });

        /**元素失效*/
        $("body").on("click",".dictionary_fail",function(){
            var dictionaryId = $(this).attr("data-id");
            var dictionaryStatus = $(this).attr("data-status");
            if(dictionaryStatus == 0){
                layer.msg("当前元素已失效");
                return false;
            }

            var url = "${ctx}/dictionary/fail.do";
            var param = {dictionaryId:dictionaryId};
            common.ajaxCmsConfirm('系统提示', '确定失效当前元素吗?',url,param)

        });
        /**查询*/
        $(".dictionarySearchList_btn").click(function(){
            //监听提交
            form.on('submit(listSearchFilter)', function (data) {
                var param=$("#flowId").val();
                if (param==0)
                {
                    param=null;
                }
                listPageList(1,param);
            });

        });
        /**批量失效*/
        $(".dictionaryBatchFail_btn").click(function(){
            if($("input:checkbox[name='dictionaryIdCK']:checked").length == 0){
                layer.msg("请选择要失效的元素信息");
            }else{
                var isCreateBy = false;
                var dictionaryStatus = false;
                var dictionaryIds = [];

                $("input:checkbox[name='dictionaryIdCK']:checked").each(function(){
                    dictionaryIds.push($(this).val());
                    //已失效
                    if($(this).attr('alt') == 1){
                        dictionaryStatus = true;
                    }else{
                        dictionaryStatus = false;
                        return false;
                    }

                });
                if(dictionaryStatus==false){
                    layer.msg("当前选择的元素已失效");
                    return false;
                }

                var url = "${ctx}/dictionary/fail/batch.do";
                var param = {dictionaryIds:dictionaryIds};
                console.log(param);
                common.ajaxCmsConfirm('系统提示', '确定失效当前元素吗?',url,param);
            }
        });


        /**加载元素信息**/
        function listPageList(curr,flowId){
            console.log("page:"+curr+"   flowId:"+flowId);
            var pageLoading = layer.load(2);
            $.ajax({
                url : '${ctx}/userFlow/state/list.do',
                type : 'post',
                data :{
                    pageNum: curr || 1 ,   //当前页
                    pageSize: 7 ,          //每页显示7条数据
                    flowId: flowId
                },
                success : function(data) {
                    console.log("result：\n"+data);
                    if(data != "" ){
                        $("#listTbody").text('');//先清空原先内容
                        var pdata = data.data.pageInfo;
                        var ldata=pdata.list;
                        var dic=data.data.dic;
                        console.log("列表：\n"+ldata);
                        console.log("dic：\n"+dic);
                        $(ldata).each(function(index,item){

                            //节点名
                            var cmsData;
                            if(objNull(item.stateInput) != "" && item.name.length > 9){
                                cmsData = item.stateInput.substring(0,9) +"...";

                            }else{
                                cmsData = item.stateInput;
                            }
                            var flowName;
                            if (objNull(dic[1][item.flowId])=="")
                            {
                                flowName=item.flowId
                            }else {
                                flowName=dic[1][item.flowId]['name'];
                            }

                            //节点状态
                            var handleStateLable;
                            switch (item.handleState){
                                case 0:
                                    handleStateLable = '<span class="label label-default">未处理</span>';
                                    break;
                                case 1:
                                    handleStateLable = '<span class="label label-danger ">处理中</span>'
                                    break;
                                case 2:
                                    handleStateLable = '<span class="label label-success ">已回访</span>'
                                    break;
                            }

                            //操作按钮
                            var opt ='<div class="layui-btn-group">';
                                opt+=  '<a class="layui-btn layui-btn-mini dictionary_edit" data-id="'+item.id+' data-status= "'+item.access+'"><i class="layui-icon larry-icon larry-bianji2"></i>处理</a>';
                                opt+=  '<a class="layui-btn layui-btn-mini layui-btn-danger  dictionary_fail" data-id="'+item.id+'" data-status= "'+item.access+'"><i class="layui-icon larry-icon larry-x_suoping"></i>锁定</a>';
                                opt+= '</div>';
                            //组装table
                            $("#listTbody").append(
                                    '<tr>'+
                                    '<td title="'+objNull(item.userId)+'">'+objNull(item.userId)+'</td>'+
                                    '<td title="'+objNull(item.realName)+'">'+objNull(item.realName)+'</td>'+
                                    '<td>'+item.mobile+'</td>'+
                                    '<td>'+item.orderId+'</td>'+
                                    '<td title="'+objNull(item.flowId)+'">'+flowName+'</td>'+
                                    '<td title="'+objNull(item.stateInput)+'">'+cmsData+'</td>'+
                                    '<td>'+formatDate(objNull(item.createTime),"yyyy-MM-dd HH:mm")+'</td>'+
                                    '<td>'+formatDate(objNull(item.updateTime),"yyyy-MM-dd HH:mm")+'</td>'+
                                    '<td title="'+objNull(item.handleState)+'">'+handleStateLable+'</td>'+
                                    '<td>'+opt+'</td>'+
                                    '</tr>'
                            );
                            //重新渲染form
                            form.render();

                        });
                        //分页
                        laypage({
                            cont: 'listPage',
                            pages:  pdata.pages,
                            curr: curr || 1, //当前页
                            groups: 8, //连续显示分页数
                            skip: true,
                            jump: function(obj, first){ //触发分页后的回调
                                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                                    listPageList(obj.curr,$("#flowId").val());
                                }
                            }
                        });
                        layer.close(pageLoading);
                    }
                }

            });
        };
    });

</script>

</body>
</html>