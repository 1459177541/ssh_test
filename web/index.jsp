<%@ page import="java.util.Date" %>
<%@ page import="entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 杨星辰
  Date: 2018-09-28
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <style type="text/css">
        *{
            align-content: center
        }
    </style>
</head>
<body>
    <h1>
        Hello,
        <%
            User user = (User)session.getAttribute("user");
            out.print(user != null ? user.getName() : "World");
        %>
    </h1>
    现在是：<%=new Date()%><a href="login/login.jsp">登陆>>></a>
</body>
</html>
