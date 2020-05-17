package com.uti.bankApp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="transaction_seq")
	@SequenceGenerator(name = "transaction_seq", sequenceName = "transaction_seq", initialValue = 1, allocationSize=1)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	private int accntIdTo;
	private int accntIdFrom;
	private double amount;
	private long userId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getAccntIdTo() {
		return accntIdTo;
	}
	public void setAccntIdTo(int accntIdTo) {
		this.accntIdTo = accntIdTo;
	}
	public int getAccntIdFrom() {
		return accntIdFrom;
	}
	public void setAccntIdFrom(int accntIdFrom) {
		this.accntIdFrom = accntIdFrom;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
}
