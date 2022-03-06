<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/2/2022
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <h1 style="text-align: center">Chương trình cấu hình hòm thư điện tử</h1>
</head>
<body>
<form:form action="create" method="post" modelAttribute="emailObj">
    <table style="margin: auto"  class="table">
        <tr>
            <td>
                <form:label path="languages">Language</form:label>
            </td>
            <td>
                <form:select path="languages">
                    <form:option value="">----Language----</form:option>
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                    <form:option value="Thai">Thai</form:option>
                </form:select>
            </td>

        </tr>
        <tr>
            <td>
                <form:label path="pageSize">Page Size</form:label>
            </td>
            <td>
                <form:select path="pageSize">
                    <form:option value="25">--------------</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="75">75</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="spamsFilter">Spams Filter</form:label>
            </td>
            <td>
                <form:checkbox path="spamsFilter" value="true"/>Enable spams filter
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="signature">Signature</form:label>
            </td>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <td>
                <form:button value="update">update</form:button>
            </td>
            <td>
                <input type="reset" value="cancle">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
