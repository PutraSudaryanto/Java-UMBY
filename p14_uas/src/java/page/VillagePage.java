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
import model.VillageModel;

public class VillagePage {
    private Connection connection;
    
    public VillagePage() {
        connection = Database.getConnection();
    }
    
    public void find(VillageModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT `village_id` FROM `ommu_core_zone_village` WHERE `mfdonline`=?");
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
    
    public VillageModel findByPk(String id) {
        VillageModel model = new VillageModel();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `ommu_core_zone_village` WHERE `village_id`=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                model.setVillageId(rs.getString("village_id"));
                model.setPublish(rs.getString("publish"));
                model.setDistrictId(rs.getString("district_id"));
                model.setVillage(rs.getString("village_name"));
                model.setZipcode(rs.getString("zipcode"));
                model.setMfdonline(rs.getString("mfdonline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
    
    public List<VillageModel> findAll() {
        List<VillageModel> model = new ArrayList<VillageModel>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `ommu_core_zone_village`");
            while (rs.next()) {
                VillageModel data = new VillageModel();
                data.setVillageId(rs.getString("village_id"));
                data.setPublish(rs.getString("publish"));
                data.setDistrictId(rs.getString("district_id"));
                data.setVillage(rs.getString("village_name"));
                data.setZipcode(rs.getString("zipcode"));
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
    
    public void insert(VillageModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT `ommu_core_zone_village` (`publish`, `village_name`, `zipcode`, `mfdonline`) VALUE (?, ?, ?, ?)");
            // Parameters start with 1
            ps.setString(1, model.getPublish());
            ps.setString(2, model.getVillage());
            ps.setString(3, model.getZipcode());
            ps.setString(4, model.getMfdonline());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateByPk(VillageModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE `ommu_core_zone_village` SET `publish`=?, `village_name`=?, `zipcode`=?, `mfdonline`=? WHERE `mfdonline`=?");
            // Parameters start with 1
            ps.setString(1, model.getPublish());
            ps.setString(2, model.getVillage());
            ps.setString(3, model.getZipcode());
            ps.setString(4, model.getMfdonline());
            ps.setString(5, model.getMfdonline());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteByPk(String id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM `ommu_core_zone_village` WHERE `village_id`=?");
            // Parameters start with 1
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
