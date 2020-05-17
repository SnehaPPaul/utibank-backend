package com.uti.bankApp.models.dto;

public class TransferDTO {
	
	private int accountIdFrom;
	private int accountIdTo;
	private double money;
	private int userId;
	
	
	public int getAccountIdFrom() {
		return accountIdFrom;
	}
	public void setAccountIdFrom(int accountIdFrom) {
		this.accountIdFrom = accountIdFrom;
	}
	public int getAccountIdTo() {
		return accountIdTo;
	}
	public void setAccountIdTo(int accountIdTo) {
		this.accountIdTo = accountIdTo;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	

}
