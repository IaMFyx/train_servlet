<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/2
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        body{
            background-image: url("../image/bg2.jpg");
            background-size: cover;
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>
<h1>用户登录</h1>
    <form action="userInfo.jsp" method="post" onsubmit="return checkSub()">
        用户名：<input type="text" name="username" id="username" ><br/><br>
        密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password"><br><br>
        <font color="red" id="note"></font>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="登录">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="重置">
    </form>
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp">没有用户名？点击注册</a><br><br>
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<a href="../file/upload.jsp">文件上传</a><br><br>
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<a href="../file/download.jsp">文件下载</a>
<script>
    var xmlHttp;
    var v1=false;
    function checkSub() {
        try {
            xmlHttp=new XMLHttpRequest();
        }catch (e) {
            try {
                xmlHttp=new ActiveXObject("Msxml2.XMLHttp");
            }catch (e) {
                try {
                    xmlHttp=new ActiveXObject("Microsoft.XMLHttp");
                }catch (e) {
                    alert("浏览器不支持Ajax！！")
                    return false;
                }
            }
        }
        var username=document.getElementById("username").value;
        var password=document.getElementById("password").value;
        var url="LoginServlet?username="+username+"&password="+password;

        xmlHttp.onreadystatechange=function(){
            if (xmlHttp.readyState==4){
                var txtHint=xmlHttp.responseText;
                if (txtHint==0){
                    v1=true;
                }
                else if(txtHint==1){
                    alert("密码错误请重新输入！！！");
                    v1=false;
                }
                else if (txtHint==2) {
                    alert("用户名不存在请先注册！！！");
                    v1=false;
                }
            }
        }
        xmlHttp.open("GET",url,false);

        xmlHttp.send(null);

        return v1;
    }
</script>
</body>
</html>
