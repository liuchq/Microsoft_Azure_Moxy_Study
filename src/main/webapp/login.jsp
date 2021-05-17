<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<%--    登录<% session.setAttribute("userName","zs");%>--%>
    <form action="moxy/userLogin.do" method="post">
        <input type="text" name="userAccount">
        <input type="text" name="userPsw">
        <input type="submit" value="提交">
    </form>
</body>
</html>
