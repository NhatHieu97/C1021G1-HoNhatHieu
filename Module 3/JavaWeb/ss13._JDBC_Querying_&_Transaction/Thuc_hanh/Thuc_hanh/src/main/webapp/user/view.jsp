<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/14/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h3>Show User</h3>
  <a href="/users">To Back List User</a>
<table border="1">
<tr>
  <td>Name</td>
  <td>${user.getName()}</td>
</tr>

  <tr>
    <td>Email</td>
    <td>${user.getEmail()}</td>
  </tr>

  <tr>
    <td>Country</td>
    <td>${user.getCountry()}</td>
  </tr>
</table>
  </body>
</html>
