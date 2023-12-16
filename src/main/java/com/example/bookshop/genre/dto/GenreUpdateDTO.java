package com.example.bookshop.genre.dto;

public class GenreUpdateDTO {

    private String name;

    public GenreUpdateDTO(String name) {
        this.name = name;
    }

    public GenreUpdateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
