package com.hamids.murick_internship_2025.service.impl;

import com.hamids.murick_internship_2025.dto.UserRequestDTO;
import com.hamids.murick_internship_2025.entity.User;
import com.hamids.murick_internship_2025.dto.UserDTO;
import com.hamids.murick_internship_2025.mapper.UserMapper;
import com.hamids.murick_internship_2025.repository.UserRepository;
import com.hamids.murick_internship_2025.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserRequestDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }
        User user = UserMapper.toEntity(request);
        User saved = userRepository.save(user);
        return UserMapper.toDTO(saved);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDTO(user);
    }

    public UserDTO updateUser(int id, UserRequestDTO request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserMapper.updateEntity(user, request);
        User updated = userRepository.save(user);
        return UserMapper.toDTO(updated);
    }

    public void deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}

