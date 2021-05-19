<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello,访问者</title>
    <jsp:include page="common.jsp"></jsp:include>
</head>
<body>
    <div style="text-align: center">
        <img src="static/image/cat.jpg" title="显示图片" height="450">
        <h5>个人学习使用^v^</h5>
        <button class="btn btn-success" onclick="window.location.href='login.jsp'">点击跳转登录页面</button>
    </div>
</body>
</html>
