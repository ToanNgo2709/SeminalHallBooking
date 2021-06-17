package com.toanngo.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "active")
	private boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_role_id", nullable = false)
	private UserRole userRole;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userInfo")
	private Set<Booking> bookings = new HashSet<>();
	
	
}
