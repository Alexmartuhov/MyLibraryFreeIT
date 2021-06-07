package service;

import dao.entity.Author;
import dao.entity.Book;
import dao.entity.Genre;
import dao.impl.AuthorDaoImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;


public class Menu {

    public static int action() {
        Scanner sc = new Scanner(System.in);
        int action;
        System.out.println("______________________________________");
        System.out.println("Выберите одно из следующих действий:");
        System.out.println("1.Получить список книг в библиотеке");
        System.out.println("2.Добавить книгу в библиотеку");
        System.out.println("3.Редактировать книгу в библиотеке");
        System.out.println("4.Удалить книгу из библиотеки");
        System.out.println("5.Закончить работу с программой");
        System.out.print("Введите цифру-номер операции:");
        action = sc.nextInt();
        return action;
    }

    public static Book addBook() throws SQLException {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        Author author;
        System.out.println("Введите ID книги:");
        int id = sc.nextInt();
        System.out.println("Введите название книги:");
        String title = scString.nextLine();
        System.out.println("Введите один из жанров: " + Arrays.toString(Genre.values()));
        String genreString = scString.nextLine();
        Genre genre = Genre.valueOf(genreString);
        authorDao.getAuthorList();
        System.out.println("Введите Id автора (чтобы добавить нового автора введите 0):");
        int authorId = sc.nextInt();
        if (authorId == 0) {
            System.out.println("Введите ID автора:");
            authorId = sc.nextInt();
            System.out.println("Введите имя автора:");
            String firstName = scString.nextLine();
            System.out.println("Введите фамилию автора:");
            String secondName = scString.nextLine();
            author = new Author(authorId, firstName, secondName);
            authorDao.addAuthor(author);
        } else {
            author = authorDao.getAuthor(authorId);
        }
        Book book = new Book(id, title, genre, LocalDate.now(), author);
        return book;
    }

    public static Book editBook() {
        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        System.out.println("Введите ID книги:");
        int id = sc.nextInt();
        System.out.println("Введите новое название книги:");
        String title = scString.nextLine();
        System.out.println("Введите новый жанр: " + Arrays.toString(Genre.values()));
        String genreString = scString.nextLine();
        Genre genre = Genre.valueOf(genreString);
        Book book = new Book(id, title, genre);
        return book;
    }

    public static Book deleteBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID книги, которую хотите удалить:");
        int id = sc.nextInt();
        Book book = new Book(id);
        return book;
    }
}

