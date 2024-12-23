package model;

public class Book {
    private int id;
    private String name;
    private String isbn;

    public Book(){}
    public Book(String name, String isbn) {
        this.name = name;
        this.isbn = isbn;
    }

    public Book(int id, String name, String isbn) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
