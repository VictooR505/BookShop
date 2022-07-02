package com.example.bookshop.user.dto;

public class ChangeLoginDTO {
    private String login;
    private String password;
    private String newLogin;

    public ChangeLoginDTO(String login, String password, String newLogin) {
        this.login = login;
        this.password = password;
        this.newLogin = newLogin;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNewLogin() {
        return newLogin;
    }
}
