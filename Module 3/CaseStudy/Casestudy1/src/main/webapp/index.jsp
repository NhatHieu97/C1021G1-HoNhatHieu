<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2/18/2022
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
  </head>
  <style>
    .name{
      text-align: center;
      margin-right: 40px;
    }

  </style>
  <body>
  <div class="container-fluid border-bottom border-dark">
    <div class=" row p-1 container-fluid d-flex justify-content-between ">
      <div class="d-flex align-items-center">
        <a href=""><img src="assert/image/Logo-FURAMA-RESORT.jpg" alt="" width="80px"></a>
      </div>
      <div class="d-flex align-items-center">
        <a href="">Hồ Nhật Hiếu <i class="fa fa-sign-in"></i></a>
      </div>
    </div>
  </div>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse p-1" id="navbarTogglerDemo03 ">
      <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        <li class="nav-item active">
          <a class="nav-link " href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link " href="/employees">Employee <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/customers">Customer <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/services">Service <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="#">Contract <span class="sr-only">(current)</span></a>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0">
        <input style="border-radius: 20px" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
  <div class="row d-flex mx-0 ">
    <div class="col-2 d-flex flex-column child px-2">
      <p>Item One</p>
      <p>Item Two</p>
      <p>Item Three</p>
    </div>
    <div class="col-10 d-flex justify-content-center align-items-center">
      <p>Body...</p>
    </div>
  </div>
  <div class="row mx-0 footer border-top fixed-bottom">
    <div class="col-12 d-flex justify-content-center align-items-center py-2">
      <p class="mb-0">Footer...</p>
    </div>
  </div>
  </div>
  </body>
  <script src="/assert/jquery/jquery-3.5.1.min.js"></script>
  <script src="/assert/bootstrap413/js/popper.min.js"></script>
  <script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
  <script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</html>
