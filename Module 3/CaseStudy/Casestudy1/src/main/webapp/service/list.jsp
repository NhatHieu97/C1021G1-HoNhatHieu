<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/21/2022
  Time: 11:03 AM
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
<a class="btn btn-success" href="/services?action=create">Add new service</a>
<a class="btn btn-danger" href="/">Back to home</a>
<table id="product" class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id Service</th>
        <th scope="col">Name</th>
        <th scope="col">Service Area</th>
        <th scope="col">Service Cost</th>
        <th scope="col">Service Max People</th>
        <th scope="col">Standard Room</th>
        <th scope="col">Description Other Convenience</th>
        <th scope="col">Pool Area</th>
        <th scope="col">Number Of Floors</th>
        <th scope="col">Rent Type Name</th>
        <th scope="col">Rent Type Cost</th>
        <th scope="col">Service Type Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="service" items="${serviceList}">
        <tr>
            <td >${service.idService}</td>
            <td >${service.name}</td>
            <td >${service.serviceArea}</td>
            <td >${service.serviceCost}</td>
            <td >${service.serviceMaxPeople}</td>
            <td >${service.standardRoom}</td>
            <td >${service.descriptionOtherConvenience}</td>
            <td >${service.poolArea}</td>
            <td >${service.numberOfFloors}</td>
            <td >${service.rentTypeName}</td>
            <td >${service.renTypeCost}</td>
            <td >${service.serviceTypeName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>






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


<script>
    function deleteCustomer(id, name) {
        document.getElementById("id-customer").value = id;
        document.getElementById("name-customer").innerText = name;
    }
    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>
</body>
</html>
