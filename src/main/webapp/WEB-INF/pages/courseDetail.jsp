<%--
  Created by IntelliJ IDEA.
  User: liuchq
  Date: 2021/5/17
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String pathHead = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <title>课程明细</title>
    <jsp:include page="../../common.jsp"></jsp:include>
</head>
<body>
    <h1>课程明细</h1>
    <button class="btn-success" onclick="test()">点击开始学习默认课程</button>
</body>
<script>
    var pathHead = '<%=pathHead%>';

    function test() {
        $.ajax({
            type:"POST",
            url:pathHead+"user/studyDemo.do",
            success:function (data) {
                alert(data);
            }
        });
    }
</script>
</html>
