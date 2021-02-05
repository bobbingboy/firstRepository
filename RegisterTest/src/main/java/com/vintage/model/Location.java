package com.vintage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOCATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locatId;
	
	@Column(nullable = false, unique = true)
	private String locatName;
	
	@Column(nullable = false, unique = true)
	private String locatAddress;
	
	@Column(nullable = false)
	private String locatReserved;
	
	@Column(nullable = false)
	private String locatCapacity;
	
	@Column(nullable = false, unique = true)
	private String locatPhone;
	
	
	
//This entity is for manage all the location can held Activity
}
