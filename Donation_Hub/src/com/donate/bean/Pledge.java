package com.donate.bean;

import java.math.BigDecimal;
import java.sql.Date;

public class Pledge {
    private int pledgeID;         
    private String donorID;         
    private String campaignID;        
    private Date pledgeDate;          
    private BigDecimal pledgeAmount; 
    private BigDecimal amountPaid;    
    private String paymentStatus;    
    private String writeoffFlag;    
    public Pledge() {
    	
    }
    public Pledge(int pledgeID, String donorID, String campaignID, Date pledgeDate, BigDecimal pledgeAmount, BigDecimal amountPaid, String paymentStatus, String writeoffFlag) {
        this.pledgeID = pledgeID;
        this.donorID = donorID;
        this.campaignID = campaignID;
        this.pledgeDate = pledgeDate;
        this.pledgeAmount = pledgeAmount;
        this.amountPaid = amountPaid;
        this.paymentStatus = paymentStatus;
        this.writeoffFlag = writeoffFlag;
    }
	public int getPledgeID() {
		return pledgeID;
	}
	public void setPledgeID(int pledgeID) {
		this.pledgeID = pledgeID;
	}
	public String getDonorID() {
		return donorID;
	}
	public void setDonorID(String donorID) {
		this.donorID = donorID;
	}
	public String getCampaignID() {
		return campaignID;
	}
	public void setCampaignID(String campaignID) {
		this.campaignID = campaignID;
	}
	public Date getPledgeDate() {
		return pledgeDate;
	}
	public void setPledgeDate(Date pledgeDate) {
		this.pledgeDate = pledgeDate;
	}
	public BigDecimal getPledgeAmount() {
		return pledgeAmount;
	}
	public void setPledgeAmount(BigDecimal pledgeAmount) {
		this.pledgeAmount = pledgeAmount;
	}
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getWriteoffFlag() {
		return writeoffFlag;
	}
	public void setWriteoffFlag(String writeoffFlag) {
		this.writeoffFlag = writeoffFlag;
	}
    
}
