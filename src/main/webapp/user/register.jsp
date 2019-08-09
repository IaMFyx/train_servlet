<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/2
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <style>
        body{
            background-image: url("../image/bg1.jpg");
            background-size: cover;
        }

    </style>
</head>
<body>
<h2>输入用户信息进行注册</h2>
    <form name="form1" method="post" action="../RegisterServlet" onsubmit="return checkSubmit()">
        用户名：&ensp;&ensp;<input name="username" type="text" maxlength="16" onchange="checkName()" id="username" /><font id="font1" color="red" ></font><br/><br/>
        姓名：&ensp;&ensp;&ensp;&ensp;<input name="realName" type="text"/><br/><br/>
        性别：&ensp;&ensp;&ensp;&ensp;男<input type="radio" name="sex" value="男" checked="checked"/>
        女<input type="radio" name="sex" value="女"/><br/><br/>
        年龄：&ensp;&ensp;&ensp;&ensp;<input type="text" name="age" maxlength="3" onchange="checkAge()" id="age"/><font id="ageNote" color="red" ></font><br/><br/>
        密码：&ensp;&ensp;&ensp;&ensp;<input type="password" name="password" id="password" maxlength="16"/><br/><br/>
        确认密码：<input type="password" name="passwordConfirm" id="passwordConfirm" onfocusout="checkPwd()"/>
        <font id="font2" color="red"></font><br/><br/>
        电话：&ensp;&ensp;&ensp;&ensp;<input type="text" name="tel" maxlength="11" oninput="value=value.replace(/[^\d]/g,'')"/><br/><br/>
        邮箱：&ensp;&ensp;&ensp;&ensp;<input type="email" name="email"><br/><br/>
        爱好：&ensp;&ensp;&ensp;&ensp;
        撩妹<input type="checkbox" name="hobbies" value="撩妹" checked="checked" />
        写代码<input type="checkbox" name="hobbies" value="写代码" />
        篮球<input type="checkbox" name="hobbies" value="篮球" />
        足球<input type="checkbox" name="hobbies" value="足球" /><br/><br/>
        个人签名：<textarea name="sign" >
                    今天有点小帅……
             </textarea><br/><br/>
        权限：&ensp;&ensp;&ensp;&ensp;管理员<input type="radio" name="privilege" value="admin" />
        普通用户<input type="radio" name="privilege" value="user" checked="checked"/><br/><br/>
        &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
        <input type="submit" name="submit" value="注册" id="sub" />
        &ensp;<input value="取消" type="reset"/>
    </form>
<a href="login.jsp">已有账号，点击登录</a>
</body>
</html>
<script>
    var v1,v2,v3,xmlHttp;

    function checkName() {
        var reg=/^[0-9a-zA-Z]+$/;
        var username=document.getElementById("username").value;
        if(!reg.test(username)){
            //alert("用户名格式应为字母和数字的组合！")
            document.getElementById("font1").innerHTML="用户名格式应为字母和数字的组合！";
            v1=false;
        }
        else {
            if (username.length<6){
                //alert("用户名长度应为6-16！");
                document.getElementById("font1").innerHTML="用户名长度应为4-16！";
                v1=false;
            }
            else {
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
                var url="../RegisterServlet?username="+username;

                xmlHttp.onreadystatechange=function (){
                    if (xmlHttp.readyState==4&&xmlHttp.status==200){
                        var txtHint=xmlHttp.responseText;
                        if(txtHint==0){
                            document.getElementById("font1").innerHTML="用户名可用";
                            v1=true;
                        }
                        else if (txtHint==1) {
                            document.getElementById("font1").innerHTML="用户名已存在请重新输入";
                            v1=false;
                        }
                    }
                    else if (xmlHttp.readyState!=4){
                        document.getElementById("font1").innerHTML="xmlHttp.readyState!=4";
                    }
                    else if(xmlHttp.status!=200){
                        document.getElementById("font1").innerHTML="status:"+xmlHttp.status;
                    }
                };
                xmlHttp.open("GET",url,true);
                xmlHttp.send(null);
            }
        }
    }

    function checkAge() {
        var age=document.getElementById("age").value;
        var reg=/^\d+$/
        if (!reg.test(age)){
            v3=false;
            document.getElementById("ageNote").innerHTML="请输入1-150之间的数字！"
        }
        else {
            if (Number(age)>=1&&Number(age)<=150){
                v3=true;
                document.getElementById("ageNote").innerHTML="ok!"
            }
            else {
                v3=false;
                document.getElementById("ageNote").innerHTML="请输入1-150之间的数字！"
            }
        }
    }
    function checkPwd(){
        var password = document.getElementById("password");
        var passwordConfirm = document.getElementById("passwordConfirm");
        var reg=/^[0-9a-zA-Z]+$/;

        if (!reg.test(password.value)||!reg.test(passwordConfirm.value)) {
            document.getElementById("font2").innerHTML="用户名格式应为字母和数字的组合！";
            v2=false;
        }
        else {
            if(password.value != passwordConfirm.value){
                document.getElementById("font2").innerHTML="两次输入的密码不一致！";
                v2 =false;
            }
            else {
                if (password.value.length <4) {

                    document.getElementById("font2").innerHTML = "密码长度应为4-16！";
                    v2=false;
                }
                else {
                    document.getElementById("font2").innerHTML = "密码可用";
                    v2=true;
                }
            }
        }
    }
    function checkSubmit() {

        if(v1&&v2&&v3){
            return true;
        }
        else {
            alert("请输入正确的信息!")
            return false;
        }
    }
</script>
