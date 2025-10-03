package com.hamids.murick_internship_2025.user.service;

import com.hamids.murick_internship_2025.user.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO request);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(int id);
    UserDTO updateUser(int id, UserDTO request);
    void deleteUser(int id);
}

