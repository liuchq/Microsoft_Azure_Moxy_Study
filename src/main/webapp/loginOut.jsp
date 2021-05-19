<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登出操作</title>
    <jsp:include page="common.jsp"></jsp:include>
</head>
<body>
    登出<% session.removeAttribute("userName");%>
</body>
</html>
