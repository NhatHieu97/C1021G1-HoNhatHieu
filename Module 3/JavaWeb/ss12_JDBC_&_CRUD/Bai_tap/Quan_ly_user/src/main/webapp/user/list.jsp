<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/12/2022
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
  <link href="https://fonts.googleapis.
  com/icon?family=Material+Icons" rel="stylesheet">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <title>User Management Application</title>
</head>
<body>
<center>
  <h1><a href="/users">User Management</a></h1>
  <h2>
    <a href="/users?action=create">Add New User</a>
  </h2>
  <form method="post" action="/users?action=search">
    <input type="text" name="country">
    <input type="submit" value="search">
  </form>
</center>
<div align="center">
  <table border="1" cellpadding="5" id="list" class="table table-striped table-bordered" style="width:70%">
    <caption><h2>List of Users</h2></caption>
    <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Country</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${listUser}">
      <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.country}"/></td>
        <td>
          <a style="text-decoration-line: none" href="/users?action=edit&id=${user.id}"><i class="material-icons">edit</i>Edit</a>
          <a style="text-decoration-line: none" href="/users?action=delete&id=${user.id}"><i style="color: red; " class="material-icons">delete</i>Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"> </script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
<script>
  $(document).ready(function() {
    $('#list').DataTable();
  } );
</script>
</html>
