Overview
The bookServlet class is a Java EE Servlet that handles CRUD (Create, Read, Update, Delete) operations for books. It interacts
with the BookDAO class for database operations and uses JSP pages for rendering responses.
API Endpoints
1. GET /
   • Description: Fetches and displays the list of all books.
   • Request Parameters: None
   • Request Body: None
   • Response:
   o Renders the index.jsp page.
   o Sets the following attribute:
   § listBook: List of all books retrieved from the database.
2. GET /new
   • Description: Displays a form for adding a new book.
   • Request Parameters: None
   • Request Body: None
   • Response:
   o Renders the book-form.jsp page.
3. POST /insert
   • Description: Inserts a new book into the database.
   • Request Parameters:
   o name (String): The name of the book.
   o isbn (String): The ISBN of the book.
   • Request Body: None
   • Response:
   o Redirects to /list.
4. GET /edit
   • Description: Displays a form to edit an existing book.
   • Request Parameters:
   o id (int): The ID of the book to edit.
   • Request Body: None
   • Response:
   o Renders the edit-form.jsp page.
   o Sets the following attribute:
   § book: The details of the book retrieved from the database.
5. POST /update
   • Description: Updates an existing book in the database.
   • Request Parameters:
   o id (int): The ID of the book to update.
   o name (String): The updated name of the book.
   o isbn (String): The updated ISBN of the book.
   • Request Body: None
   • Response:
   o Redirects to /list.
6. POST /delete
   • Description: Deletes a book from the database.
   • Request Parameters:
   o id (int): The ID of the book to delete.
   • Request Body: None
   • Response:
   o Redirects to /list.
   Error Handling
   • SQL Exceptions: Any database-related errors are caught and rethrown as ServletException.
   • Validation: Ensure all required parameters (id, name, isbn) are provided; otherwise, handle missing data appropriately
   in the JSP views or controllers.