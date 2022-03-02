<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/14/2022
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/products?action=create">Create New Product</a>
</p>
<form method="post" action="/products?action=search">
    <input type="text" name="search">
    <input type="submit" value="Search">
</form>
<table border="1">
    <tr>
        <td>Tên sản Phẩm</td>
        <td>Giá</td>
        <td>Mô tả</td>
        <td>Nhà sản xuất</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="product" items="${products}" >
    <tr>
        <td>${product.getProductName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getDescription()}</td>
        <td>${product.getProducer()}</td>
        <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
        <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
