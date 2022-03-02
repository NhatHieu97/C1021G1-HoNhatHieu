<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/21/2022
  Time: 1:32 PM
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
            <form action="/services?action=create" method="post">
                <div class="form-group">
                    <label>ID</label>
                    <input type="text" readonly class="form-control" value="${id}"  name="id">
                </div>
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="serviceArea">Service Area</label>
                    <input type="text" class="form-control" id="serviceArea" name="serviceArea">
                </div>
                <div class="form-group">
                    <label for="serviceCost">Service Cost</label>
                    <input type="text" class="form-control" id="serviceCost" name="serviceCost">
                </div>
                <div class="form-group">
                    <label for="serviceMaxPeople">Service Max People</label>
                    <input type="text" class="form-control" id="serviceMaxPeople" name="serviceMaxPeople">
                </div>
                <div class="form-group">
                    <label for="standardRoom">Standard Room</label>
                    <input type="text" class="form-control" id="standardRoom" name="standardRoom">
                </div>
                <div class="form-group">
                    <label for="descriptionOtherConvenience">Description Other Convenience</label>
                    <input type="text" class="form-control" id="descriptionOtherConvenience" name="descriptionOtherConvenience">
                </div>
                <div class="form-group">
                    <label for="poolArea">Pool Area</label>
                    <input type="text" class="form-control" id="poolArea" name="poolArea">
                </div>
                <div class="form-group">
                    <label for="numberOfFloors">Number Of Floors</label>
                    <input type="text" class="form-control" id="numberOfFloors" name="numberOfFloors">
                </div>

                <div class="form-group">
                    <label for="category">Rent Type List</label>
                    <select class="form-control" id="category" name="rentTypeId">
                        <c:forEach var="type" items="${rentTypeList}">
                            <option value="${type.rentTypeId}">${type.rentTypeName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="categorys">Service Type List</label>
                    <select class="form-control" id="categorys" name="serviceTypeId">
                        <c:forEach var="types" items="${serviceTypeList}">
                            <option value="${types.serviceTypeId}">${types.serviceTypeName}</option>
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

