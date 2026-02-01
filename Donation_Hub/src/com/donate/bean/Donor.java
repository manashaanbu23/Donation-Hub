package com.donate.bean;

public class Donor {
	private String donorID;   
    private String fullName;  
    private String email;    
    private String city; 
    private String mobile;
    private String status;    
    public Donor() {
    	
    }
    public Donor(String donorID, String fullName, String email, String mobile, String city, String status) {
        this.donorID = donorID;
        this.fullName = fullName;
        this.email = email;
        this.mobile = mobile;
        this.city = city;
        this.status = status;
    }
	public String getDonorID() {
		return donorID;
	}
	public void setDonorID(String donorID) {
		this.donorID = donorID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
