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
@Table(name = "ACTIVITYINFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actId;
	
	@Column(nullable = false, unique = true)
	private String actName;
	
	@Column(nullable = false)
	private String actHost;
	
	@Column(nullable = false)
	private String actStartDate;
	
//	@Column(nullable = false)
//	private String actEndDate;
	
//	@Column(nullable = false)
//	private String actOpentime;
	
	@Column(nullable = false)
	private String actLocation;
	
	@Column(nullable = false)
	private String actIntro;
	
	@Column(nullable = false)
	private String actPhone;
	
//	@Column(nullable = true)
//	private String actAttendee;
	
	
	
}
