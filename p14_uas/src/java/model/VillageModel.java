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
public class VillageModel {
    String villageId, publish, districtId, village, zipcode, mfdonline;
    Date creationDate, modifiedDate;
    
    public String getVillageId() {
        return villageId;
    }
    public void setVillageId(String village_id) {
        this.villageId = village_id;
    }
    
    public String getPublish() {
        return publish;
    }
    public void setPublish(String publish) {
        this.publish = publish;
    }
    
    public String getDistrictId() {
        return districtId;
    }
    public void setDistrictId(String district_id) {
        this.districtId = district_id;
    }
    
    public String getVillage() {
        return village;
    }
    public void setVillage(String village_name) {
        this.village = village_name;
    }
    
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
