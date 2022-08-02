package com.example.bookshop.book.dto;

import com.example.bookshop.author.Author;
import com.example.bookshop.genre.Genre;

public class BookUpdateDTO {
    private Author author;
    private String title;
    private Genre genre;
    private int price;
    private int count;

    public BookUpdateDTO(Author author, String title, Genre genre, int price, int count) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.count = count;
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
}
