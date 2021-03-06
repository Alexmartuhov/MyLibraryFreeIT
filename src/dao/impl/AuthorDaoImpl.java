package dao.impl;

import util.Connector;
import util.ConnectorBeta;
import dao.AuthorDao;
import dao.entity.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    Connection connection = Connector.getConnection();
//    Connection connection = ConnectorBeta.getConnection();

    public AuthorDaoImpl() throws SQLException {
    }

    @Override
    public void addAuthor(Author author) throws SQLException {
        String sql = "INSERT INTO Authors (id, firstname, secondname) VALUES (?, ? , ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, author.getId());
        preparedStatement.setString(2, author.getFirstName());
        preparedStatement.setString(3, author.getSecondName());
        int rows = preparedStatement.executeUpdate();
    }

    @Override
    public void deleteAuthor(Author author) throws SQLException {
        String sql = "DELETE from Authors where Id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, author.getId());
        int rows = preparedStatement.executeUpdate();
    }

    @Override
    public Author getAuthor(int authorId) throws SQLException {
        String sql = "SELECT * FROM authors;";
        Statement statement = connection.createStatement();
        ResultSet resultSetAuthor = statement.executeQuery(sql);
        List<Author> authorList = new ArrayList<>();
        int i = 0;
        Author author = null;
        while (resultSetAuthor.next()) {
            int id = resultSetAuthor.getInt(1);
            String firstName = resultSetAuthor.getString(2);
            String secondName = resultSetAuthor.getString(3);
            authorList.add(new Author(id, firstName, secondName));
            if (id == authorId) {
                author = authorList.get(i);
                break;
            }
            i++;
        }
        return author;
    }

    @Override
    public List<Author> getAuthorList() throws SQLException {
        String sql = "SELECT * FROM authors;";
        Statement statement = connection.createStatement();
        ResultSet resultSetAuthor = statement.executeQuery(sql);
        List<Author> authorList = new ArrayList<>();
        int i = 0;
        while (resultSetAuthor.next()) {
            int id = resultSetAuthor.getInt(1);
            String firstName = resultSetAuthor.getString(2);
            String secondName = resultSetAuthor.getString(3);
            authorList.add(new Author(id, firstName, secondName));
            System.out.println(authorList.get(i));
            i++;
        }
        return authorList;
    }
}
