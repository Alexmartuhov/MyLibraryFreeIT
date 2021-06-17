package dao;

import dao.entity.Author;
import dao.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {
    void addAuthor(Author author) throws SQLException;

    void deleteAuthor(Author author) throws SQLException;

    Author getAuthor(int authorId) throws SQLException;

    List<Author> getAuthorList() throws SQLException;
}
