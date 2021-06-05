import Service.Menu;
import dao.impl.AuthorDaoImpl;
import dao.impl.BookDaoImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        BookDaoImpl bookDao = new BookDaoImpl();
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        int action;
        do {
            action=menu.action();
            switch (action) {
                case (1):
                    bookDao.getBookList();
                    break;
                case (2):
                    bookDao.addBook(menu.addBook());
                    break;
                case (3):
                    bookDao.editBook(menu.editBook());
                    break;
                case (4):
                    bookDao.deleteBook(menu.deleteBook());
                    break;
            }
        } while (action != 5);
        System.out.println("Работа с библиотекой окончена");
    }
}
