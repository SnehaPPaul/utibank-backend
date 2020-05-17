package com.uti.bankApp.models.dto;

public class PayeeRequestDTO {
	
	private String payeeEmailId;
	private String payeeFirstName;
	private String payeeLastName;
	private long userId;
	
	
	public String getPayeeEmailId() {
		return payeeEmailId;
	}
	public void setPayeeEmailId(String payeeEmailId) {
		this.payeeEmailId = payeeEmailId;
	}
	public String getPayeeFirstName() {
		return payeeFirstName;
	}
	public void setPayeeFirstName(String payeeFirstName) {
		this.payeeFirstName = payeeFirstName;
	}
	public String getPayeeLastName() {
		return payeeLastName;
	}
	public void setPayeeLastName(String payeeLastName) {
		this.payeeLastName = payeeLastName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

}
