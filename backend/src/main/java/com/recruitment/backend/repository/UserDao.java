package com.recruitment.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitment.backend.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	Optional<User> findUtilisateurById(int id);
	Optional<User> findUtilisateurByEmail(String email);
}