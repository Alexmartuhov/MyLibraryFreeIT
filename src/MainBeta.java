import dao.entity.Author;
import dao.entity.Book;
import dao.impl.AuthorDaoImpl;
import dao.impl.BookDaoImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import static dao.entity.Genre.CLASSIC;
import static dao.entity.Genre.ROMANCE;

public class MainBeta {
    public static void main(String[] args) throws SQLException {
        BookDaoImpl bookDao = new BookDaoImpl();
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        Author dreiser = new Author(1, "Theodore", "Dreiser");
        Author bronte = new Author(2, "Charlotte", "Bronte");
        Book book1 = new Book(1, "Титан", CLASSIC,
                LocalDate.now(), dreiser);
        bookDao.addBook(book1);
        Book book2 = new Book(2, "Финансист", CLASSIC,
                LocalDate.now(), dreiser);
        bookDao.addBook(book2);
        Book book3 = new Book(3, "Джейн Эйр", ROMANCE,
                LocalDate.now(), bronte);
        bookDao.addBook(book3);
        Book book4 = new Book(4, "Стоик", CLASSIC,
                LocalDate.now(), dreiser);
        bookDao.addBook(book4);
        authorDao.addAuthor(dreiser);
        authorDao.addAuthor(bronte);

        List<Book> booklist = bookDao.getBookList();
        System.out.println("=========");
        booklist.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
        for (Book i : booklist) {
            System.out.println(i);
        }
        System.out.println("=========");
        bookDao.deleteBook(book4);

        booklist = bookDao.getBookList();
        System.out.println("=========");
        booklist.sort((o1, o2) -> o1.getDateCreated().compareTo(o2.getDateCreated()));
        for (Book i : booklist) {
            System.out.println(i);
        }

        Book bookEdit=new Book(1, "Американская трагедия", CLASSIC);
        bookDao.editBook(bookEdit);

        System.out.println("=========");
        bookDao.getBookList();

        System.out.println("=========");
        authorDao.getAuthorList();

        System.out.println("=========");
        bookDao.getAuthorBookList(dreiser);
    }
}
