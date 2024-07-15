package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Login {
	
	@Id
	private String email;
	private String password;
}
