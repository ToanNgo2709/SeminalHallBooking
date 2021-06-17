package com.toanngo.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "active")
	private boolean active;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRole")
	private Set<UserInfo> userInfos = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRole")
	private Set<RoleAction> roleActions = new HashSet<>();
}
