package com.donate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.donate.bean.Donor;
import com.donate.util.DBUtil;

public class DonorDAO {
    public Donor findDonor(String donorID) {
        Donor donor = new Donor();
        Connection con = DBUtil.getDBConnection();
        String sql = "SELECT DonorID, FullName, Email, Mobile, City, Status FROM DONOR_TBL WHERE DonorID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, donorID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                donor.setDonorID(rs.getString("DonorID"));
                donor.setFullName(rs.getString("FullName")); 
                donor.setEmail(rs.getString("Email"));
                donor.setMobile(rs.getString("Mobile"));
                donor.setCity(rs.getString("City"));         
                donor.setStatus(rs.getString("Status")); 
                return donor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public List<Donor> viewAllDonors() {
        List<Donor> donors = new ArrayList<>();
        Connection con = DBUtil.getDBConnection();
        String sql = "SELECT DonorID, FullName, Email, Mobile, City, Status FROM DONOR_TBL";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                Donor donor = new Donor();
                donor.setDonorID(rs.getString("DonorID"));
                donor.setFullName(rs.getString("FullName"));
                donor.setEmail(rs.getString("Email"));
                donor.setMobile(rs.getString("Mobile"));
                donor.setCity(rs.getString("City"));        
                donor.setStatus(rs.getString("Status"));     
                donors.add(donor);
            }
            return donors;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertDonor(Donor donor) {
        Connection con = DBUtil.getDBConnection();
        String sql = "INSERT INTO DONOR_TBL VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, donor.getDonorID());
            ps.setString(2, donor.getFullName());
            ps.setString(3, donor.getEmail());
            ps.setString(4, donor.getMobile());
            ps.setString(5, donor.getCity());
            ps.setString(6, donor.getStatus());
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDonorStatus(String donorID, String status) {
        Connection con = DBUtil.getDBConnection();
        String sql = "UPDATE DONOR_TBL SET Status = ? WHERE DonorID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, donorID);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDonor(String donorID) {
        Connection con = DBUtil.getDBConnection();
        String sql = "DELETE FROM DONOR_TBL WHERE DonorID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, donorID);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
