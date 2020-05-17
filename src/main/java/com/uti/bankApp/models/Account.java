package com.uti.bankApp.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="account_seq")
	@SequenceGenerator(name = "account_seq", sequenceName = "account_seq", initialValue = 1, allocationSize=1)
	@Column
	private int accntId;
	@Column(unique=true)
	private long accNumber;
	@Column
	private double accBalance;
	private String accountType;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
    public Account() {
    	
    }


	

	public int getAccntId() {
		return accntId;
	}

	public void setAccntId(int accntId) {
		this.accntId = accntId;
	}


	public Account(long accNumber, double accBalance, String accountType, User user) {
		super();
		this.accNumber = accNumber;
		this.accBalance = accBalance;
		this.accountType = accountType;
		this.user = user;
	}




	public long getAccNumber() {
		return accNumber;
	}


	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}


	public double getAccBalance() {
		return accBalance;
	}


	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Account [accNumber=" + accNumber + ", accBalance=" + accBalance + ", accountType=" + accountType
				+ ", user=" + user + "]";
	}
    
	
    
}
    