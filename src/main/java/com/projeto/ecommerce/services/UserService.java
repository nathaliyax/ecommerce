package com.projeto.ecommerce.services;

import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    public com.projeto.ecommerce.entities.UserService saveUser(String name, String email, String path){
        com.projeto.ecommerce.entities.UserService user = new com.projeto.ecommerce.entities.UserService();
        user.setName(name);
        user.setEmail(email);
        user.setPhoto(path);

        return userRepository.save(user);
    }

}
