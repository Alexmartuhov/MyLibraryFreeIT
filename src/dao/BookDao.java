package dao;

import dao.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> getBookList() throws SQLException;

    void addBook(Book book) throws SQLException;

    void editBook(Book book) throws SQLException;

    void deleteBook(Book book) throws SQLException;
}
