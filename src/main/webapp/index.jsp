<%@ page language="java"  pageEncoding="UTF-8"%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>首页</title>
     <script type="text/javascript">
    	function doLogout(){
    		//访问LogoutServlet注销当前登录的用户
    		window.location.href="${pageContext.request.contextPath}/servlet/LogoutServlet";
    	}
    </script>
    <style>
      body{
        text-align: center;
      }
    </style>
  </head>
  <body>
	<h1>神州优车训练营网站</h1>
    <a href="user/login.jsp">登录</a>
</body>
</html>
