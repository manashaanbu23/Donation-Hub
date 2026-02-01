package com.donate.bean;
import java.math.BigDecimal;
import java.sql.Date;

public class Campaign {
	   private String campaignID;         
	    private String campaignName;       
	    private Date startDate;          
	    private Date endDate;             
	    private BigDecimal targetAmount;  
	    private String status;  
	    public Campaign() {
	    	
	    }
	    public String getCampaignID() {
			return campaignID;
		}
		public void setCampaignID(String campaignID) {
			this.campaignID = campaignID;
		}
		public String getCampaignName() {
			return campaignName;
		}
		public void setCampaignName(String campaignName) {
			this.campaignName = campaignName;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public BigDecimal getTargetAmount() {
			return targetAmount;
		}
		public void setTargetAmount(BigDecimal targetAmount) {
			this.targetAmount = targetAmount;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Campaign(String campaignID, String campaignName, Date startDate, Date endDate, BigDecimal targetAmount, String status) {
	        this.campaignID = campaignID;
	        this.campaignName = campaignName;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.targetAmount = targetAmount;
	        this.status = status;
	    }
}
