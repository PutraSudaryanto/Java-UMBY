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
public class ProvinceModel {
    String provinceId, publish, province, mfdonline;
    Date creationDate, modifiedDate;
    
    public String getProvinceId() {
        return provinceId;
    }
    public void setProvinceId(String province_id) {
        this.provinceId = province_id;
    }
    
    public String getPublish() {
        return publish;
    }
    public void setPublish(String publish) {
        this.publish = publish;
    }
    
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
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
