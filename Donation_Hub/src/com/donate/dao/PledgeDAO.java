package com.donate.dao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.donate.bean.Pledge;
import com.donate.util.DBUtil;

public class PledgeDAO {
	public int generatePledgeID() {
	    int pledgeID = 0;
	    Connection con = DBUtil.getDBConnection();
	    String sql = "SELECT pledge_seq.NEXTVAL FROM dual";
	    try {
	    	PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            pledgeID = rs.getInt(1);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0;
	    }
	    return pledgeID;
	}
	public boolean insertPledge(Pledge pledge) {
		Connection con = DBUtil.getDBConnection();
	    String sql = "INSERT INTO PLEDGE_TBL VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    try{
	         PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, pledge.getPledgeID());
	        ps.setString(2, pledge.getDonorID());
	        ps.setString(3, pledge.getCampaignID());
	        ps.setDate(4, pledge.getPledgeDate());
	        ps.setBigDecimal(5, pledge.getPledgeAmount());
	        ps.setBigDecimal(6, pledge.getAmountPaid());
	        ps.setString(7, pledge.getPaymentStatus());
	        ps.setString(8, pledge.getWriteoffFlag());

	        int rows = ps.executeUpdate();
	        return(rows > 0);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	public boolean updatePledgePayment(int pledgeID, BigDecimal newAmountPaid,String newPaymentStatus) {
		Connection con = DBUtil.getDBConnection();
        String sql = "UPDATE PLEDGE_TBL "+ "SET AMOUNT_PAID = ?, PAYMENT_STATUS = ? "+ "WHERE PLEDGE_ID = ?";
        try{
        	
	        PreparedStatement ps = con.prepareStatement(sql);
            ps.setBigDecimal(1, newAmountPaid);
            ps.setString(2, newPaymentStatus);
            ps.setInt(3, pledgeID);
            int rows = ps.executeUpdate();
            return(rows > 0);
            } catch (SQLException e) {
               e.printStackTrace();
               return false;
            }
        }
	public Pledge findPledge(int pledgeID) {
	    Pledge pledge = null;
	    Connection con = DBUtil.getDBConnection();
	    String sql = "SELECT * FROM PLEDGE_TBL WHERE PLEDGE_ID = ?";
	    try{
	    	  PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, pledgeID);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            pledge = new Pledge();
	            pledge.setPledgeID(rs.getInt("PLEDGE_ID"));
	            pledge.setDonorID(rs.getString("DONOR_ID"));
	            pledge.setCampaignID(rs.getString("CAMPAIGN_ID"));
	            pledge.setPledgeDate(rs.getDate("PLEDGE_DATE"));
	            pledge.setPledgeAmount(rs.getBigDecimal("PLEDGE_AMOUNT"));
	            pledge.setAmountPaid(rs.getBigDecimal("AMOUNT_PAID"));
	            pledge.setPaymentStatus(rs.getString("PAYMENT_STATUS"));
	            pledge.setWriteoffFlag(rs.getString("WRITEOFF_FLAG"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	    return pledge;
	}
	public List<Pledge> findPledgesByDonor(String donorID) {
	    List<Pledge> pledges = new java.util.ArrayList<>();
	    Connection conn = DBUtil.getDBConnection();
	    String sql = "SELECT * FROM PLEDGE_TBL WHERE DONOR_ID = ?";
	    try{
	    	PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, donorID); 
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Pledge pledge = new Pledge();
	            pledge.setPledgeID(rs.getInt("PLEDGE_ID"));
	            pledge.setDonorID(rs.getString("DONOR_ID"));
	            pledge.setCampaignID(rs.getString("CAMPAIGN_ID"));
	            pledge.setPledgeDate(rs.getDate("PLEDGE_DATE"));
	            pledge.setPledgeAmount(rs.getBigDecimal("PLEDGE_AMOUNT"));
	            pledge.setAmountPaid(rs.getBigDecimal("AMOUNT_PAID"));
	            pledge.setPaymentStatus(rs.getString("PAYMENT_STATUS"));
	            pledge.setWriteoffFlag(rs.getString("WRITEOFF_FLAG"));
	            pledges.add(pledge);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return pledges;
	}
	public List<Pledge> findPledgesByCampaign(String campaignID) {
	    List<Pledge> pledges = new ArrayList<>();
	    Connection conn = DBUtil.getDBConnection();
	    String sql = "SELECT * FROM PLEDGE_TBL WHERE CAMPAIGN_ID = ?";

	    try{
	    	PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, campaignID);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Pledge pledge = new Pledge();
	            pledge.setPledgeID(rs.getInt("PLEDGE_ID"));
	            pledge.setDonorID(rs.getString("DONOR_ID"));
	            pledge.setCampaignID(rs.getString("CAMPAIGN_ID"));
	            pledge.setPledgeDate(rs.getDate("PLEDGE_DATE"));
	            pledge.setPledgeAmount(rs.getBigDecimal("PLEDGE_AMOUNT"));
	            pledge.setAmountPaid(rs.getBigDecimal("AMOUNT_PAID"));
	            pledge.setPaymentStatus(rs.getString("PAYMENT_STATUS"));
	            pledge.setWriteoffFlag(rs.getString("WRITEOFF_FLAG"));
	            pledges.add(pledge);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return pledges;
	}
	public List<Pledge> findActivePledgesForDonor(String donorID) {
	    List<Pledge> pledges = new java.util.ArrayList<>();
	    String sql = "SELECT * FROM PLEDGE_TBL " + "WHERE DONOR_ID = ? " + "AND WRITEOFF_FLAG = ? " + "AND (PAYMENT_STATUS = ? OR PAYMENT_STATUS = ?)";
	    Connection conn = DBUtil.getDBConnection();
	    try{
	    	 PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, donorID);
			ps.setString(3,"NOT_PAID");
			ps.setString(4,"PARTIALLY_PAID");
			ps.setString(2,"NO");
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Pledge pledge = new Pledge();
	            pledge.setPledgeID(rs.getInt("PLEDGE_ID"));
	            pledge.setDonorID(rs.getString("DONOR_ID"));
	            pledge.setCampaignID(rs.getString("CAMPAIGN_ID"));
	            pledge.setPledgeDate(rs.getDate("PLEDGE_DATE"));
	            pledge.setPledgeAmount(rs.getBigDecimal("PLEDGE_AMOUNT"));
	            pledge.setAmountPaid(rs.getBigDecimal("AMOUNT_PAID"));
	            pledge.setPaymentStatus(rs.getString("PAYMENT_STATUS"));
	            pledge.setWriteoffFlag(rs.getString("WRITEOFF_FLAG"));
	            pledges.add(pledge);
	        }
	    
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	    return pledges;
	}
	public List<Pledge> findActivePledgesForCampaign(String campaignID) {
	    List<Pledge> pledges = new ArrayList<>();
	    String sql = "SELECT * FROM PLEDGE_TBL " + "WHERE CAMPAIGN_ID = ? " + "AND WRITEOFF_FLAG = ? " + "AND (PAYMENT_STATUS = ? OR PAYMENT_STATUS = ?)";
	    Connection conn = DBUtil.getDBConnection();
	    try{
	    	 PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, campaignID);
	        ps.setString(4,"NOT_PAID");
			ps.setString(3,"PARTIALLY_PAID");
			ps.setString(2,"NO");
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Pledge pledge = new Pledge();
	            pledge.setPledgeID(rs.getInt("PLEDGE_ID"));
	            pledge.setDonorID(rs.getString("DONOR_ID"));
	            pledge.setCampaignID(rs.getString("CAMPAIGN_ID"));
	            pledge.setPledgeDate(rs.getDate("PLEDGE_DATE"));
	            pledge.setPledgeAmount(rs.getBigDecimal("PLEDGE_AMOUNT"));
	            pledge.setAmountPaid(rs.getBigDecimal("AMOUNT_PAID"));
	            pledge.setPaymentStatus(rs.getString("PAYMENT_STATUS"));
	            pledge.setWriteoffFlag(rs.getString("WRITEOFF_FLAG"));
	            pledges.add(pledge);
	        }
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	    return pledges;
	}

}
