<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/28/2022
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng từ điển</title>
</head>
<body>
<form action="/translate">
    <input type="text" name = "english">
    <input type="submit" value="translate">
</form>
<h1>${vietnamese!=null?
vietnamese:message}</h1>

</body>
</html>
