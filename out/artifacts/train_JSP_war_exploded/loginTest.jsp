<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/7/29
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        body{
            background-image: url("preview.jpg");
            background-size: cover;
        }
        div{
            text-align: left;
            line-height: 20px;
        }
    </style>
</head>
<body>
<h2>输入用户信息进行注册</h2>
<div>
<form name="form1" method="post" action="loginOK.jsp" onsubmit="return checkSubmit()">
    用户名：&ensp;&ensp;<input name="username" type="text" maxlength="16" onchange="checkName()" id="username" /><font id="font1" color="red" ></font><br/><br/>
    姓名：&ensp;&ensp;&ensp;&ensp;<input name="realName" type="text"/><br/><br/>
    性别：&ensp;&ensp;&ensp;&ensp;男<input type="radio" name="sex" value="male" checked="checked"/>
         女<input type="radio" name="sex" value="female"/><br/><br/>
    年龄：&ensp;&ensp;&ensp;&ensp;<input type="number" name="age" min="1" max="150"/><br/><br/>
    密码：&ensp;&ensp;&ensp;&ensp;<input type="password" name="password" id="password" maxlength="16"/><br/><br/>
    确认密码：<input type="password" name="passwordConfirm" id="passwordConfirm" onfocusout="checkPwd()"/>
            <font id="font2" color="red"></font><br/><br/>
    电话：&ensp;&ensp;&ensp;&ensp;<input type="text" name="tel" oninput="value=value.replace(/[^\d]/g,'')"/><br/><br/>
    邮箱：&ensp;&ensp;&ensp;&ensp;<input type="email" name="email"><br/><br/>
    爱好：&ensp;&ensp;&ensp;&ensp;撩妹<input type="checkbox" name="hobbies" value="撩妹" checked="checked" />
         写代码<input type="checkbox" name="hobbies" value="写代码" />
         篮球<input type="checkbox" name="hobbies" value="篮球" />
         足球<input type="checkbox" name="hobbies" value="足球" /><br/><br/>
    个人签名：<textarea name="sign" >

             </textarea><br/><br/>
    <input type="submit" name="submit" value="注册" id="sub" />
    &ensp;<input value="取消" type="reset"/>
</form>
</div>
</body>
</html>
<script>
    function checkName() {
        var reg=/^[0-9a-zA-Z]+$/;
        var username=document.getElementById("username").value;
        if(!reg.test(username)){
            //alert("用户名格式应为字母和数字的组合！")
            document.getElementById("font1").innerHTML="用户名格式应为字母和数字的组合！";
            return false;
        }
        else {
            if (username.length<6){
                //alert("用户名长度应为6-16！");
                document.getElementById("font1").innerHTML="用户名长度应为6-16！";
                return false;
            }
            else {
                document.getElementById("font1").innerHTML="ok";
                return true;
            }
        }
    }
    function checkPwd(){
        var password = document.getElementById("password");
        var passwordConfirm = document.getElementById("passwordConfirm");
        var reg=/^[0-9a-zA-Z]+$/;

        if (!reg.test(password.value)||!reg.test(passwordConfirm.value)) {
            document.getElementById("font2").innerHTML="用户名格式应为字母和数字的组合！";
            return false;
        }
        else {
                if(password.value != passwordConfirm.value){
                document.getElementById("font2").innerHTML="两次输入的密码不一致！";
                return false;
                }
                else {
                    if (password.value.length <6) {

                        document.getElementById("font2").innerHTML = "密码长度应为6-16！";
                        return false;
                    }
                    else {
                        document.getElementById("font2").innerHTML = "ok";
                        return true;
                    }
                }
        }
    }
    function checkSubmit() {

        if(checkName()&&checkPwd()){
            return true;
        }
        else {
            alert("请输入正确的信息!")
            return false;
        }
    }
</script>