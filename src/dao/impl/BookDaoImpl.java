package dao.impl;

import util.Connector;
import util.ConnectorBeta;
import dao.BookDao;
import dao.entity.Author;
import dao.entity.Book;
import dao.entity.Genre;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    Connection connection = Connector.getConnection();
//    Connection connection = ConnectorBeta.getConnection();

    public BookDaoImpl() throws SQLException {
    }

    @Override
    public List<Book> getBookList() throws SQLException {
        String sql = "SELECT * FROM authors;";
        Statement statement = connection.createStatement();
        ResultSet resultSetAuthor = statement.executeQuery(sql);
        List<Author> authorList = new ArrayList<>();
        while (resultSetAuthor.next()) {
            int id = resultSetAuthor.getInt(1);
            String firstName = resultSetAuthor.getString(2);
            String secondName = resultSetAuthor.getString(3);
            authorList.add(new Author(id, firstName, secondName));
        }

        String sql2 = "SELECT * FROM library;";
        ResultSet resultSetBook = statement.executeQuery(sql2);
        List<Book> bookList = new ArrayList<>();
        Book book = null;
        Author author = null;
        int i = 0;
        while (resultSetBook.next()) {
            int id = resultSetBook.getInt(1);
            String title = resultSetBook.getString(2);
            String genrestr = resultSetBook.getString(3);
            Genre genre = Genre.valueOf(genrestr);
            Date date = resultSetBook.getDate(4);
            LocalDate localDate = date.toLocalDate();
            int authorId = resultSetBook.getInt(5);
            for (Author n : authorList) {
                if (n.getId() == authorId) {
                    author = n;
                    break;
                }
            }
            bookList.add(new Book(id, title, genre, localDate, author));
            System.out.println(bookList.get(i));
            i++;
        }
        return bookList;
    }

    @Override
    public List<Book> getAuthorBookList(Author authorBook) throws SQLException {
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

        String sql2 = "SELECT * FROM library;";
        ResultSet resultSetBook = statement.executeQuery(sql2);
        List<Book> bookList = new ArrayList<>();
        Book book = null;
        i = 0;
        while (resultSetBook.next()) {
            int id = resultSetBook.getInt(1);
            String title = resultSetBook.getString(2);
            String genrestr = resultSetBook.getString(3);
            Genre genre = Genre.valueOf(genrestr);
            Date date = resultSetBook.getDate(4);
            LocalDate localDate = date.toLocalDate();
            int authorId = resultSetBook.getInt(5);
            if (authorId == authorBook.getId()) {
                bookList.add(new Book(id, title, genre, localDate, authorBook));
                System.out.println(bookList.get(i));
                i++;
            }
        }
        return bookList;
    }

    @Override
    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO library (id, title, genre, dateCreated, authorId) VALUES (?, ? , ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, book.getId());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setString(3, String.valueOf(book.getGenre()));
        preparedStatement.setDate(4, Date.valueOf(book.getDateCreated()));
        Author author = book.getAuthor();
        preparedStatement.setObject(5, author.getId());
        int rows = preparedStatement.executeUpdate();
    }


    @Override
    public void editBook(Book book) throws SQLException {
        String sql = "UPDATE Library SET title=?, genre=? where Id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, String.valueOf(book.getGenre()));
        preparedStatement.setInt(3, book.getId());
        int rows = preparedStatement.executeUpdate();
    }


    @Override
    public void deleteBook(Book book) throws SQLException {
        String sql = "DELETE from Library where Id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, book.getId());
        int rows = preparedStatement.executeUpdate();
    }
}






