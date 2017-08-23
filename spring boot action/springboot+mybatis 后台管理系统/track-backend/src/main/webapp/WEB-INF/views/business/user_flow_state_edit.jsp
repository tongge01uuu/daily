<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/comm/myinc.jsp" %>
</head>
<body class="childrenBody" style="font-size: 12px;">
<form class="layui-form layui-form-pane">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <tbody>
        <tr>
            <td title="${userFlow.id}">用户名称：</td>
            <td title="${userFlow.userId}">${userFlow.realName}</td>
        </tr>
        <tr>
            <td>手机号：</td>
            <td title="${userFlow.mobile}">${userFlow.mobile}</td>
        </tr>
        <tr>
            <td>订单号：</td>
            <td title="${userFlow.orderId}">${userFlow.orderId}</td>
        </tr>
        <tr>
            <td>节点：</td>
            <td title="${userFlow.flowId}">${userFlow.flowName}</td>
        </tr>
        <tr>
            <td>创建时间：</td>
            <td title="${userFlow.createTime}"><fmt:formatDate value="${userFlow.createTime}"   type="both"/></td>
        </tr>
        <tr>
            <td>最后修改时间：</td>
            <td title="${userFlow.updateTime}"><fmt:formatDate value="${userFlow.updateTime}"   type="both"/></td>
        </tr>
        <tr>

        </tr>
        </tbody>
    </table>
    <div class="layui-form-item" pane>
        <label class="layui-form-label">处理状态</label>
        <div class="layui-input-inline">
            <input type="radio" name="handleState" value="0" title="未处理" disabled>
            <input type="radio" name="handleState" value="1" title="处理中" <c:if test="${userFlow.handleState ==1||userFlow.handleState==null }">checked</c:if> >
            <input type="radio" name="handleState" value="2" title="已回访" <c:if test="${userFlow.handleState ==2}">checked</c:if> >
        </div>
    </div>
    <input type="hidden" name="id" value="${workSheet.id}" />
    <input type="hidden" name="stateId" value="${userFlow.id}" />
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">回访备忘</label>
        <div class="layui-input-block">
            <textarea name="description" placeholder="请输入内容" required="required" class="layui-textarea" maxlength="100"  value="${workSheet.description}" style="resize:none;min-height:40px;">${workSheet.description}</textarea>
        </div>
    </div>
    </div>
    <div class="layui-form-item" style="text-align: center;">
        <button class="layui-btn" lay-submit="" lay-filter="save">保存</button>
        <button type="layui-btn" id="cancel" class="layui-btn layui-btn-primary">取消</button>

    </div>
</form>
<script type="text/javascript">
    layui.use(['form','layer','jquery'],function(){
        var $ = layui.jquery,
                form = layui.form(),
                layer = parent.layer === undefined ? layui.layer : parent.layer;


        //保存
        form.on("submit(save)",function(data){
            console.log(data.field);
            var saveLoading = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            $.ajax({
                url : '${ctx}/userFlow/state/doEdit.do',
                type : 'post',
                async: false,
                data : data.field,
                success : function(data) {
                    if(data.code == 0000){
                        top.layer.close(saveLoading);
                        top.layer.msg("信息保存成功！");
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭                        //刷新父页面
                        parent.location.reload();
                    }else{
                        top.layer.close(saveLoading);
                        top.layer.msg(data.message);
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