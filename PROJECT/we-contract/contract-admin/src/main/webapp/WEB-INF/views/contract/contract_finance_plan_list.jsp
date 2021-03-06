<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="${ctx}/static/js/jquery-1.4.4.min.js"></script>
    <%@include file="/comm/myinc.jsp" %>
    <script type="text/javascript" src="${ctx}/static/js/jquery.media.js"></script>

</head>
<body>
<%--<a class="media" href="\static\file\dubbo-user-book.pdf"></a>--%>
<%--<a class="media" href="${ctx}/static/dubbo-user-book.pdf"></a>--%>
<div class="larry-grid larryTheme-A">
    <div class="larry-personal">
        <div class="layui-tab">
            <blockquote class="layui-elem-quote mylog-info-tit">
                <div class="layui-inline">
                    <form class="layui-form" id="searchForm">
                        子账户类型:
                        <div class="layui-input-inline" style="width:110px;">
                            <select name="subPointType" id="subPointType">
                                <option value="">全部</option>
                                <c:forEach var="cell" items="${subPointTypes}">
                                <option value="${cell.key}"<c:if test="${cell.key==subPointType}">selected</c:if>>${cell.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                        用户ID:
                        <div class="layui-input-inline" style="width:110px;">

                            <input type="text" name="userId" id="userId" placeholder="请输入用户ID" autocomplete="off" class="layui-input">
                        </div>
                        <a class="layui-btn searchList_btn" lay-submit lay-filter="searchFilter"><i class="layui-icon larry-icon larry-chaxun7"></i>查询</a>
                    </form>
                </div>
                <div class="layui-inline">
                    <a class="layui-btn layui-btn-danger batch_download"><i class="layui-icon larry-icon larry-shanchu"></i>批量下载</a>
                </div>
            </blockquote>
            <div class="larry-separate"></div>
            <!-- 合同列表 -->
            <div class="layui-tab-item layui-field-box layui-show">
                <div class="layui-form">
                    <table class="layui-table" lay-even="" lay-skin="row">
                        <thead >
                            <tr>
                                <th><input name="" lay-skin="primary" lay-filter="allChoose" type="checkbox"></th>
                                <th>ID</th>
                                <th>编号</th>
                                <th>计划名称</th>
                                <th>购买人</th>
                                <th>购买/预定</th>
                                <th>预定金额</th>
                                <th>子账户类型</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody id="contractTbody"></tbody>
                    </table>
                </div>
                <div class="larry-table-page clearfix" id="pageElement"></div>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    $('a.media').media({width:500, height:400});
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form', 'laypage', 'layer','common'], function () {
        var $ = layui.jquery,
                form = layui.form(),
                laypage = layui.laypage,
                layer = layui.layer,
                common = layui.common;

        /**加载字典列表信息*/
        pageList(1,{subPointType:$("#subPointType").val()});

        /**全选*/
        form.on('checkbox(allChoose)', function (data) {
            var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
            child.each(function (index, item) {
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
        });

        /**下载合同*/
        $("body").on("click","._download",function(){
            var contractId = $(this).attr("data-id");
            var contractFilePath = $(this).attr("data-file-path");
            <%--location.href="${ctx}/contract/financePlan/download.do?filePath="+contractFilePath;--%>
            var url="${ctx}/contract/financePlan/download.do";
            var param={filePath:contractFilePath};
            $.ajax({
                url : url,
                type : 'post',
                async: false,
                data : param,
                success : function(data) {
                    console.log(data);
                    if(data.code=="9999")
                    {
                        console.log("fail---"+data.message);
                        layer.msg(data.message);
                        return false;
                    }else{
                        location.href="${ctx}/contract/financePlan/download.do?filePath="+contractFilePath;
                    }
                },error:function(data){
                    console.log("error---"+data.message);
                    return false;
                }
            });

             <%--var index = layui.layer.open({--%>
                 <%--title : "编辑合同  ID: "+contractId+"  名称: "+contractFilePath,--%>
                 <%--type : 2,--%>
                 <%--content : "${ctx}/contract/financePlan/download.do?filePath="+contractFilePath,--%>
                 <%--area: ['950px', '565px'],--%>
                 <%--success : function(layero, index){--%>

                 <%--}--%>
             <%--});--%>
        });
        /**预览*/
        $("body").on("click","._show_content",function(){
            var contractId = $(this).attr("data-id");
            var filePath="sql-old/contract-old-withdata.sql";
             var index = layui.layer.open({
                 title : "预览合同  ID: "+contractId,
                 type : 2,
                 content : "${ctx}/contract/financePlan/to/show.do?id="+contractId,
                 area: ['950px', '565px'],
                 success : function(layero, index){

                 }
             });
        });

        /**失效*/
        $("body").on("click","._fail",function(){
            var contractId = $(this).attr("data-id");
            var contractStatus = $(this).attr("data-status");
            if(contractStatus == "false"){
                layer.msg("当前合同已失效");
                return false;
            }

            var url = "${ctx}/contract/fail.do";
            var param = {id:contractId,enabled:false};
            common.ajaxCmsConfirm('系统提示', '确定失效当前合同吗?',url,param)

        });
        /**查询*/
        $(".searchList_btn").click(function(){
            //监听提交
            form.on('submit(searchFilter)', function (data) {
                var param={subPointType:$("#subPointType").val(),userId:$("#userId").val()};
                pageList(1,param);
            });

        });
        /**批量下载*/
        $(".batch_download").click(function(){
            if($("input:checkbox[name='IdCK']:checked").length == 0){
                layer.msg("请选择要下载的合同");
            }else{
                var isCreateBy = false;
                var contractHasFile = false;
                var contractFilePaths = [];

                $("input:checkbox[name='IdCK']:checked").each(function(){
                    if(objNull($(this).attr('data-file-path')) != ""){
                        contractFilePaths.push($(this).attr('data-file-path'));
                        contractHasFile = true;
                    }else{
                        contractHasFile = false;
                        return false;
                    }

                });
                if(contractHasFile==false){
                    layer.msg("当前选择的合同无文件");
                    return false;
                }

                console.log(JSON.stringify(contractFilePaths));
                var contractFilePathsStr="";
                for (var i=0;i<contractFilePaths.length;i++)
                {
                    contractFilePathsStr+=contractFilePaths[i]+",";
                }
//                contractFilePathsStr=contractFilePathsStr.substring(0,contractFilePathsStr.length);
                var param = {filePaths:contractFilePathsStr};
                var url = "${ctx}/contract/financePlan/downloadZip.do";
                <%--var downloadUrl = "${ctx}/contract/financePlan/downloadZip.do?filePaths="+param.filePaths;--%>
                console.log( JSON.stringify(param));
                common.ajaxConfirmDownLoad('系统提示', '确定下载当前合同吗?',url,param);
            }
        });

        /**加载合同信息**/
        function pageList(curr,param){
            console.log("page:"+curr+"   param:"+param);
            var pageLoading = layer.load(2);
            param.pageNum=curr || 1;
            param.pageSize=7;

            $.ajax({
                url : '${ctx}/contract/financePlan/list.do',
                type : 'post',
                data :param,
                success : function(data) {
                    console.log("result：\n"+ JSON.stringify(data))
                    if(data != "" ){
                        var msg=data.message;
                        if (data.code!="0000")
                        {
                            layer.close(pageLoading);
                            if(msg==null || msg=="")
                            {
                                msg="处理异常"
                            }
                            layer.msg(msg);
                        }
                        $("#contractTbody").text('');//先清空原先内容
                        var pdata = data.data;
                        var ldata=pdata.list
                        console.log("列表：\n"+ JSON.stringify(ldata));
                        $(ldata).each(function(index,item){

                            //状态
//                            var templateStatusLable;
//                            if (item.enabled==true) {
//                                templateStatusLable = '<span class="label label-success " title="'+item.enabled+'">有效</span>';
//                            }else{
//                                templateStatusLable = '<span class="label label-danger" title="'+item.enabled+'">失效</span>';
//                            }

                            //操作按钮
                            var opt ='<div class="layui-btn-group">';
                                opt+=  '<a class="layui-btn layui-btn-mini _download"  data-id="'+item.id+'" data-file-path= "'+item.filePath+'" ><i class="layui-icon larry-icon larry-bianji2"></i>下载</a>';
                                opt+= '</div>';

                            //组装table
                            $("#contractTbody").append(
                                    '<tr>'+
                                    '<td><input name="IdCK" lay-skin="primary" type="checkbox" data-file-path="'+item.filePath+'"  value="'+item.id+'"></td>'+
                                    '<td title="'+item.id+'">'+item.id+'</td>'+
                                    '<td title="'+objNull(item.code)+'"><a  class="_show_content" style="cursor:hand" data-id="'+item.id+'" >'+formatString(item.code)+'</a></td>'+
                                    '<td title="'+objNull(item.financePlanId)+'">'+formatString(item.financePlanName)+'</td>'+
                                    '<td title="'+objNull(item.userId)+'">'+formatString(item.userName)+'</td>'+
                                    '<td title="'+objNull(item.type)+'">'+formatString(item.type)+'</td>'+
                                    '<td>'+item.reserveAmount+'</td>'+
                                    '<td title="'+objNull(item.subPointType)+'">'+formatString(item.subPointTypeName)+'</td>'+
                                    '<td>'+formatDate(objNull(item.createTime),"yyyy-MM-dd HH:mm")+'</td>'+
                                    '<td>'+formatDate(objNull(item.updateTime),"yyyy-MM-dd HH:mm")+'</td>'+
                                    '<td>'+opt+'</td>'+
                                    '</tr>'
                            );
                            //重新渲染form
                            form.render();

                        });
                        //分页
                        laypage({
                            cont: 'pageElement',
                            pages:  pdata.pages,
                            curr: curr || 1, //当前页
                            groups: 8, //连续显示分页数
                            skip: true,
                            jump: function(obj, first){ //触发分页后的回调
                                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                                    pageList(obj.curr,{type:$("#type").val(),userId:$("#userId").val()});
                                }
                            }
                        });
                        layer.close(pageLoading);
                    }
                },
                error:function (jqXHR, textStatus) {
                    if (jqXHR.status==400)
                    {
                        msg="检查参数类型是否正确！"
                        layer.close(pageLoading);
                        layer.msg(msg);
                    }
                }

            });
        };
    });

</script>

</body>
</html>