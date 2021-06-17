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
@Table(name = "seminar_hall")
public class SeminarHall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "incharge")
	private double inchare;
	
	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "active")
	private boolean active;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hall")
	private Set<Booking> bookings = new HashSet<>(); 
}
