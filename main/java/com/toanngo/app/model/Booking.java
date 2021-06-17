package com.toanngo.app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private UserInfo userInfo;
	
	@Column(name = "from_date")
	private Date fromDate;
	
	@Column(name = "to_date")
	private Date toDate;
	
	@Column(name = "session_info")
	private String session;
	
	@Column(name = "approval_number")
	private String approvalNumber;
	
	@Column(name = "approval_date")
	private Date approvalDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SeminarHall hall;
	
	@Column(name = "purpose")
	private String purpose;
	
	@Column(name = "number_of_person")
	private int numberOfPerson;
	
	@Column(name = "approve_status")
	private boolean approveStatus;
	
}
