package service;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/booksDB";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Pk@2051720159";

    private static final String INSERT_BOOKS_SQL = "INSERT INTO book (name, isbn) VALUES (?, ?);";
    private static final String SELECT_BOOKS_BY_ID = "SELECT * FROM book WHERE id = ?;";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM book;";
    private static final String DELETE_BOOKS_SQL = "DELETE FROM book WHERE id = ?;";
    private static final String UPDATE_BOOKS_SQL = "UPDATE book SET name = ?, isbn = ? WHERE id = ?;";

    public BookDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Connection Failed: " + e.getMessage());
        }
        return connection;
    }

    public void insertBook(Book book) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getIsbn());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Book selectBook(int id) {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String isbn = rs.getString("isbn");
                book = new Book(id, name, isbn);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return book;
    }

    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String isbn = rs.getString("isbn");
                books.add(new Book(id, name, isbn));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return books;
    }

    public boolean deleteBook(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOKS_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    public boolean updateBook(Book book) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKS_SQL)) {
            statement.setString(1, book.getName());
            statement.setString(2, book.getIsbn());
            statement.setInt(3, book.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        System.err.println("SQL Exception Details:");
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
