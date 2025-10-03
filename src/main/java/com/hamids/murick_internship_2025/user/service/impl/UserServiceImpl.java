package com.hamids.murick_internship_2025.user.service.impl;

import com.hamids.murick_internship_2025.exception.EmailAlreadyExistsException;
import com.hamids.murick_internship_2025.user.entity.User;
import com.hamids.murick_internship_2025.user.dto.UserDTO;
import com.hamids.murick_internship_2025.user.mapper.UserMapper;
import com.hamids.murick_internship_2025.user.repository.UserRepository;
import com.hamids.murick_internship_2025.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserDTO createUser(UserDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists!");
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

    public UserDTO updateUser(int id, UserDTO request) {
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

