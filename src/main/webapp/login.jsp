<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <jsp:include page="common.jsp"></jsp:include>
</head>
<body>
<%--    登录<% session.setAttribute("userName","zs");%>--%>
    <div style="text-align: center">
        <form action="user/userLogin.do" method="post">
            <div style="padding: 100px 40% 10px;">
                <div class="input-group">
                    <input type="text" name="userAccount" placeholder="账号">
                </div>
                <br>
                <div class="input-group">
                    <input type="text" name="userPsw" placeholder="密码">
                </div>
                <br>
                <div class="input-group">
                    <input type="submit" value="提交" class="btn-success">
                </div>
            </div>
        </form>
    </div>
</body>
</html>
