package web;


import model.Book;
import service.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
    public class bookServlet extends HttpServlet {

        private BookDAO bookDAO;

        public void init() {
            bookDAO = new BookDAO();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String action = request.getServletPath();

            try {
                switch (action) {
                    case "/new":
                        showNewForm(request, response);
                        break;
//                    case "/insert":
 //                       insertBook(request, response);
//                        break;
//                    case "/delete":
//                        deleteBook(request, response);
//                        break;
                    case "/edit":
                        showEditForm(request, response);
                       break;
                   case "/list":
                       listBook(request, response);
                          break;
                    default:
                        insertBook(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

        private void listBook(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            System.out.println("hello");
            List<Book> listBook = bookDAO.selectAllBooks();
            request.setAttribute("listBook", listBook);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
            System.out.println("PRATIK"+listBook);
        }

        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
            dispatcher.forward(request, response);
        }

        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Book existingBook = bookDAO.selectBook(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
            request.setAttribute("book", existingBook);
            dispatcher.forward(request, response);

        }

        private void insertBook(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            String name = request.getParameter("name");
            String isbn = request.getParameter("isbn");
            Book newBook = new Book(name, isbn);
            bookDAO.insertBook(newBook);
            response.sendRedirect("list");
        }

 //       private void updateBook(HttpServletRequest request, HttpServletResponse response)
//                throws SQLException, IOException {
//            int id = Integer.parseInt(request.getParameter("id"));
//            String name = request.getParameter("name");
//            String isbn = request.getParameter("isbn");
//            Book book = new Book(id, name, isbn);
//            bookDAO.updateBook(book);
//            response.sendRedirect("list");
//        }

//        private void deleteBook(HttpServletRequest request, HttpServletResponse response)
//                throws SQLException, IOException {
//            int id = Integer.parseInt(request.getParameter("id"));
//            bookDAO.deleteBook(id);
//            response.sendRedirect("list");
//
//        }
//    }
}
