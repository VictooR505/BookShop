package com.example.bookshop.security;

import com.example.bookshop.user.User;
import com.example.bookshop.user.UserRepository;
import com.example.bookshop.user.dto.SignupDTO;
import com.example.bookshop.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(SignupDTO signupDTO) {
        User user = new User();
        user.setLogin(signupDTO.getName());
        user.setEmail(signupDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setName(createdUser.getLogin());
        return userDTO;
    }
}
