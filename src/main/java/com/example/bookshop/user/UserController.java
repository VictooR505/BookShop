package com.example.bookshop.user;

import com.example.bookshop.user.dto.CashDTO;
import com.example.bookshop.user.dto.ChangeEmailDTO;
import com.example.bookshop.user.dto.ChangeLoginDTO;
import com.example.bookshop.user.dto.LoginDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    Logger logger = Logger.getLogger(getClass().getName());

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{login}")
    public User getUser(@PathVariable String login){
        return userService.getUser(login);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        if(userService.registerUser(user)){
            logger.info("User has been registered");
        }else {
            logger.info("User is already registered");
        }
    }

    @PatchMapping("/login")
    public void loginUser(@RequestBody LoginDTO loginDTO){
        if(userService.loginUser(loginDTO.getLogin(), loginDTO.getPassword())){
            logger.info("User logged in");
        }else{
            logger.info("Login failed");
        }
    }

    @PatchMapping("/change/login")
    public void changeLogin(@RequestBody ChangeLoginDTO changeLoginDTO){
        if(userService.changeLogin(changeLoginDTO.getLogin(), changeLoginDTO.getPassword(), changeLoginDTO.getNewLogin())){
            logger.info("Login has been changed");
        }else{
            logger.info("Update failed");
        }
    }

    @PatchMapping("/change/email")
    public void changeEmail(@RequestBody ChangeEmailDTO changeEmailDTO){
        if(userService.changeEmail(changeEmailDTO.getEmail(), changeEmailDTO.getPassword(), changeEmailDTO.getNewEmail())){
            logger.info("Email has been changed");
        }else{
            logger.info("Update failed");
        }
    }

    @PatchMapping("/deposit")
    public void depositCash(@RequestBody CashDTO cashDTO){
        if(userService.depositCash(cashDTO.getLogin(), cashDTO.getCash())){
            logger.info("Cash has been deposited");
        }else{
            logger.info("Cash deposit failed");
        }
    }
}
