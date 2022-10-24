package com.example.bookshop.user;


import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    @Column(unique = true)
    private String email;
    @Min(0)
    private Integer cash;
    private boolean logged;

    public User(String login, String password, String email, Integer cash, boolean logged) {
        this.login = login;
        this.password = password;
        this.email = email;
        if(cash<0){
            throw new IllegalArgumentException("Cash cannot be negative");
        }
        this.cash = cash;
        this.logged = logged;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(cash, user.cash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, cash);
    }
}
