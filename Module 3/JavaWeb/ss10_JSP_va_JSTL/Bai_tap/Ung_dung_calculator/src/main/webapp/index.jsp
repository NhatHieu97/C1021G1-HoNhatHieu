<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/26/2022
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <h1>Simple Calculator</h1>
      <form action="/CalculatorServlet" method="post">
        <table border="1">
          First operand: <input type="text" name="first">
          Operator: <select name="operator" id="Chọn" >
           <optgroup label="Hãy Chọn">
               <option value="cong">Cộng</option>
               <option value="tru">Trừ</option>
               <option value="nhan">Nhân</option>
               <option value="chia">Chia</option>
           </optgroup>

        </select>
          Second operator: <input type="text" name="second">
         <input type="submit" value="calculater">
        </table>
      </form>
  </body>
</html>
