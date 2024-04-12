package com.recruitment.backend.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.backend.model.User;
import com.recruitment.backend.repository.UserDao;
import com.recruitment.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	// ---------------------------- get all users ----------------------------
	@Override
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	// ---------------------------- get a user by their id ----------------------------
	@Override
	public User findUserById(int id) {
		return userDao.findUtilisateurById(id).orElse(null);
	}
	
	// ---------------------------- add a user ----------------------------
	
	@Override
	public User addUser(User user) {
//		if(user.getUserPassword() != null) {
//			String hashedPassword = passwordEncoder.encode(user.getUserPassword());
//			user.setUserPassword(hashedPassword);
//		}
		return userDao.save(user);
	}
	
	// ---------------------------- update a user ----------------------------
	@Override
	public User updateUser(User user) {
//		if(user.getUserPassword() != null) {
//			String hashedPassword = passwordEncoder.encode(user.getUserPassword());
//			user.setUserPassword(hashedPassword);
//		}
		return userDao.save(user);
	}
	
	// ---------------------------- delete a user ----------------------------
	@Override
	public void deleteUser(int id) {
		userDao.deleteById(id);
	}
	
}
