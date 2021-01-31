package com.vintage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Entity
@Data
public class UserReq {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty(value = "EMAIL")
	private String email;
	
	@JsonProperty(value = "PASSWORD")
	private String password;
	
	@JsonProperty(value = "FIRSTNAME")
	private String firstName;
	
	@JsonProperty(value = "LASTNAME")
	private String lastName;
}
