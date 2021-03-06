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
@Table(name  = "user_action")
public class UserAction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "action_url")
	private String actionUrl;
	
	@Column(name = "action_link")
	private String actionLink;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userAction")
	private Set<RoleAction> roleActions = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public String getActionLink() {
		return actionLink;
	}

	public void setActionLink(String actionLink) {
		this.actionLink = actionLink;
	}

	public Set<RoleAction> getRoleActions() {
		return roleActions;
	}

	public void setRoleActions(Set<RoleAction> roleActions) {
		this.roleActions = roleActions;
	}
	
	
}
