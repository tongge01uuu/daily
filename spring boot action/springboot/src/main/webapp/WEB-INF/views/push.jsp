<%--
  Created by IntelliJ IDEA.
  User: yukai
  Date: 2017/6/28
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Server Send Event</title>
    <script src="/visit/static/js/jquery.js" type="application/javascript"></script>
    <script>
     $(function(){
         if (!!window.EventSource)
         {
             var source=new EventSource('/push/sse');
             var content="";
             source.addEventListener('message',function (e) {
                 content+=e.data+"<br/>";
                 $("#pushDataContainor").html(content);
             });

             source.addEventListener('open',function (e) {
                 console.log("------ 连接打开");
             },false);
             source.addEventListener('error',function (e) {
                 if (e.readyState==EventSource.CLOSED)
                 {
                     console.log("------连接关闭");
                 }else{
                     console.log("------"+e.readyState);
                 }
             },false);

         }else {
             console.log("-----浏览器不支持SSE");
         }
         deferred();
     });
        function deferred() {
            $.get("/push/servlet/aysnc",function (data) {
                console.log("异步取值"+data);
                deferred();
            });
        }
    </script>
</head>
<body>
    <h1 id="pushDataContainor"></h1>
</body>
</html>
