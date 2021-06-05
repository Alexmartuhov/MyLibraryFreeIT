package dao.entity;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private Genre genre;
    private LocalDate dateCreated;
    private Author author;

    public Book(int id, String title, Genre genre, LocalDate dateCreated, Author author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.dateCreated = dateCreated;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ID:" + id + "; Название: " + title + "; Жанр: " + genre + "; Автор: " + author.getSecondName()+" Дата: "+dateCreated;
    }
}
