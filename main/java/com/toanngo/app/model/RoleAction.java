package com.toanngo.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role_action")
public class RoleAction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private UserRole userRole;
	
	
	@ManyToOne
	@JoinColumn(name = "action_id")
	private UserAction userAction;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public UserRole getUserRole() {
		return userRole;
	}


	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}


	public UserAction getUserAction() {
		return userAction;
	}


	public void setUserAction(UserAction userAction) {
		this.userAction = userAction;
	}
	
	
}
