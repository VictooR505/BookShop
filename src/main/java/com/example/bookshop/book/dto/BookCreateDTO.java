package com.example.bookshop.book.dto;

public class BookCreateDTO {
    private Long author;
    private String title;
    private Long genre;
    private int price;
    private int count;

    public BookCreateDTO() {
    }

    public BookCreateDTO(Long author, String title, Long genre, int price, int count) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.count = count;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getGenre() {
        return genre;
    }

    public void setGenre(Long genre) {
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
