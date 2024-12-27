<%--
  Created by IntelliJ IDEA.
  Book: pratikkhadka
  Date: 24/12/2024
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Book Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <h1>Book Management App <h1>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Books</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Books</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/insert" class="btn btn-success">Add
                New Book</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <%--                <th>Id</th>--%>
                <th>Id</th>
                <th>Name</th>
                <th>Actions</th>

            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="Book" items="${listBook}">

                <tr>
                    <td>
                        <c:out value="${Book.id}"/>
                    </td>
                    <td>
                        <c:out value="${Book.name}"/>
                    </td>
                    <td>
                        <c:out value="${Book.isbn}"/>
                    </td>

                    <td><a href="edit?id=<c:out value='${Book.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="delete?id=<c:out value='${Book.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>

</html>
