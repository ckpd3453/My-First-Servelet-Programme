<%--
  Created by IntelliJ IDEA.
  User: SHREEKANT
  Date: 03-05-2022
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success</title>
</head>
<body>
<h3>Hi <%= request.getAttribute("user")%>,Login Successful</h3>
<a href ="login.html">Home</a>
</body>
</html>