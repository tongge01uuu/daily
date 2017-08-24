<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/comm/myinc.jsp" %>
</head>
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
                    <table class="layui-table" lay-even lay-skin="row line">
                        <colgroup>
                            <col width="50">
                        </colgroup>
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
                                <th>回访人</th>
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

        function checkAndLock(userFlowId,ifalert,ifReload) {
            var result=true;
            $.ajax({
                url : '${ctx}/userFlow/state/checkAndLock.do',
                type : 'post',
                async:false,
                data :{
                    userFlowStateId: userFlowId
                },
                success : function(data) {
                    if (data.code!='0000')
                    {
                        top.layer.alert(data.message);
//                        top.layer.msg(data.message);
                        location.reload();
                        result=false;
                    }else {
//                        top.layer.alert("success");
                        if (ifalert)
                        {
                            top.layer.msg("任务锁定成功");
                        }
                        if (ifReload)
                        {
                            location.reload();
                        }
                    }
                    return result;
                }
            });

            return result;

        }
        /**修改*/
        $("body").on("click","._edit",function(){
            var userFlowId = $(this).attr("data-id");

            if (checkAndLock(userFlowId,false,false))
            {
                var index = layui.layer.open({
                    title : "编辑",
                    type : 2,
                    content : "${ctx}/userFlow/state/toEdit.do?userFlowStateId="+userFlowId,
                    area: ['550px', '366px'],
                    success : function(layero, index){

                    }
                });
            }
        });

        /** 查看CMBC完整数据*/
        $("body").on("click","._showCmbc",function(){
            var data = $(this).attr("data-content");

            var index = layui.layer.open({
                title : "民生回调数据",
                skin:'layui-layer-molv',
                content : '<textarea style="resize: both;width: 500px;height: inherit" disabled>'+JSON.stringify(JSON.parse(data), null, 5)+'</textarea>',
                area: ['550px', '366px'],
            });
        });

        /**锁定*/
        $("body").on("click","._fail",function(){
            var userFlowId = $(this).attr("data-id");

            checkAndLock(userFlowId,true,true);
            <%--var url = "${ctx}/dictionary/fail.do";--%>
            <%--var param = {dictionaryId:dictionaryId};--%>
            <%--common.ajaxCmsConfirm('系统提示', '确定领取当前任务吗?',url,param)--%>

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
                            if(objNull(item.stateInput) != "" && item.stateInput.length > 9){
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
                            var lockBtn='<a class="layui-btn layui-btn-mini layui-btn-danger  _fail"  title="领取任务，锁定该条记录" data-id="'+item.id+'" data-status= "'+item.access+'"><i class="layui-icon larry-icon larry-x_suoping"></i>锁定</a>';
                            if(item.handleState!=0)
                            {
                                lockBtn='<a class="layui-btn layui-btn-mini layui-btn-disabled "  title="任务已被领取" data-id="'+item.id+'" data-status= "'+item.access+'"><i class="layui-icon larry-icon larry-x_suoping"></i>锁定</a>';
                            }

                            //操作按钮
                            var opt ='<div class="layui-btn-group">';
                                opt+=  '<a class="layui-btn layui-btn-mini _edit" title="点击进入编辑会直接锁定记录" data-id="'+item.id+'" ><i class="layui-icon larry-icon larry-bianji2"></i>处理</a>';
                                opt+= lockBtn;
                                opt+= '</div>';
                            //组装table
                            $("#listTbody").append(
                                    '<tr>'+
                                    '<td title="'+objNull(item.id)+'">'+objNull(item.userId)+'</td>'+
                                    '<td title="'+objNull(item.realName)+'">'+objNull(item.realName)+'</td>'+
                                    '<td>'+item.mobile+'</td>'+
                                    '<td>'+item.orderId+'</td>'+
                                    '<td title="'+objNull(item.flowId)+'">'+flowName+'</td>'+
                                    '<td title="点击查看完整数据">'+'<a class="_showCmbc" style="cursor:pointer" data-content='+item.stateInput+'>'+cmsData+'</a></td>'+
                                    '<td>'+formatDate(objNull(item.createTime),"yyyy-MM-dd HH:mm")+'</td>'+
                                    '<td>'+formatDate(objNull(item.updateTime),"yyyy-MM-dd HH:mm")+'</td>'+
                                    '<td title="'+objNull(item.workerName)+'">'+objNull(item.workerName)+'</td>'+
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