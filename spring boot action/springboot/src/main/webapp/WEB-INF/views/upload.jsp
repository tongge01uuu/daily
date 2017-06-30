<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>error</title>
</head>
<body>
<h1>
选择需要上传的文件：
</h1>
<br>
<form action="index/uploadController" enctype="multipart/form-data" method="post">
    <input type="file" name="uploadFile">
    <br>
    <input type="submit" value="上传">
</form>
</body>
</html>