/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Putra Sudaryanto
 */

import java.util.Date;

public class UserModel {
    String uname, password, email;
    Date registeredon;
    
    //put getter and setter here
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getRegisteredon() {
        return registeredon;
    }
    public void setRegisteredon(Date registeredon) {
        this.registeredon = registeredon;
    }
    
}
