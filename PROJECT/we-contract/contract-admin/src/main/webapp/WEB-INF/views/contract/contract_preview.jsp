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
<a class="media" href="${ctx}/${result.data}"></a>
<input type="hidden" name="message" id="message" value="${result.message}" />
<input type="hidden" name="code" id="code" value="${result.code}" />
<script type="text/javascript">
    $(function(){
        if ($("#code").val()!="0000")
        {
            layui.use(['layer'], function(){
                var layer = layui.layer;
                layer.msg($("#message").val());
            });
        }else {
            $('a.media').media({width:950, height:565});
        }
    });

</script>

</body>
</html>