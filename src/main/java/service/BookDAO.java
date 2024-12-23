package service;


import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/booksDB";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Pk@2051720159";

    private static final String INSERT_BOOKS_SQL = "INSERT INTO book" + "(name,isbn) VALUES" + "(?,?);";
    private static final String SELECT_BOOKS_BY_ID = "select * from book where id =?";
    private static final String SELECT_ALL_BOOKS = "select * from book";
    private static final String DELETE_BOOKS_SQL = "delete from book where id = ?;";
    private static final String UPDATE_BOOKS_SQL = "update book set name = ?,isbn =? where id = ?;";


    public BookDAO() {
    }

    protected Connection getConnection(){
        System.out.println("Hellooooooopppppppppppppppp");
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.print("hellopopop");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("hello");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("hi");

        }
        System.out.print("hello000");

        return connection;
    }

    public void insertBook(Book book) throws SQLException {
        System.out.println(INSERT_BOOKS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getIsbn());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Book selectBook(int id) {
        Book book = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String isbn = rs.getString("isbn");
                book = new Book(name, isbn);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return book;
    }

    public List< Book > selectAllBooks() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Book > books = new ArrayList< >();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String isbn = rs.getString("isbn");
                System.out.println(id);
                System.out.println(name);
                System.out.println("Hellllllllllloooooooooo");

                books.add(new Book(id, name, isbn));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return books;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
