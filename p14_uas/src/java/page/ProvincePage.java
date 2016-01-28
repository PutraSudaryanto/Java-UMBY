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
import model.ProvinceModel;

public class ProvincePage {
    private Connection connection;
    
    public ProvincePage() {
        connection = Database.getConnection();
    }
    
    public void find(ProvinceModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT `province_id` FROM `ommu_core_zone_province` WHERE `mfdonline`=?");
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
    
    public ProvinceModel findByPk(String id) {
        ProvinceModel model = new ProvinceModel();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `ommu_core_zone_province` WHERE `province_id`=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                model.setProvinceId(rs.getString("province_id"));
                model.setPublish(rs.getString("publish"));
                model.setProvince(rs.getString("province"));
                model.setMfdonline(rs.getString("mfdonline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
    
    public List<ProvinceModel> findAll() {
        List<ProvinceModel> model = new ArrayList<ProvinceModel>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `ommu_core_zone_province`");
            while (rs.next()) {
                ProvinceModel data = new ProvinceModel();
                data.setProvinceId(rs.getString("province_id"));
                data.setPublish(rs.getString("publish"));
                data.setProvince(rs.getString("province"));
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
    
    public void insert(ProvinceModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT `ommu_core_zone_province` (`publish`, `province`, `mfdonline`) VALUE (?, ?, ?)");
            // Parameters start with 1
            ps.setString(1, model.getPublish());
            ps.setString(2, model.getProvince());
            ps.setString(3, model.getMfdonline());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateByPk(ProvinceModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE `ommu_core_zone_province` SET `publish`=?, `province`=?, `mfdonline`=? WHERE `mfdonline`=?");
            // Parameters start with 1
            ps.setString(1, model.getPublish());
            ps.setString(2, model.getProvince());
            ps.setString(3, model.getMfdonline());
            ps.setString(4, model.getMfdonline());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteByPk(String id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM `ommu_core_zone_province` WHERE `province_id`=?");
            // Parameters start with 1
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
