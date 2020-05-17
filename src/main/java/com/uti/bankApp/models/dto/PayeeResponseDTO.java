package com.uti.bankApp.models.dto;

public class PayeeResponseDTO {
	
	private int accntId;
	private String accNumber;
	private String emailId;
	private String firstName;
	private String lastName;
	
	
	public int getAccntId() {
		return accntId;
	}
	public void setAccntId(int accntId) {
		this.accntId = accntId;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	

}
