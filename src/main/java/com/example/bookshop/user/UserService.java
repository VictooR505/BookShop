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

    public User getUser(String login){
        if(userRepository.existsUserByLogin(login)){
            return userRepository.findUserByLogin(login);
        }
        return null;
    }

    public boolean loginUser(String login, String password) {
        if (userRepository.existsUserByLogin(login) && userRepository.findUserByLogin(login).getPassword().equals(password)) {
            userRepository.findUserByLogin(login).setLogged(true);
            userRepository.save(userRepository.findUserByLogin(login));
            return true;
        }else if(userRepository.findUserByLogin(login).getPassword().equals(password)){
            logger.info("Wrong password");
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
        if(userRepository.existsUserByLogin(login) && userRepository.findUserByLogin(login).isLogged()){
            userRepository.findUserByLogin(login).setCash(userRepository.findUserByLogin(login).getCash()+cash);
            userRepository.save(userRepository.findUserByLogin(login));
            return true;
        }else if(!userRepository.findUserByLogin(login).isLogged()){
            logger.info("User must be logged in");
            return false;
        }
        logger.info("User doesn't exist");
        return false;
    }

    public boolean changeLogin(String login, String password, String newLogin){
        if(userRepository.existsUserByLogin(login) && userRepository.findUserByLogin(login).getPassword().equals(password)){
           userRepository.findUserByLogin(login).setLogin(newLogin);
           userRepository.save(userRepository.findUserByLogin(login));
           return true;
        }else if(!userRepository.findUserByLogin(login).getPassword().equals(password)){
            logger.info("Wrong password");
            return false;
        }
        logger.info("User doesn't exist");
        return false;
    }

    public boolean changeEmail(String email, String password, String newEmail){
        if(userRepository.existsUserByEmail(email) && userRepository.findUserByEmail(email).getPassword().equals(password)){
            userRepository.findUserByEmail(email).setEmail(newEmail);
            userRepository.save(userRepository.findUserByEmail(email));
            return true;
        }else if((!userRepository.findUserByEmail(email).getPassword().equals(password))){
            logger.info("Wrong password");
        }
        logger.info("User doesn't exist");
        return false;
    }

}
