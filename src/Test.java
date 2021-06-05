import dao.entity.Author;
import dao.entity.Book;
import dao.impl.BookDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import static dao.entity.Genre.CLASSIC;

public class Test {
    //    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/mylibrary";
//        String username = "root";
//        String password = "3UKtp47k";
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Connection successful!");
//            BookDaoImpl bookDao = new BookDaoImpl();
//            Author dreiser = new Author(5, "Theodore", "Dreiser");
//            Book book = new Book(1, "Американская трагедия", CLASSIC,
//                    LocalDate.now(), dreiser);
////            String sql = "DELETE from Library where Id = ? ";
////            PreparedStatement preparedStatement = connection.prepareStatement(sql);
////            preparedStatement.setInt(1,book.getId());
////            int rows =preparedStatement.executeUpdate();
//            String sql2 = "UPDATE Library SET title=?, genre=? where Id = ? ";
//            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
//            preparedStatement2.setString(1, book.getTitle());
//            preparedStatement2.setString(2, String.valueOf(book.getGenre()));
//            preparedStatement2.setInt(3,book.getId());
//            int rows =preparedStatement2.executeUpdate();
//        } catch (Exception ex) {
//            System.out.println("Connection failed...");
//            System.out.println(ex);
//        }
//    }
    public static void main(String[] args) {

    }
}

