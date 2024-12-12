package com.mani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mani.entity.Role;
import com.mani.entity.User;
import com.mani.repository.RoleRepository;
import com.mani.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "User created successfully!";
    }

    @Override
    public String updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
            return "User updated successfully!";
        }
        return "User not found!";
    }

    @Override
    public String deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully!";
        }
        return "User not found!";
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
