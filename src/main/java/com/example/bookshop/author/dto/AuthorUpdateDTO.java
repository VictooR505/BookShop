package com.example.bookshop.author.dto;

public class AuthorUpdateDTO {
    private String name;

    public AuthorUpdateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
