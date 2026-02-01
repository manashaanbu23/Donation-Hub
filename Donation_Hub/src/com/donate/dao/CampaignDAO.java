package com.donate.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.donate.bean.Campaign;
import com.donate.util.DBUtil;
public class CampaignDAO {
    public Campaign findCampaign(String campaignID) {

        Campaign campaign = new Campaign();
        String sql = "SELECT * FROM CAMPAIGN_TBL WHERE CAMPAIGN_ID = ?";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, campaignID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                campaign = new Campaign();
                campaign.setCampaignID(rs.getString("CAMPAIGN_ID"));
                campaign.setCampaignName(rs.getString("CAMPAIGN_NAME"));
                campaign.setStartDate(rs.getDate("START_DATE"));
                campaign.setEndDate(rs.getDate("END_DATE"));
                campaign.setTargetAmount(rs.getBigDecimal("TARGET_AMOUNT"));
                campaign.setStatus(rs.getString("STATUS"));
                return campaign;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
		return null;
        
    }
    public List<Campaign> viewAllCampaigns() {
        List<Campaign> campaigns = new ArrayList<>();
        String sql = "SELECT * FROM CAMPAIGN_TBL";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Campaign campaign = new Campaign();
                campaign.setCampaignID(rs.getString("CAMPAIGN_ID"));
                campaign.setCampaignName(rs.getString("CAMPAIGN_NAME"));
                campaign.setStartDate(rs.getDate("START_DATE"));
                campaign.setEndDate(rs.getDate("END_DATE"));
                campaign.setTargetAmount(rs.getBigDecimal("TARGET_AMOUNT"));
                campaign.setStatus(rs.getString("STATUS"));

                campaigns.add(campaign);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return campaigns;
    }
    public boolean insertCampaign(Campaign campaign) {

        String sql = "INSERT INTO CAMPAIGN_TBL " +
                     "(CAMPAIGN_ID, CAMPAIGN_NAME, START_DATE, END_DATE, TARGET_AMOUNT, STATUS) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, campaign.getCampaignID());
            ps.setString(2, campaign.getCampaignName());
            ps.setDate(3, campaign.getStartDate());
            ps.setDate(4, campaign.getEndDate());
            ps.setBigDecimal(5, campaign.getTargetAmount());
            ps.setString(6, campaign.getStatus());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateCampaignStatus(String campaignID, String status) {

        String sql = "UPDATE CAMPAIGN_TBL SET STATUS = ? WHERE CAMPAIGN_ID = ?";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setString(2, campaignID);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

