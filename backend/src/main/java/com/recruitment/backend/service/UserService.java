package com.recruitment.backend.service;

import java.util.List;

import com.recruitment.backend.model.User;


public interface UserService {
	public List<User> getAllUsers();
	public User findUserById(int id);
	public User addUser(User user);
	public User updateUser(User user);
	public void deleteUser(int id);
}
