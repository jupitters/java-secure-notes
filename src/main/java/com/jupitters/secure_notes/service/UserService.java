package com.jupitters.secure_notes.service;

import com.jupitters.secure_notes.dto.UserDTO;
import com.jupitters.secure_notes.models.User;

import java.util.List;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);

    User findByUsername(String username);
}
