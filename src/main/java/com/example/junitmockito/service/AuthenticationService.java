package com.example.junitmockito.service;

import com.example.junitmockito.User;
import com.example.junitmockito.data.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class Autrhentication {
    private UserRepository userRepository;

    public Autrhentication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean authenticate(String username, String password){
        User user = userRepository.findByUsername(username);
        return user.getPassword().equals(password);
    }

    public Set<User> getRegularUsers(){
        return userRepository.findAll().stream().filter(user -> user.isLive() && user.getUserType() == User.UserType.REGULAR_USER).collect(Collectors.toSet());
    }
}
