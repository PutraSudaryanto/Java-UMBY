/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

/**
 *
 * @author Putra Sudaryanto
 */
import java.sql.*;
import java.util.*;
import dbase.Database;
import model.DistrictModel;

public class DistrictPage {
    private Connection connection;
    
    public DistrictPage() {
        connection = Database.getConnection();
    }
    
    public void find(DistrictModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT `district_id` FROM `ommu_core_zone_districts` WHERE `mfdonline`=?");
            ps.setString(1, model.getMfdonline());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) { // found        
                updateByPk(model);
            } else {
                insert(model);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }
    
    public DistrictModel findByPk(String id) {
        DistrictModel model = new DistrictModel();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `ommu_core_zone_districts` WHERE `district_id`=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                model.setDistrictId(rs.getString("district_id"));
                model.setPublish(rs.getString("publish"));
                model.setCityId(rs.getString("city_id"));
                model.setDistrict(rs.getString("district_name"));
                model.setMfdonline(rs.getString("mfdonline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
    
    public List<DistrictModel> findAll() {
        List<DistrictModel> model = new ArrayList<DistrictModel>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `ommu_core_zone_districts`");
            while (rs.next()) {
                DistrictModel data = new DistrictModel();
                data.setDistrictId(rs.getString("district_id"));
                data.setPublish(rs.getString("publish"));
                data.setCityId(rs.getString("city_id"));
                data.setDistrict(rs.getString("district_name"));
                data.setMfdonline(rs.getString("mfdonline"));
                data.setCreationDate(rs.getDate("creation_date"));
                data.setModifiedDate(rs.getDate("modified_date"));
                model.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
    
    public void insert(DistrictModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT `ommu_core_zone_districts` (`publish`, `district_name`, `mfdonline`) VALUE (?, ?, ?)");
            // Parameters start with 1
            ps.setString(1, model.getPublish());
            ps.setString(2, model.getDistrict());
            ps.setString(3, model.getMfdonline());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateByPk(DistrictModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE `ommu_core_zone_districts` SET `publish`=?, `district_name`=?, `mfdonline`=? WHERE `mfdonline`=?");
            // Parameters start with 1
            ps.setString(1, model.getPublish());
            ps.setString(2, model.getDistrict());
            ps.setString(3, model.getMfdonline());
            ps.setString(4, model.getMfdonline());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteByPk(String id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM `ommu_core_zone_districts` WHERE `district_id`=?");
            // Parameters start with 1
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
