/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Putra Sudaryanto
 */
public class DistrictModel {
    String districtId, publish, cityId, districtName, mfdonline;
    Date creationDate, modifiedDate;
    
    public String getDistrictId() {
        return districtId;
    }
    public void setDistrictId(String district_id) {
        this.districtId = district_id;
    }
    
    public String getPublish() {
        return publish;
    }
    public void setPublish(String publish) {
        this.publish = publish;
    }
    
    public String getCityId() {
        return cityId;
    }
    public void setCityId(String city_id) {
        this.cityId = city_id;
    }
    
    public String getDistrict() {
        return districtName;
    }
    public void setDistrict(String district_name) {
        this.districtName = district_name;
    }
    
    public String getMfdonline() {
        return mfdonline;
    }
    public void setMfdonline(String mfdonline) {
        this.mfdonline = mfdonline;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creation_date) {
        this.creationDate = creation_date;
    }
    
    public Date getModifiedDate() {
        return modifiedDate;
    }
    public void setModifiedDate(Date modified_date) {
        this.modifiedDate = modified_date;
    }
    
}
