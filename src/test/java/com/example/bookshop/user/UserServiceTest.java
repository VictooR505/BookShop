package com.example.bookshop.user;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @AfterEach
    void cleanUp(){
        userRepository.deleteAll();
    }

    @Test
    void getUsersTest(){
        //given
        User givenUser = new User("login", "pass", "email", 10, false);
        userRepository.save(givenUser);
        User givenUser2 = new User("login2", "pass2", "email2", 10, false);
        userRepository.save(givenUser2);
        //when
        List<User> foundUsers = userService.getUsers();
        //then
        assertEquals(2,foundUsers.size());
    }

    @Test
    void getUserByLoginTest(){
        //when
        User givenUser = new User("login2", "pass", "email", 10, false);
        userRepository.save(givenUser);
        //when
        User foundUser = userService.getUserByLogin(givenUser.getLogin());
        //then
        assertEquals(givenUser, foundUser);
    }

    @Test
    void loginUserWithCorrectPasswordTest(){
        //given
        User givenUser = new User("login2", "pass", "email", 10, false);
        userRepository.save(givenUser);
        //when
        userService.loginUser(givenUser.getLogin(), givenUser.getPassword());
        User user = userService.getUserByLogin(givenUser.getLogin());
        //then
        assertEquals(true, user.isLogged());
    }

    @Test
    void loginUserWithIncorrectPasswordTest(){
        //given
        User givenUser = new User("login2", "pass", "email", 10, false);
        userRepository.save(givenUser);
        //when
        userService.loginUser(givenUser.getLogin(), "wrongPass");
        User user = userService.getUserByLogin(givenUser.getLogin());
        //then
        assertEquals(false, user.isLogged());
    }

    @Test
    void registerUserTest(){
        //given
        User givenUser = new User("login2", "pass", "email", 10, false);
        //when
        userService.registerUser(givenUser);
        User actualUser = userService.getUserByLogin(givenUser.getLogin());
        //then
        assertEquals(givenUser, actualUser);
    }

    @Test
    void depositCashTest(){
        //given
        User givenUser = new User("login2", "pass", "email", 10, true);
        userRepository.save(givenUser);
        //when
        userService.depositCash(givenUser.getLogin(), 20);
        User user = userService.getUserByLogin(givenUser.getLogin());
        //then
        assertEquals(30, user.getCash());
    }

    @Test
    void changeLoginWithCorrectPasswordTest(){
        //given
        User givenUser = new User("login2", "pass", "email", 10, false);
        userRepository.save(givenUser);
        //when
        userService.changeLogin(givenUser.getLogin(), givenUser.getPassword(), "newLogin");
        User user = userService.getUserByLogin("newLogin");
        //then
        assertEquals("newLogin", user.getLogin());
    }

    @Test
    void changeLoginWithIncorrectPasswordTest(){
        //given
        User givenUser = new User("login2", "pass", "email", 10, false);
        userRepository.save(givenUser);
        //when
        userService.changeLogin(givenUser.getLogin(), "wrongPass", "newLogin");
        User user = userService.getUserByLogin("login2");
        //then
        assertEquals("login2", user.getLogin());
    }

    @Test
    void changeEmailWithCorrectPasswordTest(){
        //given
        User givenUser = new User("login2", "pass", "email", 10, false);
        userRepository.save(givenUser);
        //when
        userService.changeEmail(givenUser.getEmail(), givenUser.getPassword(), "newEmail");
        User user = userService.getUserByLogin(givenUser.getLogin());
        //then
        assertEquals("newEmail", user.getEmail());
    }

    @Test
    void changeEmailWithIncorrectPasswordTest(){
        //given
        User givenUser = new User("login2", "pass", "email", 10, false);
        userRepository.save(givenUser);
        //when
        userService.changeEmail(givenUser.getEmail(), "wrongPass", "newEmail");
        User user = userService.getUserByLogin(givenUser.getLogin());
        //then
        assertEquals("email", user.getEmail());
    }

}
