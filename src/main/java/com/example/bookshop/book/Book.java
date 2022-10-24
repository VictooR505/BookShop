package com.example.bookshop.book;

import com.example.bookshop.author.Author;
import com.example.bookshop.genre.Genre;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

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
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    private int price;
    private int count;


    public Book(Author author, String title, Genre genre, int price, int count) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && id.equals(book.id) && author.equals(book.author) && title.equals(book.title) && genre.equals(book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, genre, price);
    }
}
