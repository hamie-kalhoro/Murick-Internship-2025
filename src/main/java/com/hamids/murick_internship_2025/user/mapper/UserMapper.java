package com.hamids.murick_internship_2025.user.mapper;

import com.hamids.murick_internship_2025.user.dto.UserDTO;
import com.hamids.murick_internship_2025.user.entity.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        if (user == null) return null;
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User toEntity(UserDTO request) {
        if (request == null) return null;
        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public static void updateEntity(User user, UserDTO request) {
        if (user != null && request != null) {
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
        }
    }
}
