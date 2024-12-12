package com.mani.service;

import com.mani.entity.User;

import java.util.List;

public interface UserService {
	String createUser(User user);

	String updateUser(Long id, User user);

	String deleteUser(Long id);

	User getUserById(Long id);

	List<User> getAllUsers();
}