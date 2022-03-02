<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/22/2022
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body onload="checkDate()">
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/employees?action=update" method="post">
                <div class="form-group">
                    <label>ID</label>
                    <input type="text" readonly class="form-control" value="${employee.id}"  name="id">
                </div>
                <div class="form-group">
                    <label for="name-employee">Name</label>
                    <input type="text" class="form-control" id="name-employee" value="${employee.name}" name="name-employee">
                </div>
                <div class="form-group">
                    <label for="code-employee">Code</label>
                    <input type="text" readonly class="form-control" id="code-employee" value="${code}" name="code">
                </div>
                <div class="form-group">
                    <label for="validationDate">Birthday</label>
                    <input type="date" class="form-control" id="validationDate" value="${employee.birthday}" name="birthday">
                </div>
                <div class="form-group">
                    <label for="id-card">ID Card</label>
                    <input type="text" class="form-control" id="id-card" value="${employee.idCard}" name="idcard">
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" pattern="(09|03|07|08|05)+([0-9]{8})" class="form-control" id="phone" value="${employee.phone}" name="phone">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" value="${employee.email}" name="email">
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" value="${employee.address}" name="address">
                </div>
                <div class="form-group">
                    <label for="username">User Name</label>
                    <input type="text" class="form-control" id="username" value="${employee.userName}" name="username">
                </div>
                <div class="form-group">
                    <label for="salary">Salary</label>
                    <input type="text" class="form-control" id="salary" value="${employee.salary}" name="salary">
                </div>
                <div class="form-group">
                    <label for="category">Education Degree</label>
                    <select class="form-control" id="category" name="employeeEducationDegreeList">
                        <c:forEach var="type" items="${employeeEducationDegreeList}">
                            <option value="${type.idEducationDegree}">${type.nameEducationDegree}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="category1">Division</label>
                    <select class="form-control" id="category1" name="employeeDivisionList">
                        <c:forEach var="type" items="${employeeDivisionList}">
                            <option value="${type.idDivision}">${type.nameDivision}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="category2">Position</label>
                    <select class="form-control" id="category2" name="employeePositions">
                        <c:forEach var="type" items="${employeePositions}">
                            <option value="${type.idPosition}">${type.namePosition}</option>
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
<script>
    function checkDate(){
        let day = document.getElementById("validationDate");
        day.min = "2000/01/01";
    }
</script>
</body>
</html>

