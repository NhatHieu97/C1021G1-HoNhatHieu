<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/22/2022
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
    <link href="https://fonts.googleapis.
  com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<a class="btn btn-success" href="/employees?action=create">Add new employee</a>
<a class="btn btn-danger" href="/">Back to home</a>
<table id="list" class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Code</th>
        <th scope="col">Birthday</th>
        <th scope="col">IdCard</th>
        <th scope="col">Phone</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Education Degree </th>
        <th scope="col">Position </th>
        <th scope="col">Division </th>
        <th scope="col">User Name </th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td >${employee.id}</td>
            <td >${employee.name}</td>
            <td >${employee.code}</td>
            <td >${employee.birthday}</td>
            <td >${employee.idCard}</td>
            <td >${employee.phone}</td>
            <td >${employee.email}</td>
            <td >${employee.address}</td>
            <td >${employee.educationDegree}</td>
            <td >${employee.position}</td>
            <td >${employee.division}</td>
            <td >${employee.userName}</td>
            <td>
                <button class="btn btn-warning">
                    <a href="/employees?action=update&id=${employee.getId()}">Edit</a>
                </button>
                <button onclick="deleteCustomer('${employee.id}','${employee.name}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure delete <span class="text-danger" id="name-employee"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>


<form hidden id="form-delete" method="post" action="/employees">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="id-employee">
</form>

<script>
    function deleteCustomer(id, name) {
        document.getElementById("id-employee").value = id;
        document.getElementById("name-employee").innerText = name;
    }
    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="/assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"> </script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#list').DataTable();
    } );
</script>



</body>
</html>