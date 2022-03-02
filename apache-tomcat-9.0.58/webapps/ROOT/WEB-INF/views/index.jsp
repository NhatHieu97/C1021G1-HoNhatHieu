<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/1/2022
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Caculator</title>
    <style>
      h1,h2{
        text-align: center;
      }
    </style>
    <h1>Caculator</h1>
  </head>
  <body>
  <form action="/caculator" style="text-align: center">
    <input type="text" name="num1">
    <input type="text" name="num2">
    <hr style="width: 50%;">
    <br>

    <input type="submit" name="caculate" value="+">
    <input type="submit" name="caculate" value="-">
    <input type="submit" name="caculate" value="*">
    <input type="submit" name="caculate" value="/">
  </form>

  <c:if test="${result!=null}">
      <h2>${result}</h2>
  </c:if>
  </body>
</html>
