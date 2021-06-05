import dao.entity.Author;
import dao.entity.Book;
import dao.entity.Library;

import java.time.LocalDate;
import java.util.*;

import static dao.entity.Genre.CLASSIC;
import static dao.entity.Genre.ROMANCE;

public class MainBeta {
    public static void main(String[] args) {
        Library library = new Library();
        Author dreiser = new Author(1, "Theodore", "Dreiser");
        Author bronte = new Author(2, "Charlotte", "Bronte");
        Book book1 = new Book(1, "Титан", CLASSIC,
                LocalDate.now(), dreiser);
        library.addBook(book1);
        Book book2 = new Book(2, "Финансист", CLASSIC,
                LocalDate.now(), dreiser);
        library.addBook(book2);
        Book book3 = new Book(3, "Джейн Эйр", ROMANCE,
                LocalDate.now(), bronte);
        library.addBook(book3);
        Book book4 = new Book(4, "Стоик", CLASSIC,
                LocalDate.now(), dreiser);
        library.addBook(book4);

        List<Book> booklist = library.getBookList();
        Collections.sort(booklist, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
        for (Book i : booklist) {
            System.out.println(i);
        }
        System.out.println("=========");
        library.deleteBook(4);

        booklist = library.getBookList();
        Collections.sort(booklist, (o1, o2) -> o1.getDateCreated().compareTo(o2.getDateCreated()));
        for (Book i : booklist) {
            System.out.println(i);
        }

        library.editBook(book1);

        System.out.println("=========");
        booklist = library.getBookList();
        for (Book i : booklist) {
            System.out.println(i);
        }
        System.out.println("=========");
        HashSet<Author> authorList = library.getAuthorList();
        for (Author i : authorList) {
            System.out.println(i);
        }
        System.out.println("=========");
        List<Book> authorBookList = library.getAuthorBookList(dreiser);
        for (Book i : authorBookList) {
            System.out.println(i);
        }
    }
}
