<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/6
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改用户信息</title>
    <style>
        body{
            background-image: url("../image/bg2.jpg");
        }
    </style>
</head>
<body>
<h2>输入需要更改的信息</h2>
<form name="form1" method="post" action="UpdateUserServlet" onsubmit="return confirm('确认修改？')">
    用户名：&ensp;&ensp;<input name="username" type="text" value="${requestScope.modifiedUser.username}" readonly /><br/><br/>
    密码：&ensp;&ensp;&ensp;&ensp;<input type="text" name="password" value="${requestScope.modifiedUser.password}" readonly/><br/><br/>
    性别：&ensp;&ensp;&ensp;&ensp;
    <c:if test="${requestScope.modifiedUser.sex==\"男\"}">
    男<input type="radio" name="sex" value="男" checked="checked"/>
    女<input type="radio" name="sex" value="女"/><br/><br/>
    </c:if>
    <c:if test="${requestScope.modifiedUser.sex=='女'}">
        男<input type="radio" name="sex" value="男" />
        女<input type="radio" name="sex" value="女" checked="checked"/><br/><br/>
    </c:if>
    姓名：&ensp;&ensp;&ensp;&ensp;<input name="realName" type="text" value="${requestScope.modifiedUser.realName}" /><br/><br/>
    年龄：&ensp;&ensp;&ensp;&ensp;<input type="text" name="age" maxlength="3" value="${requestScope.modifiedUser.age}"/><br/><br/>
    爱好：&ensp;&ensp;&ensp;&ensp;
    撩妹<input type="checkbox" name="hobbies" value="撩妹" ${requestScope.modifiedUser.hobbyList.contains("撩妹") eq true?'checked':''} />
    写代码<input type="checkbox" name="hobbies" value="写代码" ${requestScope.modifiedUser.hobbyList.contains("写代码") eq true?'checked':''}/>
    篮球<input type="checkbox" name="hobbies" value="篮球" ${requestScope.modifiedUser.hobbyList.contains("篮球") eq true?'checked':''}/>
    足球<input type="checkbox" name="hobbies" value="足球" ${requestScope.modifiedUser.hobbyList.contains("足球") eq true?'checked':''}/><br/><br/>
    电话：&ensp;&ensp;&ensp;&ensp;<input type="text" name="tel" maxlength="11" oninput="value=value.replace(/[^\d]/g,'')" value="${requestScope.modifiedUser.tel}"/><br/><br/>
    邮箱：&ensp;&ensp;&ensp;&ensp;<input type="email" name="email" value="${requestScope.modifiedUser.email}"><br/><br/>
    个人签名：<textarea name="sign" >${requestScope.modifiedUser.sign}
             </textarea><br/><br/>
    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
    <input type="submit" name="submit" value="更新用户信息"  />

</form>
</body>
</html>
