package com.uti.bankApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Payee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="payee_seq")
	@SequenceGenerator(name = "payee_seq", sequenceName = "payee_seq", initialValue = 1, allocationSize=1)
	private int id;
	@ManyToOne
	private User user;
	private long payeeUserId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPayeeUserId() {
		return payeeUserId;
	}
	public void setPayeeUserId(long payeeUserId) {
		this.payeeUserId = payeeUserId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	

}
