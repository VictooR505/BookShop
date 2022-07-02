package com.example.bookshop.user.dto;

public class CashDTO {
    private String login;
    private Integer cash;

    public CashDTO(String login, Integer cash) {
        this.login = login;
        this.cash = cash;
    }

    public String getLogin() {
        return login;
    }

    public Integer getCash() {
        return cash;
    }
}
