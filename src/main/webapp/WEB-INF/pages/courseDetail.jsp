<%--
  Created by IntelliJ IDEA.
  User: liuchq
  Date: 2021/5/17
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("userName",request.getSession().getAttribute("userAccount"));
    Object userAccount = request.getSession().getAttribute("userAccount");
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

    <button class="btn-success" onclick="test2()">测试2</button>

    <button class="btn-success" onclick="loginOut()">注销</button>
</body>
<script>
    var pathHead = '<%=pathHead%>';
    var userAccount = '<%=userAccount%>';

    function test() {
        $.ajax({
            type:"POST",
            url:pathHead+"user/studyDemo.do",
            success:function (data) {
                alert(data);
            },
            complete:function (xhr,status) {
                //alert(userAccount);
                //获取响应头
                var redirect = xhr.getResponseHeader("REDIRECT");
                //如果包含"REDIRECT",说明是拦截器返回的
                if ("REDIRECT" == redirect){
                    var win = window;
                    while (win != win.top){
                        win = win.top;
                    }
                    //重新跳转到指定页面
                    win.location.href = xhr.getResponseHeader("CONTEXTPATH");
                }
            }
        });
    }

    function test2() {
        $.ajax({
            type:"POST",
            url:pathHead+"user/test2.do",
            success:function (data) {
                alert(data);
            },
            complete:function (xhr,status) {
                alert(xhr.status);
                alert(status);
            }
        });
    }

    function loginOut() {
        $.ajax({
            type:"POST",
            url:pathHead+"user/loginOut.do",
            async:false,
            success:function (data) {
                if (data == "success"){
                    window.location.href='../login.jsp';
                }
            }
        });
    }
</script>
</html>
