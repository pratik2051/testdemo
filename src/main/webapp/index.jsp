<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>Book Management System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<script>
    window.onload = function() {
        const ui = SwaggerUIBundle({
            url: "/your-app-context/openapi.json",
            dom_id: '#swagger-ui',
            presets: [
                SwaggerUIBundle.presets.apis,
                SwaggerUIStandalonePreset
            ],
            layout: "StandaloneLayout"
        })
        window.ui = ui
    }
</script>


<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #ff47a9">
        <div>
            <a class="navbar-brand"> Book Management System</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Books</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center"></h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/book-form.jsp" class="btn btn-success">Add
                New Book</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <%--                <th>ID</th>--%>
                <th>Name</th>
                <th>ISBN</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->

            <c:forEach var="books" items="${listBook}">
                <tr>
                        <%--                    <td>--%>
                        <%--                        <c:out value="${books.id}" />--%>
                        <%--                    </td>--%>
                    <td>
                        <c:out value="${books.name}"/>
                    </td>
                    <td>
                        <c:out value="${books.isbn}"/>
                    </td>
                    <td><a href="edit?id=<c:out value='${books.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="delete?id=<c:out value='${books.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>

</html>
