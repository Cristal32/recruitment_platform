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
	
	
	//constructors
	public User() {}
	
	public User(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}

	public String getEmail() {
		return email;
	}
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//methods
	@Override
	public String toString() {
		return "User{" + 
				"id = " + id +
				", email = " + email +
				", pwd = " + pwd +
				"}";
	}

}
