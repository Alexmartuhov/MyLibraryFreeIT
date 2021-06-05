package dao.entity;

import java.util.*;

public class Library {
    public List<Book> bookList = new ArrayList<>();
    public HashSet<Author> authorList = new HashSet<>();
    private Genre genre;


    public void addBook(Book book) {
        int count = 0;
        for (Book i : bookList) {
            if (book.getId() == i.getId()) {
                count++;
                break;
            }
        }
        if (count == 0) {
            bookList.add(book);
            authorList.add(book.getAuthor());
        }
    }


    public List<Book> getBookList() {
        return bookList;
    }

    public HashSet<Author> getAuthorList() {
        return authorList;
    }

    public List<Book> getAuthorBookList(Author author) {
        List<Book> authorBookList = new ArrayList<>();
        for (Book i : bookList) {
            if (author == i.getAuthor()) {
                authorBookList.add(i);
            }
        }
        return authorBookList;
    }

    public void deleteBook(int id) {
        Book delete = null;
        for (Book i : bookList) {
            if (i.getId() == id) {
                delete = i;
                bookList.remove(i);
                break;
            }
        }
        int count = 0;
        for (Book i : bookList) {
            if (delete.getAuthor() == i.getAuthor()) {
                count++;
            }
        }
        if (count == 0) {
            authorList.remove(delete.getAuthor());
        }
    }

    public void editBook(Book book) {
        bookList.remove(book);
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Введите новый id:");
        int id = sc.nextInt();
        book.setId(id);
        System.out.println("Введите новое название:");
        String title = sc2.nextLine();
        book.setTitle(title);
        System.out.println("Введите один из следующих жанров: " + Arrays.toString(Genre.values()));
        String genre = sc.next();
        book.setGenre(Genre.valueOf(genre));
        bookList.add(book);

    }
}
