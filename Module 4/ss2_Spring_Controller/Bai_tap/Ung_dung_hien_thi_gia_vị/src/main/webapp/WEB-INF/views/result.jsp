<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/1/2022
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<c:forEach var = "result" items="${condiment}"><h2>${result}</h2></c:forEach>

</body>
</html>
