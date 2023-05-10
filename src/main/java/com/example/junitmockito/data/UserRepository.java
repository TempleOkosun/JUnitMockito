package com.example.junitmockito.data;

import com.example.junitmockito.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private Map<String, User> users = new HashMap<>();

    public UserRepository() {
        users.put("matt", User.createRegularUser("matt", "letmein"));
        users.put("frank", User.createRegularUser("frank", "pass"));
        users.put("suzzie", User.createRegularUser("suzzie", "go"));


        users.put("thomas", User.createAdminUser("thomas", "come"));
   }

   public List<User> findAll(){
        return new LinkedList<>(users.values());
   }


    public User findByUsername(String username) {
        return users.get(username);
    }
}
