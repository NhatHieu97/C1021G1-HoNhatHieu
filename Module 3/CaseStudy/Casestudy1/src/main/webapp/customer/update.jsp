<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/20/2022
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/customers?action=update" method="post">
                <div class="form-group">
                    <label>ID</label>
                    <input type="text" readonly class="form-control" value="${customer.id}"  name="id">
                </div>
                <div class="form-group">
                    <label for="name-customer">Name</label>
                    <input type="text" class="form-control" id="name-customer" value="${customer.name}" name="name-customer">
                </div>
                <div class="form-group">
                    <label for="code-customer">Code</label>
                    <input type="text" readonly class="form-control" id="code-customer" value="${customer.code}" name="code">
                </div>
                <div class="form-group">
                    <label for="birthday">Birthday</label>
                    <input type="date" class="form-control" id="birthday" value="${customer.birthday}" name="birthday">
                </div>
                <div class="form-group">
                    <label for="id-card">ID Card</label>
                    <input type="text" class="form-control" id="id-card" value="${customer.idCard}" name="idcard">
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" value="${customer.phone}" name="phone">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" value="${customer.email}" name="email">
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" value="${customer.address}" name="address">
                </div>
                <div class="form-group">
                    <label for="gender">Gender</label>
                    <select class="form-control" id="gender" name="gender" value="${customer.gender}" required>
                        <option  value="">Chọn...</option>
                        <option value="true" >Nam</option>
                        <option value="false" >Nữ</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="category">CustomerType</label>
                    <select class="form-control" id="category" value="${type.nameCustomerType}" name="idCustomerType">
                        <c:forEach var="type" items="${customerTypeList}">
                            <option value="${type.idCustomerType}">${type.nameCustomerType}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>

