<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/1/2022
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/save" >
    <label>Lettuce</label>
    <input type="checkbox" name="condiment" value="lettuce">
    <label>tomato</label>
    <input type="checkbox" name="condiment" value="tomato">
    <label>mustard</label>
    <input type="checkbox" name="condiment" value="mustard">
    <label>sprouts</label>
    <input type="checkbox" name="condiment" value="sprouts">
    <hr>
    <br>
    <input type="submit" value="save">
  </form>
  </body>
</html>
