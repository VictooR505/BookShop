package com.example.bookshop.user.dto;

public class ChangeEmailDTO {
    private String email;
    private String password;
    private String newEmail;

    public ChangeEmailDTO(String email, String password, String newEmail) {
        this.email = email;
        this.password = password;
        this.newEmail = newEmail;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNewEmail() {
        return newEmail;
    }
}
