package com.hamids.murick_internship_2025.service;

import com.hamids.murick_internship_2025.dto.UserDTO;
import com.hamids.murick_internship_2025.dto.UserRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserRequestDTO request);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(int id);
    UserDTO updateUser(int id, UserRequestDTO request);
    void deleteUser(int id);
}

