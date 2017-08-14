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


    <script src="${ctx}/static/layui/layui.js"></script>

</head>
<body class="childrenBody" style="font-size: 12px;">
<form class="layui-form layui-form-pane">

    <table class="layui-table">
        <%--<colgroup>--%>
            <%--<col width="30">--%>
            <%--<col width="30">--%>
            <%--<col>--%>
        <%--</colgroup>--%>
        <%--<tbody>--%>
        <%--<tr>--%>
            <%--<td>登陆账号</td>--%>
            <%--<td>${user.userLoginName}</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>用户姓名</td>--%>
            <%--<td>${user.userName}</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>角色</td>--%>
            <%--<td>${user.roleNames}</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>状态</td>--%>
            <%--<td>--%>
                <%--<c:if test="${user.userStatus ==0 }">有效</c:if>--%>
                <%--<c:if test="${user.userStatus ==1 }">失效</c:if>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>旧密码：</td>--%>
            <%--<td>--%>
                <%--<div class="layui-input-inline">--%>
                    <%--<input type="password" name="passwordOld" id="passwordOld" required lay-verify="required" placeholder="请输入原密码" autocomplete="off" class="layui-input">--%>
                <%--</div>--%>
                <%--<div class="layui-form-mid layui-word-aux">*必须</div>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>新密码：</td>--%>
            <%--<td>--%>
                <%--<div class="layui-input-inline">--%>
                    <%--<input type="password" name="passwordNew" id="passwordNew" required lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">--%>
                <%--</div>--%>
                <%--<div class="layui-form-mid layui-word-aux">*必须</div>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>再次新密码：</td>--%>
            <%--<td>--%>
                <%--<div class="layui-input-inline">--%>
                    <%--<input type="password" name="passwordNewRepeat" id="passwordNewRepeat" required lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">--%>
                <%--</div>--%>
                <%--<div class="layui-form-mid layui-word-aux">*两次新密码必须一致</div>--%>
            <%--</td>--%>
        <%--</tr>--%>
        </tbody>
    </table>


    <input id="userId" name="userId" type="hidden" value="${user.userId}">

    <input id="pageFlag"  type="hidden" value="${pageFlag}">

    <div class="layui-form-item">
        <label class="layui-form-label">登陆账号</label>
        <div class="layui-form-label">
            ${user.userLoginName}
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户姓名</label>
        <div class="layui-form-label">
            ${user.userName}
        </div>
    </div>
    <div class="layui-form-item" >
        <label class="layui-form-label">角色</label>
        <div class="layui-form-label" style="overflow:auto; width:300px">
            ${user.roleNames}
        </div>
    </div>
    <div class="layui-form-item" >
        <label class="layui-form-label">状态</label>
        <div class="layui-form-label"  style="overflow:auto;">
            <c:if test="${user.userStatus ==0 }">有效</c:if>
            <c:if test="${user.userStatus ==1 }">失效</c:if>
        </div>
    </div>
    <div class="layui-form-item" >
        <label class="layui-form-label">旧密码：</label>
        <div class="layui-input-inline">
            <input type="password" name="passwordOld" id="passwordOld" required lay-verify="required" placeholder="请输入原密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">*必须</div>
    </div>
    <div class="layui-form-item" >
        <label class="layui-form-label">新密码：</label>
        <div class="layui-input-inline">
            <input type="password" name="passwordNew" id="passwordNew" required lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">*必须</div>
    </div>
    <div class="layui-form-item" >
        <label class="layui-form-label">再次新密码：</label>
        <div class="layui-input-inline">
            <input type="password" name="passwordNewRepeat" id="passwordNewRepeat" required lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">*两次新密码必须一致</div>
    </div>

    <input type="hidden" name="userId" value="${user.userId}">
    <div class="layui-form-item" style="text-align: center;">
            <button class="layui-btn" lay-submit="" lay-filter="saveUserPW">保存</button>
            <button type="layui-btn" id="cancel" class="layui-btn layui-btn-primary">取消</button>
    </div>
</form>
<script type="text/javascript">
    layui.config({
        base : "/static/js/"
    }).use(['form','common','layer','jquery'],function(){
        var $ = layui.jquery,
                form = layui.form(),
                common = layui.common,
                layer = parent.layer === undefined ? layui.layer : parent.layer;

        form.verify({
            passwordOld: function(value, item){
                //验证登陆账号
                if(!value){
                    return '旧密码不能为空';
                }
            },
            passwordNew: function(value, item){
                //验证用户名
                if(!value){
                    return '新密码不能为空';
                }
            },
            passwordNewRepeat: function(value, item){
                var pass = $('#passwordNew').val();
                if(value != pass){
                    return '两次密码不一致';
                }
            }
        });



        //保存
        form.on("submit(saveUserPW)",function(data){
            var pageFlag = $("#pageFlag").val();
            var saveUserPWLoading = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            //登陆验证
            $.ajax({
                url : '${ctx}/user/ajax_update_user_pw.do',
                type : 'post',
                async: false,
                data : data.field,
                success : function(data) {
                    console.log(data.field);
                    if(data.returnCode == 0000){
                        top.layer.close(saveUserPWLoading);
                        top.layer.msg(data.returnMessage);
//                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
//                        parent.layer.close(index); //再执行关闭                        //刷新父页面
//                        parent.location.reload();
                        var url = '/logout.do';
                        common.logOutRightNow('重新登陆提示！','密码修改成功，请重新登陆系统', url)
                    }else{
                        top.layer.close(saveUserPWLoading);
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