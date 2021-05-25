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

    <div style="margin: 20px">
        <h1>课程明细</h1>
        <table id="user_course" class="table table-bordered">
            <thead>
                <tr>
                    <th>课程id</th>
                    <th>课程小节id</th>
                    <th>需要的时间</th>
                    <th>备注</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>

        <button class="btn-success" onclick="getUserAllCourse()">查询</button>
    </div>

    <div style="margin: 20px">

        <button class="btn-success" onclick="test()">点击开始学习默认课程</button>

        <button class="btn-success" onclick="test2()">测试2</button>

        <button class="btn-success" onclick="loginOut()">注销</button>
    </div>
    <div style="margin: 20px;border: 1px solid black;width: 20%;padding: 10px 0px 10px 10px">
        <input type="file" name="上传课程" id="upload_Course">
        <button class="btn-success" onclick="uploadCourse()" style="margin-top: 20px">上传课程</button>
    </div>

    <div style="margin: 20px">
        <button class="btn-success" onclick="test()">点击开始学习你上传的课程</button>
    </div>

</body>
<script>
    var pathHead = '<%=pathHead%>';
    var userAccount = '<%=userAccount%>';

    $(document).ready(function () {
        getUserAllCourse();
    });

    function test() {
        $.ajax({
            type:"POST",
            url:pathHead+"user/studyDemo.do",
            success:function (data) {
                //alert(data);
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
        alert("已经开始刷课,可以耐心等待,过会儿再来看");
    };

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
    };

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
    };

    function getUserAllCourse() {
        $('#user_course tbody').empty();

        $.ajax({
            type:"GET",
            url:pathHead+"user/getUserAllCourse.do",
            async:false,
            success:function (data) {
                // var cc = JSON.stringify(data);
                // alert(cc);
                $.each(data,function (index,item) {
                    var $tr = $('<tr>');
                    $.each(item,function(name,val){
                        if (name != "courseId"
                            && name != "courseOwner"
                            && name != "courseCreatetime"
                            && name != "courseVersion" ){
                            var $td = $('<td>').html(val);
                            $tr.append($td);
                        }
                    });
                    $('#user_course tbody').append($tr);
                })
            }
        });
    };

    function uploadCourse() {
        var fileName = $('#upload_Course').val();
        if(fileName.length <1){
            alert("请先上传文件");
            return false;
        }

        var formData = new FormData();
        formData.append("file",$("#upload_Course").get(0).files[0]);
        $.ajax({
            type:"POST",
            url:pathHead+"user/uploadCourse.do",
            dataType:"json",
            data:formData,
            processData: false,
            success:function (data) {
                alert(data);
                getUserAllCourse();
            }
        });
    }
</script>
</html>
