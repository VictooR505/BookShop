package com.example.bookshop.book;

import com.example.bookshop.author.Author;
import com.example.bookshop.genre.Genre;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;
    private String title;
    @ManyToOne()
    @JoinColumn(name = "genre_id")
    private Genre genre;
    private int price;


    public Book(Author author, String title, Genre genre, int price) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
