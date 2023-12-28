package com.example.bookshop.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByLogin(String login);
    User findUserByEmail(String email);
    User findUserById(Long id);
    boolean existsUserByLogin(String login);
    boolean existsUserByEmail(String email);
    User findFirstByEmail(String email);
}
