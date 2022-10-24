package com.example.bookshop.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {

    private final UserRepository userRepository;

    Logger logger = Logger.getLogger(getClass().getName());

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserByLogin(String login){
        if(userRepository.existsUserByLogin(login)){
            return userRepository.findUserByLogin(login);
        }
        logger.info("User doesn't exist");
        return null;
    }

    public boolean loginUser(String login, String password) {
        User user = userRepository.findUserByLogin(login);
        if (userRepository.existsUserByLogin(login) && user.getPassword().equals(password)) {
            user.setLogged(true);
            userRepository.save(user);
            return true;
        }else if(!user.getPassword().equals(password)){
            logger.info("Wrong password");
            return false;
        }
        logger.info("User doesn't exist");
        return false;
    }
    public boolean registerUser(User user){
        if(!userRepository.existsUserByLogin(user.getLogin())){
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean depositCash(String login, Integer cash){
        User user = userRepository.findUserByLogin(login);
        if(userRepository.existsUserByLogin(login) && user.isLogged()){
            user.setCash(user.getCash()+cash);
            userRepository.save(user);
            return true;
        }else if(!user.isLogged()){
            logger.info("User must be logged in");
            return false;
        }
        logger.info("User doesn't exist");
        return false;
    }

    public boolean changeLogin(String login, String password, String newLogin){
        User user = userRepository.findUserByLogin(login);
        if(userRepository.existsUserByLogin(login) && user.getPassword().equals(password)){
           user.setLogin(newLogin);
           userRepository.save(user);
           return true;
        }else if(!user.getPassword().equals(password)){
            logger.info("Wrong password");
            return false;
        }
        logger.info("User doesn't exist");
        return false;
    }

    public boolean changeEmail(String email, String password, String newEmail){
        User user = userRepository.findUserByEmail(email);
        if(userRepository.existsUserByEmail(email) && user.getPassword().equals(password)){
            user.setEmail(newEmail);
            userRepository.save(user);
            return true;
        }else if((!user.getPassword().equals(password))){
            logger.info("Wrong password");
        }
        logger.info("User doesn't exist");
        return false;
    }

}
