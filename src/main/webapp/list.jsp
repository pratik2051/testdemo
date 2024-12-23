<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Book List</h2>
<a href="new">Add New Book</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>ISBN</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="book" items="${listBook}">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.isbn}</td>
            <td>
                <a href="edit?id=${book.id}">Edit</a>
                <a href="delete?id=${book.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
