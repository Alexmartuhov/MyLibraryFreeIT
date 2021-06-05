package dao;

import dao.entity.Author;

import java.sql.SQLException;

public interface AuthorDao {
    void addAuthor (Author author) throws SQLException;
    void deleteAuthor (Author author) throws SQLException;
    Author getAuthor (int authorId) throws SQLException;
}
