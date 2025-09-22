package com.hamids.murick_internship_2025.mapper;

import com.hamids.murick_internship_2025.dto.UserDTO;
import com.hamids.murick_internship_2025.dto.UserRequestDTO;
import com.hamids.murick_internship_2025.entity.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        if (user == null) return null;
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public static User toEntity(UserRequestDTO request) {
        if (request == null) return null;
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public static void updateEntity(User user, UserRequestDTO request) {
        if (user != null && request != null) {
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
        }
    }
}

