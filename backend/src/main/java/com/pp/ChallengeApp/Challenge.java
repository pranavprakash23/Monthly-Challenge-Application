package com.pp.ChallengeApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Challenge {
	
	public Challenge() {
	}

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public Challenge(Long id, String month, String description) {
		super();
		this.id = id;
		this.month = month;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
