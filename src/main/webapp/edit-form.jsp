<%--
  Created by IntelliJ IDEA.
  book: pratikkhadka
  Date: 24/12/2024
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>book Management Application</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a class="navbar-brand"> Book Management System</a>
        </div>


        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Books</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${book != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${book == null}">
                <form action="update" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${book != null}">
                                Edit book
                            </c:if>
                            <c:if test="${book == null}">
                                Edit book
                            </c:if>
                        </h2>
                    </caption>


                    <fieldset class="form-group">
                        <label></label> <input type="hidden" value="<c:out value="${book.id}" />" class="form-control"
                                               name="id">
                    </fieldset>


                    <fieldset class="form-group">
                        <label>book Name</label> <input type="text" value="<c:out value="${book.name}" />"
                                                        class="form-control" name="name">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>book Isbn</label> <input type="text" value="<c:out value="${book.isbn}" />"
                                                        class="form-control" name="isbn">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Update</button>
                    <a href="/testdemo/list" class="btn btn-secondary">Cancel</a>
                </form>
        </div>
    </div>
</div>
</body>

</html>