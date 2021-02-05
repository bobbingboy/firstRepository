package com.vintage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "UserInfo")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	@Column(nullable = false, length = 20)
	private String firstName;
	
	@Column(nullable = false, length = 20)
	private String lastName;
	
//	@Column(nullable = true, length = 11)
//	private String birthday;
//	
//	@Column(nullable = true, length = 10)
//	private String phone;
//	
//	@Column(nullable = true, length = 5)
//	private String gender;
//	
//	@Column(nullable = true, length = 10)
//	private String roles;
}
