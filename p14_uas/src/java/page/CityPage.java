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
import model.CityModel;

public class CityPage {
    private Connection connection;
    
    public CityPage() {
        connection = Database.getConnection();
    }
    
    public void find(CityModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT `city_id` FROM `ommu_core_zone_city` WHERE `mfdonline`=?");
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
    
    public CityModel findByPk(String id) {
        CityModel model = new CityModel();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `ommu_core_zone_city` WHERE `city_id`=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                model.setCityId(rs.getString("city_id"));
                model.setPublish(rs.getString("publish"));
                model.setProvinceId(rs.getString("province_id"));
                model.setCity(rs.getString("city"));
                model.setMfdonline(rs.getString("mfdonline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
    
    public List<CityModel> findAll() {
        List<CityModel> model = new ArrayList<CityModel>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `ommu_core_zone_city`");
            while (rs.next()) {
                CityModel data = new CityModel();
                data.setCityId(rs.getString("city_id"));
                data.setPublish(rs.getString("publish"));
                data.setProvinceId(rs.getString("province_id"));
                data.setCity(rs.getString("city"));
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
    
    public void insert(CityModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT `ommu_core_zone_city` (`publish`, `city`, `mfdonline`) VALUE (?, ?, ?)");
            // Parameters start with 1
            ps.setString(1, model.getPublish());
            ps.setString(2, model.getCity());
            ps.setString(3, model.getMfdonline());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateByPk(CityModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE `ommu_core_zone_city` SET `publish`=?, `city`=?, `mfdonline`=? WHERE `mfdonline`=?");
            // Parameters start with 1
            ps.setString(1, model.getPublish());
            ps.setString(2, model.getCity());
            ps.setString(3, model.getMfdonline());
            ps.setString(4, model.getMfdonline());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteByPk(String id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM `ommu_core_zone_city` WHERE `city_id`=?");
            // Parameters start with 1
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
