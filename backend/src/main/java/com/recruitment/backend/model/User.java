package com.recruitment.backend.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Utilisateur")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6244618243056238632L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String pwd;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String last_name;
	
	// Constructors
	public User() {}
	
	public User(String email, String pwd, String name, String last_name) {
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.last_name = last_name;
	}
	
	// Getters
	public int getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	// Overriden methods
	@Override
	public String toString() {
		return "User{" + 
				"id = " + id +
				", name = " + name +
				", last name = " + last_name +
				", email = " + email +
				", pwd = " + pwd +
				"}";
	}

}
