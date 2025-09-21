package com.hamids.murick_internship_2025.service;

import com.hamids.murick_internship_2025.entity.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();
    private int idCounter = 1;

    public User createUser(User user) {
        user.setId(idCounter++);
        userMap.put(user.getId(), user);
        return user;
    }

    public Collection<User> getAllUsers() {
        return userMap.values();
    }

    public User getUserById(int id) {
        return userMap.get(id);
    }

    public User updateUser(int id, User updatedUser) {
        if (userMap.containsKey(id)) {
            updatedUser.setId(id);
            userMap.put(id, updatedUser);
            return updatedUser;
        }
        return null;
    }

    public boolean deleteUser(int id) {
        if (userMap.containsKey(id)) {
            userMap.remove(id);
            return true;
        }
        return false;
    }
}

