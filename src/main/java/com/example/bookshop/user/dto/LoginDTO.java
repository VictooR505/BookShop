package com.example.bookshop.user.dto;

public class LoginDTO {
    private String login;
    private String password;

    public LoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
