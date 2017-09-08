<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
    <%@include file="/comm/myinc.jsp" %>
    <script type="text/javascript" src="${ctx}/static/edit/ckeditor.js"></script>
    <%--<script src="https://cdn.ckeditor.com/4.7.2/standard/ckeditor.js"></script>--%>
<head>

</head>
<body class="childrenBody" style="font-size: 12px;">
<form class="layui-form layui-form-pane">
    <input type="hidden" id="id" name="id" value="${contractTemplate.id}"/>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">模板名称</label>
            <div class="layui-input-inline">
                <input type="text" name="name" class="layui-input newsName" lay-verify="required" placeholder="请输入模板名称" value="${contractTemplate.name}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">模板文件名</label>
            <div class="layui-input-inline">
                <input type="text" name="filename" class="layui-input newsName" value="${contractTemplate.filename}">
            </div>
        </div>

    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">前后台是否同步</label>
            <div class="layui-input-inline">
                <select name="synced" >
                    <option value="0" <c:if test="${contractTemplate.synced}">selected</c:if>>否</option>
                    <option value="1" <c:if test="${contractTemplate.synced}">selected</c:if>>是</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">是否启用</label>
            <div class="layui-input-inline">
                <select name="enabled " >
                    <option value="0" <c:if test="${contractTemplate.enabled}">selected</c:if>>否</option>
                    <option value="1" <c:if test="${contractTemplate.enabled}">selected</c:if>>是</option>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">模板类型</label>
            <div class="layui-input-inline">
                <select name="type" id="type" lay-verify="required">
                    <option value=""></option>
                    <c:forEach var="cell" items="${types}">
                        <option value="${cell.key}"<c:if test="${cell.key==contractTemplate.type}">selected</c:if>>${cell.value}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <%--<div class="layui-form-item" pane>--%>
        <%--<label class="layui-form-label">资源状态</label>--%>
        <%--<div class="layui-input-inline">--%>
            <%--<input type="radio" name="resStatus" value="0" title="有效" <c:if test="${contractTemplate.resStatus ==0 }">checked</c:if> >--%>
            <%--<input type="radio" name="resStatus" value="1" title="失效" <c:if test="${contractTemplate.resStatus ==1 }">checked</c:if> >--%>
        <%--</div>--%>
    <%--</div>--%>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">内容</label>
        <div class="layui-input-block">
            <textarea name="content" id="content" placeholder="请输入内容" class="layui-textarea" maxlength="50" style="height:290px; width:830px;">${contractTemplate.content}</textarea>
            <%--<textarea name="content" id="content" placeholder="请输入内容" class="layui-textarea" maxlength="50"  value="<c:out value="${contractTemplate.content}" escapeXml="false"/>" style="height:290px; width:830px;"></textarea>--%>
        </div>
    </div>
    <div class="layui-form-item" style="text-align: center;">
        <button class="layui-btn" lay-submit="" lay-filter="_save">保存</button>
        <button type="layui-btn" id="cancel" class="layui-btn layui-btn-primary">取消</button>

    </div>
</form>
<script type="text/javascript">
    layui.use(['form','layer','jquery','layedit'],function(){
        var $ = layui.jquery,
                form = layui.form(),
                layer = parent.layer === undefined ? layui.layer : parent.layer,
                layedit = layui.layedit;


        CKEDITOR.replace( 'content' ,{
            startupMode : 'source',
            extraPlugins: 'colordialog,tableresize'
        });
        //保存
        form.on("submit(_save)",function(data){
            console.log(data.field);
            data.field.content=CKEDITOR.instances.content.getData();
            console.log(data.field);
            var saveLoading = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            $.ajax({
                url : '${ctx}/contract/saveOrUpdate.do',
                type : 'post',
                async: false,
                data : data.field,
                success : function(data) {
                    if(data.code == 0000){
                        top.layer.close(saveLoading);
                        top.layer.msg("模板信息保存成功！");
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