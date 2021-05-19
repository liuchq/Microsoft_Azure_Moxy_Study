<%--
  Created by IntelliJ IDEA.
  User: liuchq
  Date: 2021/5/19
  Time: 21:11
  To change this template use File | Settings | File Templates.

  引入公共的组件
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--引入jquery--%>
    <script type="text/javascript" src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>static/jquery/jquery-3.5.1.min.js"></script>
    <%--引入bootstrap--%>
    <link href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="icon" href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>static/image/liuchq.ico">
</head>
<body>

</body>
</html>
